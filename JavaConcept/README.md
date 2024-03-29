# Java 基本概念
* Object(物件)
  當一個Class被實例化(instantiation)後稱之為物件，
  此時在記憶體中已經有實體位置。
* Class（類別）
  泛指所有類別，通常每一個.java的檔案都是一個Class,
  在尚未被實例化之前，在記憶體中沒有實際位置。
* Inheritance（繼承）
  一個Class可以繼承一另外一個Class，可以直接使用另一Class的方法。
  可以達到程式碼重複利用的功能。
* Polymorphism（多型）
  可以透過父類別直接調用子類別的方法，
  同一種方法在不同對象上可以表現出不同的行為
* Abstraction（抽象）
  1. Abstract class (抽象類別) 使用extends來串接
    * 允許實例變數(Instance varyible)存在
    * 允許建構子存在
    * 允許完整or不完整的方法(method)存在
  2. Interface （介面） 使用implement 來串接
    * 不允許實例變數存在（會變成常數）
    * 方法不能標記為final或private（因為必須被Override）
    * 介面本身無法被實例化
    * 任何呼叫Interface的class都必須補齊Interface的method
* Encapsulation（封裝）
  一個class就像是膠囊一般，裡面包著所有的程式碼，
  通常會將class裡面的特定變數設定為private屬性，
  並透過getter與setter更改變數。
# Java 基本概念
* Object(物件)
  當一個Class被實例化(instantiation)後稱之為物件，
  此時在記憶體中已經有實體位置。
* Class（類別）
  泛指所有類別，通常每一個.java的檔案都是一個Class,
  在尚未被實例化之前，在記憶體中沒有實際位置。
* Inheritance（繼承）
  一個Class可以繼承一另外一個Class，可以直接使用另一Class的方法。
  可以達到程式碼重複利用的功能。
* Polymorphism（多型）
  可以透過父類別直接調用子類別的方法，
  同一種方法在不同對象上可以表現出不同的行為
* Abstraction（抽象）
  1. Abstract class (抽象類別) 使用extends來串接
    * 允許實例變數(Instance varyible)存在
    * 允許建構子存在
    * 允許完整or不完整的方法(method)存在
  2. Interface （介面） 使用implement 來串接
    * 不允許實例變數存在（會變成常數）
    * 方法不能標記為final或private（因為必須被Override）
    * 介面本身無法被實例化
    * 任何呼叫Interface的class都必須補齊Interface的method
* Encapsulation（封裝）
  一個class就像是膠囊一般，裡面包著所有的程式碼，
  通常會將class裡面的特定變數設定為private屬性，
  並透過getter與setter更改變數。
***
# Super Keyword in Java
* Super 簡單來說就是指父類別
* 當一個subclass繼承了一個parent class，在subclass被初始化時，
subclass裡面的constructor會自動補上super()。
* 當一個物件有繼承關係時，subclass物件被創建時，在constructor中會自動去創建一個parent class。
```java
public class Animal{
    
}
public class Dog extends Animal{
    Dog(){
        super()//如果沒有寫，在Complie階段必定會被自動補上
    }
}
```
# Code reuse

```Java
public class Person{
    private String name;
    private int age;
    Person(String name,int age){
    this.name=name;
    this.age=age;
}

public class Emp extends Person{
    private int salary
    Emp(String name,int age,int salary){
        super(name,age);
        this.salary=salary;
    }
}
```
* 可以透過subclass的constructor設定參數，並將參數直接傳回給parent class。