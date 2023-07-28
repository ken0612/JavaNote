public class Main{

    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter());
        Thread thread2 = new Thread(new NumberPrinter());

        thread1.start();
        thread2.start();
}

    private static class NumberPrinter implements Runnable {
        private static int counter = 0;
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
    }
}