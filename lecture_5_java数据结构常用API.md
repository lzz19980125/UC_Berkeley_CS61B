# Collection（廖雪峰）

![image-20220511205820023](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\image-20220511205820023.png)

## java大数生成

```java
int BigNumber = Integer.MAX_VALUE;
```

## java中的Arrays（数组api）

```java
//有关两个数组进行比较（即所有元素与大小是否一致）
int [] a = new int [5];
int [] b = new int [5];
System.out.println(Arrays.equals(a,b));
```

## `List<E>`

`List<E> interface`的主要方法包括：

- 在末尾添加一个元素：`boolean add(E e)`
- 在指定索引添加一个元素：`boolean add(int index, E e)`
- 删除指定索引的元素：`E remove(int index)`
- 删除某个元素：`boolean remove(Object e)`
- 获取指定索引的元素：`E get(int index)`
- 改变指定索引的元素：`E set(int index, E e)`   若成功改变，则返回原来那个被改变的值
- 获取`List`大小（包含元素的个数）：`int size()`
- 快速创建一个不可改变(immutable)的List：`E of(E e1,E e2,......)`,注意：该方法不支持传入`null`
- 判断`List`是否包含某个指定元素：`boolean contains(Object o)`
- 返回某个元素的索引：`int indexOf(Object o)`       如果元素不存在，就返回`-1`

```java
//将List<E>转换为同类型的Array,即 E [] ,通常向如下这么写：
List<Integer> nums = List.of(12, 34, 56);
Integer [] array = nums.toArray(new Integer [0]); 
//注意：toArray()方法中只需要传入一个类型相同的数组参数即可，大小直接设置为0就可以，toArray()方法将会默认把大小调整为和nums.size()相同的大小！

Integer [] arr1 = new Integer [10];
int[] arr2 = Arrays.stream(arr1).mapToInt(Integer::valueOf).toArray();
// Integer [] 转 int []    非常重要！！！！！！！！！
```

遍历`List interface`当然可以采用for循环+get()方法进行，但该方法不是最有效率的，至少对于LinkedList来说是这样的，因此最有效率的方法是采用Java封装好的Iterator去进行遍历：

```java
for(Iterator<String> it = a.iterator();it.hasNext();){
            String s = it.next();
            System.out.println(s);
        }
```

或者写的可以更简单一些：

```java
for (String s : list) {
            System.out.println(s);
        }
```

## `Map<K,V>`

`Map<K,V> interface`的主要方法包括：

- 将`<K> key`和`<V> value`建立映射关系：`V put(K key, V value)`    **注意：该方法的返回值是之前旧的value值，如果之前该`key`和`value`没有建立映射关系，则返回`null`**
- 通过`<K> key`查找对应的`<V> value`：`V get(Object key)`
- 删除`Map`中的映射关系`<K> key <V> value` `V remove(Object key)` **该方法输入键，返回被删除的对应的值，如果本来就不存在这个映射，则返回`null`**
- 查询`Map`中是否存在健`<K> key`：`boolean containsKey(Object key)`
- 查询`Map`中是否存在值`<V> value`：`boolean containsValue(Object value)`
- 查询`Map`中一共包含多少对映射关系`<K> key <V> value`：`int size()`
- 返回`Map`中所有`key`组成的`Set`:`Set<K> keySet()`
- 返回`Map`中所有`value`的值：`Collection<V> values()` **注意：如果`Map`中本身包含多个`key`都指向同一个`value`，则返回的结果仍然是将这个`value`重复多遍，结果并不是以`Set`呈现的！**
- 返回`Map`中所有`<K> key <V> value`的映射：`Set<Map.Entry<K, V>> entrySet()`

### Entry<K, V>

`Interface Entry<K, V>`表示`Map`中的一对映射关系：

- 得到该映射关系的`key`值: `K getKey()`
- 得到该映射关系的`value`值: `V getValue()`
- 改变该映射关系的`value`值：`V setValue(V value)`
- 得到该映射关系的`hashcode`：`int hashcode()`

```java
//判断HashMap中是否存在key1，若不存在，增添<key1,1>映射，若存在，增添<key1,2>映射 的简单写法(很重要！)：
HashMap<Integer,Integer> map = new HashMap<>();
int key1 = 1;
map.put(key1,map.getOrDefault(key,0)+1);
```

遍历`Map<K,V>`的两种方法：

