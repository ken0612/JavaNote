# Abstract class 與 Interface 區別
* Abstract class 可以含有:
  1.建構子(Constructor)
  2.實例變數（Instance Variable) 
  3.抽象方法（Abstract method) 
  4.需要使用extends繼承，Java只提供單一繼承功能。

* Interface 只能含有:
  1.常數(CONSTANTS)
  任何變數在Interface宣告之後都會預設被設定為final static 狀態。
  2.所有的method都不能填寫內容
  4.需要使用implement來繼承，一個class可以implement多個Interface
***
# Throw and Throws 
* 可以在一個method後面寫上Throws Exception，讓使用其method的人接手處理該Exception狀況。
* 可以在一個method裡面寫上throw new Exception，強制讓method拋出一個Exception。
* 直接拋出Exception代表所有類型的Exception，若需要個別針對不同種類的Exception進行處理則不可使用Exception拋出。
```java
public class ThrowsSample {

    public static void main(String[] args) {
        try {
            performOperation();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void performOperation() throws IOException {
        // 假設在這個方法中可能會發生 IOException，但不在此處處理，而是由呼叫此方法的程式碼處理
        throw new IOException("I/O Exception occurred.");
    }
}
``` 
***

# synchronized 與 transient
* 避免在mulithread處理程式時發生Race condition的問題
* synchronized 用於方法
* transient 用於變數
```java
import java.io.Serializable;

class MySerializableClass implements Serializable {
    // transient 修飾的成員變數
    private transient int sensitiveData;

    // synchronized 修飾的方法
    public synchronized void synchronizedMethod() {
        // 這個方法的程式碼在同一時間只能被一個執行緒進入
    }
}
```
***
