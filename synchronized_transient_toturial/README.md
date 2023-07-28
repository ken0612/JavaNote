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