通过`keyset()`遍历`Map`对应的不重复的键集合：

```java
for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }
```

通过`entryset()`遍历`Map`对应的不重复的映射集合：

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }
```

## Set

```java
boolean add(E e) //将元素添加进Set<E>：
boolean remove(Object e) //将元素从Set<E>删除：
boolean contains(Object e) //判断是否包含元素：
int size() //查看set的大小
for(E key:set){
    ....
}  //遍历set的元素
```

### JAVA中的字符串

### char的引用类型

**在构建各种数据结构，譬如`HahsMap`等，可以直接构造`Character`类！**

### char转String

### String class

java字符串类"String"为引用类型，一旦被建立就无法更改。

以下为"String"一些常用的api：

```java
	   String s = "abcdef";
        System.out.println("length"+s.length()); //获取长度
        System.out.println("index"+s.charAt(1)); //获取索引为1位置的字符
        System.out.println("length"+s.indexOf('c')); //获取字符'c'位置的索引
        System.out.println("length"+s.indexOf("bc")); //获取字符串“bc”位置的索引
        System.out.println("length"+s.substring(1,4)); //获取索引位置为(1,4)的子串
        
        //转换————字符，大小写，替换，连接
        char [] arr = s.toCharArray(); //字符串转字符数组
        System.out.println(s.toUpperCase()); //字符串转大写
        System.out.println(s.replace('a','A')); //原字符串'a'替代为'A'
        System.out.println(s.replace("ab","AB")); //原字符串子串“ab”替代为"AB"
        System.out.println("   123   ".trim()); //将字符串前后两端空格删除
        System.out.println(s.concat("ABCD")); //原字符串后面连接“ABCD”
        System.out.println(String.valueOf(4)); //将数字转换为字符
        
        //比较—————相等，包含，开头和结尾、大小
        System.out.println(s.equals("asd")); //字符串判断相等
        System.out.println(s.equalsIgnoreCase("ABCD")); //忽略大小写判断大小
        System.out.println(s.contains("abc")); //是否包含
        System.out.println(s.startsWith("ab")); //是否以某个字符串开头
        System.out.println(s.endsWith("ab")); //是否以某个字符串结尾
        System.out.println(s.compareTo("aqw")); //比较两个字符串大小
