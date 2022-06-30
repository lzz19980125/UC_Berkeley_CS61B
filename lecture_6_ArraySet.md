# 创建自己的`Set61B_ArraySet`

这里先说句题外话，提一下Java中的Iterator接口：

```java
public interface Iterator<E> {
    boolean hasNext();   /* 如果还有剩余没处理过的元素，则返回true，如果所有元素都已经处理过，则返回false*/
    E next();  /* 获得下一个元素，并将Iterator向前再推进一项 */
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
```

再说一下java中的Iterablej接口：

```java
public interface Iterable<T> {  /*实现此接口可使你自己定义的class被for each增强循环的写法所支持*/
	Iterator<T> iterator();
}
```

接口文件：`Set61B`：

```java
public interface Set61B <E>{
    boolean add(E value);
    boolean contains(E value);
    int size();
}
```

实现文件：`Set61B_ArraySet`

```java
/* 想要将新定义的类赋予for(:)的增强遍历写法，首先需要implements Iterable<E>接口*/
public class Set61B_ArraySet<E> implements Set61B<E>,Iterable<E>{
    private E [] items;
    private int size;

/* Iterable<E>接口中定义的规范：其返回值需要是Iterator<E>接口的一个实现*/
    public Iterator<E> iterator() {
        return new ArraySetIterator();
    }

/* 实现Iterator<E>接口*/
    private class ArraySetIterator implements Iterator<E>{
        private int position;

        public ArraySetIterator(){
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public E next() {
            E result = items[position];
            position +=1;
            return result;
        }
    }

    public Set61B_ArraySet(){
        items = (E[]) new Object[100];
        this.size = 0;
    }

    @Override
    public boolean add(E value) {
        /* 当添加元素为null时，null本身无法调用方法，因此会出现错误，这里需要增加抛出异常的一段代码 */
        if (value == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if(contains(value)){
            return false;
        }
        items[size]=value;
        this.size +=1;
        return true;
    }

    @Override
    public boolean contains(E value) {
        for (int i = 0; i < size; i += 1) {
            if(items[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder("{");
        int i=0;
        for(;i<size-1;i++){
            result.append(items[i].toString());
            result.append(", ");
        }
        result.append(items[i].toString());
        result.append("}");
        return result.toString();
    }
}
```

**Object.equals()**

`equals()` 和` ==` 在 Java 中有不同的行为。 `== `检查两个对象是否实际上是内存中的同一个对象。请记住，按值传递！ `== `检查两个盒子是否包含相同的东西。对于`primitave`，这意味着检查值是否相等。对于`class`，这意味着检查地址/指针是否相等。默认情况下，`equals(Object o)`的功能等同于`==`,它检查 this 的内存地址是否与 o 相同。但是，我们可以覆盖它以任何我们希望的方式定义相等！例如，要使两个 `Arraylist `被视为相等，它们只需要以相同的顺序具有相同的元素。

对`Set61B_ArraySet`的equals方法进行覆写，我们有：

```java
public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Set61B_ArraySet<E> o = (Set61B_ArraySet<E>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (E item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }
```

