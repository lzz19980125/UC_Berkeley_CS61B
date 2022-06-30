# lecture 4.

### java中的方法重载(overload)

在同一个类中，两个函数只有参数不同（函数名，public static 返回类型等其余参数均相同），则此种情况称为java中的方法重载，例如：

```java
class WordUtils {
public static String longest(SLList<String> list){}
public static String longest(AList<String> list){}
}
```

当您调用 WordUtils.longest 时，Java 会根据您提供的参数类型知道要运行哪个。 如果为它提供 AList，它将调用 AList 方法，提供SLList，将调用SLList对应的方法。

### interface & implements(接口与接口继承)

接口（Interface）的特点：

- 所有的方法必须由public修饰

- 所有属性必须是public static final

- 无法实例化

- 除default方法之外，所有方法是抽象的

- 每个Class可以implements多个interface

考虑构建一个List61B.java的接口文件：

```java
public interface List61B<Item> {
    default public void print(){
        for (int i = 0; i < size(); i += 1) {
        	System.out.print(get(i) + " ");
    		}
    	System.out.println();
    }
    public void addFirst(Item x);
    public void add Last(Item y);
    public Item getFirst();
    public Item getLast();
    public Item removeLast();
    public Item get(int i);
    public void insert(Item x, int position);
    public int size();
}
```

在文件AList.java中对此接口进行实现(继承该接口)：

```java
public SLList<Item> implements List61B<Item>{
	@override
    public void addFirst(Item x){}
    @override
    public void add Last(Item y){}
    @override
    public Item getFirst(){}
    @override
    public Item getLast(){}
    @override
    public Item removeLast(){}
    @override
    public Item get(int i){}
    @override
    public void insert(Item x, int position){}
    @override
    public int size(){}
    @override
    public void print() {
    	for (Node p = sentinel.next; p != null; p = p.next) {
        	System.out.print(p.item + " ");
    	}
	}
}
```

AList与List61B是is-a的关系，接口List61B本质是一种声明或者规定，即只要是List61B就应该具备所定义的诸多方法。接口中除具有default签名的方法之外，只对其余这些方法的签名进行声明，至于这些方法如何实现，将由继承接口的子类自行发挥（default方法可以不需要被重写）而AList则是对List61B的一种承诺，即AList承诺具有List61B所定义的所有方法，并对每个方法进行**重写(override，也可翻译为覆盖)。**

### static type & dynamic type & dynamic method selection(静态类型 & 动态类型 &动态方法选择)以及向上转型

在如下语句中，someList是对对象SLList的一个引用变量，该引用变量的类型为List61B，称之为静态类型，而只有java程序在编译时才能够知道新建的对象为SLList类型，称之为动态类型。（如何理解上面这句话呢，就是说如果利用List61B引用一个AList类型的变量，则静态类型仍旧为List61B，而此时动态类型则变成了AList，因此从最初命名的角度看，静态类型是绝对的，而动态类型则是相对的。）利用静态父类类型的引用变量去引用子类类型的对象，这样的操作称之为java的向上转型。

```java
public static void main(String[] args) {
    List61B<String> someList = new SLList<String>();
    someList.addFirst("elk");
}
```

执行：

```java
someList.print();
```

向上转型的执行结果是执行SLList中经过override的print()方法，而不是List61B中default的print()方法。也就是说，当 Java 运行一个overrided的方法时，它会在它的动态类型中搜索适当的方法签名并运行它。**注意：这一条规则不适用于overloaded（重载）的方法！**

考虑如下在同一个class中定义的两个overloaded(重载)方法：

```java
public static void peek(List61B<String> list) {
    System.out.println(list.getLast());
}
public static void peek(SLList<String> list) {
    System.out.println(list.getFirst());
}
```

运行如下代码：

```java
SLList<String> SP = new SLList<String>();
List61B<String> LP = SP;
SP.addLast("elk");
SP.addLast("are");
SP.addLast("cool");
peek(SP);
peek(LP);
```

第一个`peek`调用的是`public static void peek(SLList<String> list)`，而第二个`peek`调用的则是`public static void peek(List61B<String> list) `，原因是java在判断overloaded方法时，只根据参数类型去判断，因此这里需要看它的静态类型，而不是动态类型！

### 继承（关键字`extends`）

与关键字`implenment`不一样，关键字`extends`继承了父类的所有members，这些members包括：

1. 所有实例(instance)和静态(static)变量
2. 所有方法(methods)
3. 所有嵌套类(nested class)