```

### StringBuffer class & StringBuilder class

StringBuffer和StringBuilder是可以修改的字符串，其中StringBuffer是线程安全的，而StringBuilder不是线程安全的；然而StringBuilder相较于StringBuffer有速度优势，因此多数情况下仍然使用StringBuilder。以下例举其常用api：

```java
public class RunoobTest{
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder(10);
        sb.append("Runoob..");
        System.out.println(sb);  
        sb.append("!");
        System.out.println(sb); 
        sb.insert(8, "Java");
        System.out.println(sb); 
        sb.delete(5,8);
        System.out.println(sb);  
    }
}
```

![2021-03-01-java-stringbuffer](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2021-03-01-java-stringbuffer.svg)

在线程安全的要求下，还是应该使用StringBuffer：

```java
public class Test{
  public static void main(String args[]){
    StringBuffer sBuffer = new StringBuffer("菜鸟教程官网：");
    sBuffer.append("www");
    sBuffer.append(".runoob");
    sBuffer.append(".com");
    System.out.println(sBuffer);  
  }
}
```

运行结果如下：

```
菜鸟教程官网：www.runoob.com
```

StringBuffer常用api：

```java
public StringBuffer append(String s) //将指定的字符串追加到此字符序列。
public StringBuffer reverse() //将此字符序列用其反转形式取代。
public delete(int start, int end) //移除此序列的子字符串中的字符。
public deleteCharAt(int index) //移除指定位置的char
public insert(int offset, int i) //将 int 参数的字符串表示形式插入此序列中。
insert(int offset, String str) //将 str 参数的字符串插入此序列中。
replace(int start, int end, String str) //使用给定 String 中的字符替换此序列的子字符串中的字符。
char charAt(int index) //返回此序列中指定索引处的 char 值。
int indexOf(String str) //返回第一次出现的指定子字符串在该字符串中的索引。
int indexOf(String str, int fromIndex) //从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引。
int length() //返回长度（字符数）。
void setCharAt(int index, char ch) //将给定索引处的字符设置为 ch。
String substring(int start, int end) //返回一个新的 String，它包含此序列当前所包含的字符子序列。
String toString() //将StringBuffer转换为字符串形式
```

## Queue

队列实际上实现了一个先进先出的有序表。其常用api如下：

```java
Queue<E> q = new Queue<>();
int size() //获取队列长度;
boolean add(E)/boolean offer(E) //添加元素到队尾;
E remove()/E poll()  //获取队首元素并从队列中删除;
E element()/E peek()  //获取队首元素但并不从队列中删除;
```

以上api除了获取队列长度，其余每种方法都有两个方法名，这两个方法名在执行方法失败时分别对应两种不同的行为，如下表所示：

|                    | **throw Exception** | **返回false或null**  |
| :----------------: | :-----------------: | :------------------: |
|   添加元素到队尾   |     `add(E e)`      | `boolean offer(E e)` |
|  取队首元素并删除  |    `E remove()`     |      `E poll()`      |
| 取队首元素但不删除 |    `E element()`    |      `E peek()`      |

注意：不要把`null`添加到队列中，否则`poll()`方法返回`null`时，很难确定是取到了`null`元素还是队列为空。

## PriorityQueue

使用PriorityQueue，调用`remove()`/`poll()`或者`element()`/`peek()`方法，其返回的都是优先级最高的元素。也就是说，Priority能够根据内部的`compatator`机制，将目前在队列中的所有元素进行优先级的排序，按照优先级顺序将优先级最高的放在队首，优先级最低的放在队尾。对于默认的类型（即已经实现了`comparable`的类型）可以自动实现优先队列的功能，然而对于没有实现`comparable`的类型，我们在构建PQ时需要手动传入一个`comparator`类。

```java
// PriorityQueue 的constructor方法
PriorityQueue<E> pq = new PriorityQueue<E>();   //创建一个PQ
PriorityQueue<E> pq = new PriorityQueue<E>(Collection<E> c);  //创建一个集合为c的PQ
PriorityQueue<E> pq = new PriorityQueue<E>(int initialCapacity); //创建一个具有初始容量的PQ
//创建一个有comparator的PQ（最重要的constructor方法！）

PriorityQueue<Object E> pq = new PriorityQueue<Object E>(new Comparator<Object E>(){
    public int compare(E e1,E e2){
        return e1-e2;   //这是默认以最小堆实现的优先队列！
    }
}); 

PriorityQueue<Object E> pq = new PriorityQueue<Object E>(new Comparator<Object E>(){
    public int compare(E e1,E e2){
        return e2-e1;   //这是以最大堆实现的优先队列！只需要修改compare()函数的return值即可！
    }
}); 


//PQ的常用API
boolean add(E element); //向PQ添加一个元素
E  peek(); //查看PQ顶端元素
E  poll(); //删除PQ最顶端元素

/*切记，想打印PQ元素不要使用System.out.println()，将不会获得按默认顺序排序的元素结果，而是打印插入PQ时的顺序的元素*/

```

## Deque

相较于queue，Deque既能够添加元素到队尾，也能够添加元素到队首，既可以从队首获取，也可以从队尾获取。

以下表格比较了Queue和Deque的常用api及其不同：

|                    |           Queue            |                Deque                |
| :----------------: | :------------------------: | :---------------------------------: |
|   添加元素到队尾   | `add(E e) `/ `offer(E e)`  |  `addLast(E e) `/ `offerLast(E e)`  |
|  取队首元素并删除  | `E remove() `/ `E poll()`  | `E removeFirst() `/ `E pollFirst()` |
| 取队首元素但不删除 | `E element()` /` E peek()` |  `E getFirst() `/ `E peekFirst()`   |
|   添加元素到队首   |             无             | `addFirst(E e) `/ `offerFirst(E e)` |
|  取队尾元素并删除  |             无             |  `E removeLast() `/ `E pollLast()`  |
| 取队尾元素但不删除 |             无             |   `E getLast() `/ `E peekLast()`    |

## Stack

栈是一种后进先出的数据结构，常用API如下：

```java
//java中构建栈一般要这么写:
Deque<E> stack = new LinkedList<>();

//常用API:
E push(E) //把元素压栈;
E pop()   //把栈顶的元素“弹出”;
E peek()  //取栈顶元素但不弹出;
int size() //获取栈的大小
boolean isEmpty() //栈是否为空 是返回true，否返回false
```

