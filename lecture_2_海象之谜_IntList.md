# 海象之谜

##### java的原生类型和引用类型

java有8种原生类型（primitive type），包括：byte、short、int、long、float、double、boolean、char这8大类型，除此之外，其余所有类型都是引用类型（reference type）。

##### 声明变量（declare variables）

```java
int x;
double y;
x = -1431195969;
y = 567213.112;
```

在前两行，即声明x和声明y，java将在内存中分配一个连续32位的内存空间和一个连续64位的空间分别给x和y，3到4行的等式将其内存空间分别填上了值。

##### 等号黄金法则（The Golden Rule of Equals）

**等号在java中表示的意义是：位复制**

##### 对象实例化过程（Object Instantiation）与引用变量声明（Reference Variable Declaration）

```java
new Warlus(1000,15.0);
```

利用new操作符实例化对象，并且采用constructor分配一个32+64位的内存空间存储该对象，**最终由new操作符返回该对象的64位地址**

```java
Warlus sonmeWarlus;
```

当我们声明一个任何引用类型（Walrus、Dog、Planet、array 等）的变量时，Java 都会分配一个 64 位的盒子，不管是什么类型的对象。64 位框不包含有关海象的数据，而是包含海象在内存中的地址。

```java
Warlus someWarlus;
someWarlus = new Warlus(1000,15.0);
```

##### 破解海象之谜

因此答案一目了然了，两个原生类型相等是将x的所有位（其值）赋值给y，并没有复制地址，因此改变任何一个都不影响另一个：

```java
int x=0;
double y=1;
y=x;
x=1;
```

两个引用变量相等是共享了其指向对象的地址，之后依靠任意一个引用变量调用方法或者public属性去对对象做出更改，使用另一个引用变量去访问相同的对象，得到的结果肯定是已经被改变了的。完整的海象之谜以及java值传递理解测试的代码如下。

##### java中的值传递

很简单，如果往函数中传递的是原生类型变量，则该函数执行完成后对原先主函数中的原生类型变量没有任何影响，但如果往函数中传递的是引用类型变量，则其实传递的是所指向对象的地址，当函数执行完成后，如果有改变对象属性的操作，则主函数中对应的对象会被改变。

完整的海象之谜以及java值传递理解测试的代码如下。

```java
/**
 * @author Li Zezhong
 * @create 2021-12-02 15:29
 */

public class lecture_1 {
    public static void main(String[] args) {
        Warlus x = new Warlus(1000,15.0);
        Warlus y = new Warlus(500,10.0);
        y = x;
        y.weight = 8000;
        y.tusksize = 20.0;
        int i = 10;
        System.out.println(x.toString());
        System.out.println(x.toString());
        Warlus.doStuff(x,i);
        System.out.println(x.toString());
        System.out.println(i);
        
        int [] x,y;
        x = new int[] {1,2,3,4,5};
        y = x;
        System.out.println(Arrays.toString(y));
        x[0] = 0;
        System.out.println(Arrays.toString(y));
        x = new int [] {-1,2,5,4,99};
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }
}

class  Warlus{
    int weight;
    double tusksize;
    public Warlus(int w,double ts){
        this.weight = w;
        this.tusksize = ts;
    }
    public String toString(){
        return String.format("weight %d,tusk size %.2f",this.weight,this.tusksize);
    }
    public static void doStuff(Warlus W,int x){
        W.weight = W.weight-5;
        x = x -5;
    }
}
```

**有个问题一定要搞懂，即：你是选择构建静态方法还是动态方法？这取决于你这个类是否不同对象调用这个方法时期望得到的值是否一样？如果不一样，就只能用动态方法！**

# IntList（构建一种简易链表）

```java
public class IntList {
    public int first;
    public IntList rest;        

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
}
```

该链表可以使用如下两种方式进行嵌套定义：

（前向定义）：

```java
IntList L = new IntList(5, null);
L.rest = new IntList(10, null);
L.rest.rest = new IntList(15, null);
```

（反向定义）：

```java
IntList L = new IntList(15, null);
L = new IntList(10, L);
L = new IntList(5, L);
```