**注意：构造函数(constructor function)不是继承的！通常情况下java在子类中默认使用`super()`来进行构造，如果你不这么写，java会隐式的把它写出来。当然，如果你希望在子类的构造函数中添加一些别的东西，则不管怎样，构造函数的第一行都必须先写super(**

例子2：

定义如下Dog类（两种定义方式）：

```java
class Dog{
	public void bark() {
    	System.out.println("bark");
		}

	public void barkMany(int N) {
    	for (int i = 0; i < N; i += 1) {
        	bark();
    	}
	}
}
```

```java
class Dog{
	public void bark() {
    	barkMany(1);
		}

	public void barkMany(int N) {
    	for (int i = 0; i < N; i += 1) {
        	System.out.println("bark");
    	}
	}
}
```

定义VerboseDog类：

```java
class VerboseDog extends Dog{
	@Override
	public void barkMany(int N) {
    	System.out.println("As a dog, I say: ");
    	for (int i = 0; i < N; i += 1) {
        	bark();
    	}
	}
}
```

如果执行以下代码：

```java
Dog a= new VerboseDog();
a.barkMany(3);
```

如果利用第一种Dog class的定义，将得到正常结果：“As a dog, I say:bark bark bark” 如果利用第二种Dog class的定义，程序将陷入死循环，显然，被override过的方法在动态执行时不会执行override之前的父类中的程序，而只会执行动态类型中override后的方法。

向上转型可以使得代码的简洁性大大增强，考虑如下的定义：

```java
class Car {
    public void run() {
        System.out.println("这是父类run()方法");
    }

    public void speed() {
        System.out.println("speed:0");
    }

}

class BMW extends Car {
    @override
    public void run() {
        System.out.println("这是BMW的run()方法");
    }
	@override
    public void speed() {
        System.out.println("speed:80");
    }
}

public class Benz extends Car {
    @override
    public void run() {
        System.out.println("这是Benz的run()方法");

    }
    @override
    public void speed() {
        System.out.println("speed:100");
    }

    public void price() {
        System.out.println("Benz:800000$");
    }

    public static void main(String[] args) {
        show(new Benz());//向上转型实现
        show(new BMW());
    }

    public static void show(Car car) {//父类实例作为参数
        car.run();
        car.speed();
    }
}
```

我们需要运行如下代码：

```java
 public static void main(String[] args) {
        show(new Benz());
        show(new BMW());
    }

    public static void show(Car car) {
        car.run();
        car.speed();
    }
```

就体现了向上转型的优点，这也体现了Java抽象编程的思想。如果此处没有向上转型，要实现show每个子类的功能，那么有几个子类就要写多少函数。代码如下：

```java
public static void main(String[] args) {
        show(new Benz());
        show(new BMW());
    }

    public static void show(Benz benz) {
        benz.run();
        benz.speed();
    }
    public static void show(BMW bmw) {
        bmw.run();
        bmw.speed();
    }
```

试想一下，一旦有很多子类，那么这个工作量将会比没有使用向上转型大很多。这也表明向上转型还有个优点就是提高了代码的简洁性。

**重点：经过向上转型之后，在利用.操作符访问时，如果访问的是对象的属性，则编译的话就是看父类，运行同样是看父类；如果访问的是方法，编译就看父类，运行则看子类；如果访问的是父类中标明的static methods，尽管子类已经进行override，但编译和运行都是看父类**

### High order function(高阶函数，HOF)

高阶函数本质上同样利用了java的向上转型操作，由于java中没有单独的函数类型，因此我们无法直接完成类似于如下python语言中的高阶函数操作：

```python
def tenX(x):
    return 10*x

def do_twice(f, x):
    return f(f(x))
```

我们转而靠接口而达到上述效果，首先定义接口文件Hight_order_fun.java:

```java
public interface Hight_order_fun {
    public int apply(int x);
}
```

其次进行如下定义：

```java
class Tenx implements Hight_order_fun{

    @Override
    public int apply(int x) {
        return 10*x;
    }
}
```

```java
public static int do_twice(Hight_order_fun f, int x){
        return f.apply(f.apply(x));
    }
```

最后在public static void main()函数中进行如下运行操作：

```java
System.out.println(do_twice(new Tenx(),2));
```

其实在传参的过程中实质为：

```java
Hight_order_fun f = new Tenx();
```

即利用了java的向上转型而达到了高阶函数操作。

### 父类继承(extends 关键字)

通过使用 extends 关键字，子类继承父类的所有成员。 “成员”包括： 所有实例和静态变量，所有方法，所有嵌套类；**注意constructor methods不能够被继承，private members不能被子类直接访问。但虽然constructor methods不是继承的，但 Java 要求所有constructor methods都必须以调用其超类的constructor methods之一开始。**

### Type Checking and Casting（铸造，或者称之为向下转型）

考虑这样一个问题，我们想构造一种方法，该方法可以根据两个对象的属性进行比较，并返回比较结果较大的那一个对象对应的属性。注意：该方法可以实现对任意类型对象的比较。由于各个类型的对象属性需要不同的操作符，譬如两个int比较可以使用>或者<进行比较，而两个String类型却无法这样比较，因此为代码简洁，我们需要借助接口的帮助同意实现compareTo()

首先定义Ourcomparable的接口：

```java
public interface Ourcomparable {
    public int compareTo(Object o);
}
```

其次进行如下书写：

```java
public class lecture4_3 {
    public static void main(String[] args){
        Dog[] dogs = new Dog[]{new Dog("Elyse", 3), new Dog("Sture", 9), new Dog("Benjamin", 15)};
        ((Dog) max(dogs)).bark();
    }

    public static Ourcomparable max(Ourcomparable[] items){
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }
}

class Dog implements Ourcomparable{
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    @Override
    public int compareTo(Object o) {
        Dog a = (Dog) o;
        if (this.size < a.size) {
            return -1;
        } else if (this.size == a.size) {
            return 0;
        }
        return 1;
    }
}
```

在上述代码中，主函数中定义好的dogs首先传入max()方法，注意，此时已经实现了Dog class向Ourcomparable class的向上转型，紧接着在max()方法内循环调用compareTo()方法，由于该方法被Dog class进行过override，因此转入Dog class的compareTo()中，此时items[maxDex]又作为参数转换为Object o，并且定义了Dog a = (Dog) o;这一句话实现了Ourcomparable class朝Dog class的向下转型。在整个max()方法调用完成后，返回Ourcomparable类型的items[maxDex]，此时返回值是一个地址，而我们需要得到它的name属性值，因此有((Dog) max(dogs)).bark();即再次对Ourcomparable class朝Dog class进行向下转型，并使用Dog class中的bark()进行其属性的输出。

由上述分析可知，Dog class继承了Ourcomparable class，将Dog class的对象赋给Ourcomparable class的引用变量属于向上转型，在这一步之后，如果我们希望获得Ourcomparable class的引用变量指向对象的size或者name等属性值，这并不能直接实现，因为此时该对象已经被向上转型为Ourcomparable class，而Ourcomparable class并没有定义size或者name等属性值，因此此时我们需要在其之前加(Dog)以进行向下转型。也就是说，向下转型（Casting）相当于是向上转型的还原操作。而Ourcomparable class还可能被具有其他属性值的cat class，whale class等诸多class同时继承，Ourcomparable class不可能平白无故的就向下转型成上述具有不同属性或者方法的class，这会导致不能够通过编译，如下是例子：

定义一个类VengefulSLList继承自SLList，则如下语句将完全正确：

```java
SLList<Integer> sl = new VengefulSLList<Integer>();
```

如下语句将会发生编译错误：

```java
VengefulSLList<Integer> vsl = new (VengefulSLList<Integer>) SLList<Integer>();
```

```java
Exception in thread "main" java.lang.ClassCastException: class SList cannot be cast to class VengefulSLList (SList and VengefulSLList are in unnamed module of loader 'app')
	at lecture4_2.main(lecture4_2.java:14)
```

### 内置Comparable接口

事实上，java内置的Comparable接口与我们构建的Ourcomparable接口仅有细微的差别，其内置接口定义如下：

```java
public interface Comparable<Item> {
    public int compareTo(Item o);
}
```

即该接口使用了泛型。采用该设计定义我们的Ourcomparable接口，并对上面的代码进行重写，则有：

```java
public class lecture4_3 {
    public static void main(String[] args){
        Dog[] dogs = new Dog[]{new Dog("Elyse", 3), new Dog("Sture", 9), new Dog("Benjamin", 15)};
        max(dogs).bark();
    }

    public static Dog max(Dog[] items){
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }
}

class Dog implements Ourcomparable<Dog>{
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    @Override
    public int compareTo(Dog o) {
        if (this.size < o.size) {
            return -1;
        } else if (this.size == o.size) {
            return 0;
        }
        return 1;
    }
}
```

此种写法避免了繁琐的向上和向下转型。

### Comparator

之前的Comparable实现了根据不同类型对象的size进行比较，本次我们借助在类中定义嵌套类（继承自java内部接口Comparator），从而实现对不同类型对象的任意属性进行比较：

```java
public class lecture4_3 {
    public static void main(String[] args){
        Dog[] dogs = new Dog[]{new Dog("Elyse", 3), new Dog("Sture", 9), new Dog("Benjamin", 15)};
        max(dogs).bark();
        Comparator<Dog> nc = Dog.getNameComparator();
        System.out.println(nc.compare(dogs[0],dogs[2]));
    }

    public static Dog max(Dog[] items){
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }
}

class Dog implements Comparable<Dog>{
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    @Override
    public int compareTo(Dog o) {
        return this.size - o.size;
    }

    private static class NameComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}
```

可以看到，在上述Dog class中定义嵌套类private static class NameComparator implements Comparator<Dog>，其次对compare方法进行override，并在Dog class中定义获取NameComparator的public getNameComparator()方法。注意：java中本就有compareTo方法，此时此时输入参数类型为String，因此java会根据既有的（专为String设计的）compareTo方法进行比较，而不是依照我们override的compareTo方法进行比较。当输入参数类型为int，还是依照我们override的compareTo方法去比较。

