import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static Account account = new Account();

    public static class Account {
        private int balance = 0;
        private static Lock lock = new ReentrantLock();
        private Condition newDeposit = lock.newCondition();

        public int getBalance() {
            return this.balance;
        }

        public void deposit(int amount) {
            lock.lock();
            this.balance += amount;
            System.out.println("Deposit " + amount + "\t\t\t\t\t\t\t\t\t\t\tnow amount: " + getBalance());
            newDeposit.signalAll();
            lock.unlock();
        }

        public void withDraw(int amount) throws InterruptedException {
            lock.lock();
            try {
                while (balance < amount) {
                    System.out.println("\t\t\t\tWait for a deposit");
                    newDeposit.await();
                }
                balance -= amount;
                System.out.println("withDraw: "+amount);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }


    public static class DepositTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    account.deposit((int) (Math.random() * 10) + 5);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class WithdrawTask implements Runnable  {

        @Override
        public void run() {
            try {
                while (true) {
                    account.withDraw((int) (Math.random() * 20) + 5);
                    System.out.println("The amount is: " + account.balance);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new DepositTask());
        executorService.execute(new WithdrawTask());
        executorService.shutdown();

    }
}