## **朴素链表的遍历方法（核心是多定义一个指针记录最初链表的位置，最后返回它即可！）**

```java
public class lecture_02_practice {
    public static void main(String[] args) {
        int [] a = new int[]{-3,5,-99};
        ListNode p = new ListNode(a[0]);
        ListNode m=p;
        for(int i=1;i<a.length;i++){
            p.next = new ListNode(a[i]);
            p = p.next;
        }
        m.print();
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    public void print(){
        ListNode p =this;
        for(;p.next!=null;p=p.next){
            System.out.println(p.val);
        }
        System.out.println(p.val);
    }
}
```

定义其对应的size()以及iterativeSize()方法以获得IntList的size，以及get(int i)方法

```java
public int size() {
        if(rest ==null){
            return 1;
        }
        return 1+rest.size();
    }
```

```java
public int iterativeSize() {
        IntList p = this;
        int size = 1;
        while(p.rest != null){
            size +=1;
            p = p.rest;
        }
        return size;
    }
```

注意：在iterativeSize方法中，规定要使用迭代方法，而不能使用递归方法，此时需要提前定义一指针p，即将this的值（当前对象的地址）传递给p，随后在while循环中执行p=p.rest的操作。**我们不能够直接写this=this.rest；这在java中是不允许的，即this是java的保留字，时刻保留着指向当前对象的地址，因此我们不能够去重新分配它，这也是我们为什么要首先定义一个指针的原因**

```java
public int get(int i) {
        if(i==0){
            return first;
        }
        return rest.get(i-1);
    }
```

**在链表中，如果希望函数不要改变代理表头，则在函数中新定义一个指针变量，它和代理表头都指向第一链表元素，再对新定义的指针变量进行后移即可，经过函数操作后，原代理表头位置不变！* ** ***（参见下方size()以及addLast()的写法）****

```java
class SLList{
    static class IntNode {        /*注意一下，这里为什么需要定义一个IntNode作为代理人？查证课程正文！  */
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public int getFirst(){          
        return this.first.item;
    }

    public void addFirst(int b){    
        /*如果没有定义IntNode，则这里就不可能有这么简单的写法！事实是：this是java的保留字，this不可直接放在等号左边，正因为定义了Intnode，所以这里放在等号左边的是this.first，是属性值this.first，而不是保留关键字this*/     
        this.first = new IntNode(b, this.first);
    }

    public void addLast(IntNode p,int x){
        if(p.next ==null) {
            p.next = new IntNode(x, null);
        } else{
            addLast(p.next,x);
        }
    }

    public void addLast(int x){
        addLast(this.first,x);
    }

    public int size(IntNode p){
        if(p.next==null){
            return 1;
        }
        return 1+size(p.next);
    }

    public int size(){
        return size(this.first);
    }
}
```

### 有关哨兵节点

```java
class SLList{
    static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    private int size;
    private IntNode sentinel;
    public SLList(int x) {
        first = new IntNode(x, null);
        sentinel = new IntNode(0,first);
        size = 1;
    }

    public SLList(){
        sentinel = new IntNode(0,null);
        first = null;
        size = 0;
    }

    public int getFirst(){
        return this.first.item;
    }

    public void addFirst(int b){
        this.sentinel.next = new IntNode(b, this.first);
        this.first = this.sentinel.next;
        this.size +=1;
    }

    public void addLast(IntNode p,int x){
        if(p.next ==null) {
            p.next = new IntNode(x, null);
        } else{
            addLast(p.next,x);
        }
    }

    public void addLast(int x){
        addLast(this.sentinel,x);
        this.size +=1;
    }

    public int size(){
        return this.size;
    }

    public void print_SLList(){
        IntNode p =this.first;
        while(p.next !=null){
            System.out.println(p.item);
            p = p.next;
        }
        System.out.println(p.item);
    }
}
```

# Discussion：pass-by-what

```java
public class Pokemon {
    public String name;
    public int level;
    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }
    public static void main(String[] args) {
        Pokemon p = new Pokemon("Pikachu", 17);
        int level = 100;
        change(p, level);
        System.out.println("Name: " + p.name + ", Level: " + p.level);
    }
    public static void change(Pokemon poke, int level) {
        poke.level = level;
        level = 50;
        poke = new Pokemon("Gengar", 1);
    }
}
```

