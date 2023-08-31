# Collection

Collection在java中是一個框架，用於提供一架構來儲存和操作一組物件

Collection可以實現對資料執行的所有操作，例如：搜尋、排序、插入、操作、刪除。
裡面提供多個介面
Interface：Set,List,Queue,Dequeue
Class:ArrayList,Vector,LinkedList,PriorityQueue,HashSet,LinkedHashSet,TreeSet

## Iterator（迭代器）
製作一個物件，把列表放進去，
透過該物件的方法可以直接進行迭代
```java
List<Integer> arr = new ArrayList();
Iterator itr = arr.iterator();
while(itr.hasNext()){
    System.out.println(itr.next());
}
```

## ArrayList<> 
非同步，在單一線程中執行效率較高

## Vector<>
同步，但執行效率較差

## Stack<> 堆疊
使用push塞資料，使用pop將最後一筆資料刪除，是一種後進先出的概念。

## Queue 
跟Stack相反，是一種先進先出的概念。
Queue是Interface，無法直接Instance
```java
Queue<String> q1 = new PriorityQueue();  
Queue<String> q2 = new ArrayDeque();  
```
## PriortyQueue
會自動排序的列表，如果是String，會依照字典序進行排序。
可使用Comprarator進行自訂義排序
```java
//常用method
peek():返回列表頭部位置（即0)
poll():返回列表頭部位置，但會將其刪除，若列表為空，則會返回null
remove():刪除優先度最高的元素，若列表為空，則會拋出Exception
```
## Deque 介面
可以從兩側都新增或移除元素。
```java
Deque<String> deque = new ArryaDeque();
deque.add("haha");
deque.addFirst("111");
deque.addLast("222");
```

## Set 集合
不允許重複的資料被輸入
```java
//實例化方法
Set<data-type> s1 = new HashSet<data-type>();  
Set<data-type> s2 = new LinkedHashSet<data-type>();  
Set<data-type> s3 = new TreeSet<data-type>();  
```

## HashSet
元素無序，操作速度快，不保持插入順序。任何資料在集合中只能出現一次。

## LinkedHashSet
元素有序（按照插入順序），操作速度快，保持插入順序。任何資料在集合中只能出現一次。

## SortSet
輸入的資料都依照遞增的順序進行排列。

## TreeSet
使用樹結構儲存資料。和 HashSet 一樣，TreeSet 也只有唯一的元素，但存取和擷取速度很快。TreeSet 中的元素以遞增的順序儲存。