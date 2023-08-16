# Binary operating（二元運算）
## 比對時是使用二進制！！！！
* ^ XOR 
    格式：a^b
```java
//當兩個位元不同時為1，相同時為0
1^0=1
1^1=0
0^0=0
//分隔線
在實際運用中，可以使用XOR去針對數值是否重複進行檢查
int[] arr= {1,1,0,0,4}
int result=0;
for(int element :arr){
    result ^= element;
}
//運算過程
0^=1=1;
1^=1=0;
0^=0=0;
0^=0=0;
0^=4=4;
```
* | OR
    格式:a|b
```
//當兩個位元有其中一個為true則為true，反之
```
* & AND 
```
//當兩個元素為true才為true

```
* ~ NOT
//


* OR 運算符執行位元級別的 OR 運算，其中至少有一個位元為 1，結果位元為 1。
範例：
```java
int a = 5; // 二進制：0101
int b = 3; // 二進制：0011
int resultOr = a | b; // 位元運算 OR
System.out.println(resultOr); // 輸出結果為 7，二進制：0111
```

* AND（&）運算符：
AND 運算符執行位元級別的 AND 運算，兩個位元都為 1 時，結果位元才為 1。
範例：
```java
int a = 5; // 二進制：0101
int b = 3; // 二進制：0011
int resultAnd = a & b; // 位元運算 AND
System.out.println(resultAnd); // 輸出結果為 1，二進制：0001

```
* XOR（^）運算符：
XOR 運算符執行位元級別的 XOR 運算，兩個位元不同時為 1，相同時為 0。
範例：
```java
int a = 5; // 二進制：0101
int b = 3; // 二進制：0011
int resultXor = a ^ b; // 位元運算 XOR
System.out.println(resultXor); // 輸出結果為 6，二進制：0110
```
* NOT 運算符執行位元級別的 NOT 運算，將位元取反，0 變為 1，1 變為 0。
範例：
```java
int a = 5; // 二進制：0101
int resultNot = ~a; // 位元運算 NOT
System.out.println(resultNot); // 輸出結果為 -6（取反後的二進制：1010）

```