构建一个Pokemon.java的文件，最后的输出是：

```java
Name: Pikachu, Level: 100
```

原因如下：通过地址变量改变一个对象通常只有两种方法：（1）使用`.`操作符改变对象的属性 （2）使用Methods改变对象的属性，如果只是单纯的：

```java
poke = new Pokemon("Gengar", 1);
```

则是将新对象Gengar的地址付给了poke，而旧的Pikachu地址将在函数中丢失，而并不是旧的Pikachu对象被替换为Gengar对象。

下面这一个Discussion的例子同样能够很好的说明上述问题：

```java
public class Foo {
    public int x, y;
    public Foo (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void switcheroo (Foo a, Foo b) {
        Foo temp = a;
        a = b;
        b = temp;
    }

    public static void fliperoo (Foo a, Foo b) {
        Foo temp = new Foo(a.x, a.y);
        a.x = b.x;
        a.y = b.y;
        b.x = temp.x;
        b.y = temp.y;
    }

    public static void swaperoo (Foo a, Foo b) {
        Foo temp = a;
        a.x = b.x;
        a.y = b.y;
        b.x = temp.x;
        b.y = temp.y;
    }

    public static void main (String[] args) {
        Foo foobar = new Foo(10, 20);
        Foo baz = new Foo(30, 40);
        switcheroo(foobar, baz);
        System.out.println("foobar.x="+foobar.x+" foobar.y="+foobar.y+" baz.x="+baz.x+" baz.y="+baz.y);
        System.out.println();
        fliperoo(foobar, baz);
        System.out.println("foobar.x="+foobar.x+" foobar.y="+foobar.y+" baz.x="+baz.x+" baz.y="+baz.y);
        System.out.println();
        swaperoo(foobar, baz);
        System.out.println("foobar.x="+foobar.x+" foobar.y="+foobar.y+" baz.x="+baz.x+" baz.y="+baz.y);
    }
}
```

程序输出为：

```java
foobar.x=10 foobar.y=20 baz.x=30 baz.y=40

foobar.x=30 foobar.y=40 baz.x=10 baz.y=20

foobar.x=10 foobar.y=20 baz.x=10 baz.y=20
```

# Discussion：静态方法强制改变类的属性

```java
public class Shock {
    public static int bang;
    public static Shock baby;
    public Shock() {
        this.bang = 100;
    }
    public Shock (int num) {
        this.bang = num;
        baby = starter();
        this.bang += num;
    }
    public static Shock starter() {
        Shock gear = new Shock();
        return gear;
    }
    public static void shrink(Shock statik) {
        statik.bang -= 1;
    }
    public static void main(String[] args) {
        Shock gear = new Shock(200);
        System.out.println(gear.bang);
        shrink(gear);
        shrink(starter());
        System.out.println(gear.bang);
    }
}
```

上段程序的输出是：

```java
300
99
```

这是由于在public Shock(int num)方法中存在starter()方法，而该方法是静态的，因此通过public Shock()方法强制将整个Shock类的bang属性重置为100，因此会有300的输出。

### 有关Array List以及Linked List个别方法的速度差别

链表（Linked List）的`get`方法的执行速度实质上与整个链表大小是有关系的，这是因为链表除了收尾元素，处在中间的元素必须经过遍历操作才可以访问得到。其核心是因为计算机为链表开辟的内存是不连续的，即东一个西一个;但其`addLast`方法却非常之快，你直接在链表最后添加指针，开辟内存空间即可（该操作时间是恒定的，跟本身规模没有关系）

数组（Array，或者称之为Array List）的`get`方法是常数复杂度，与整个数组规模无关，这是因为数组开辟的内存空间是连续的，因而只需要计算偏移量即可轻松访问任何一个元素，但其`addLast`却非常慢，与本身规模有关，因为你无法改变一个已经建好的数组大小，当它的内存不够时，你只能够再建一个新的！
