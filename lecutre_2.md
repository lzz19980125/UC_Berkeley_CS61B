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

