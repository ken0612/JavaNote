# Multithreading 
* 多線程處理，可以同時執行多個程式
* 可以透過extends Thread 使class 變成多線程程式
* 受限於單一繼承，也可以使用implement Runnable來使class變成多線程程式
* 優點：
    1. 優化程式執行效率
    2. 共享資源可優化記憶體使用
* 缺點：
    1. 需要注意Race condition問題
    2. 程式執行順序不確定
    3. Deadlock問題
```java
public class Main{

    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter("thread1"));
        Thread thread2 = new Thread(new NumberPrinter("thread2"));
        //建立multithread程式時，一定要用Thread建立新物件
        //若物件使用Runnable時，需要先將該物件以一個Thread建立

        thread1.start();
        thread2.start();
}

    private static class NumberPrinter implements Runnable {

        private final String threadName;
        private static int counter = 0;
        //因屬性為static，故會產生race condition問題。

        public NumberPrinter(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(counter);
                counter++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //Runnable裡面有一個run() method必定要被Override
        //當Thread被執行時，會自動執行run的method。
        //
    }
}

```
***
# Lock & Condition （互斥鎖）
```java
private static Lock lock = new ReentrantLock();
private static Condition notEmpty = lock.newCondition();
```
## Condition
* 若需要使用Condition，則必須與Lock掛鉤。
```java
public void tryExample(){
    lock.lock();
    notEmpty.await()
    lock.unlock();
    //使用Condition時，必定要使用lock
}
```
* 使用```.await()```可以將現在所在的Thread進入凍結狀態。
  此時將釋放鎖，也就是說被lock住的區間將會被解鎖，其中的資源可以被其他Thread調用，直至其他Thread透過.signalAll()將其喚醒。
## Lock
* Lock為一個物件，可用一個變數將其儲存。
* 通常一個鎖只會有一把鑰匙，所以將Lock設定成static（靜態）較佳。
* 設定Lock 是否為static與否，取決於設計需求。當一個Lock處於static狀態時，當該物件被重複創建時，會無法同時調用該Lock，直到其中一個Object解鎖後，另一個物件方可使用該Lock。反之如果Lock並非為static狀態，則物件被創立後，每個物件都有自己獨立的鎖，故不會導致Race condition的問題。