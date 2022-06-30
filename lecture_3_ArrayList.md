# 为什么访问数组中的元素需要恒定的时间？(LinkedList以及ArrayList的区别)

在双向链表中，使用get()方法（最坏情况下要get到的元素在整个list的中间位置）最坏情况下会花费与list长度呈现线性复杂度的时间，而使用基于数组的list需要get任意元素时都只需要花费恒定时间，且非常短，这是因为ArrayList的get()方法是基于地址以及指针的。让我们说我有一个数组:int a [] = {4,5,7,10,2,3,6} 当我访问一个元素,如[3]时，该数组由存储器位置(指针)所知.访问`a[3]`可以在恒定时间内找到,因为它只是location_of_a + 3*sizeof(int).

但在双向链表中，addLast()方法直接在链表后添加一个对象就可以了，但对于ArrayList，如果需要在列表末尾新添加一个元素，就需要首先重新构建一个原来size+1的新ArrayList，然后将原ArrayList的内容全部复制进新构建的ArrayList，这样操作的耗时会比双向链表长很多！

整个简易ArrayList的代码如下：

```java
class AList<Item> {
    Item [] items;
    int size;
    public AList() {
        this.items = (Item []) new Object [100];
        this.size = 0;
    }

    private void resize(int capacity){
            Item [] a = (Item []) new Object[capacity];
            System.arraycopy(items,0,a,0,size);
            items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if(size ==items.length){
            resize(size+1);
        }
        items[size]=x;
        size +=1;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Item removeLast() {
        Item results = items[size-1];
        items[size-1]= null;             //这一句是非必要的，因为我们目前与ArrayList的所有交互都是通过size进行，因此只需要改动size即可
        size -=1;
        return results;
    }
}
```

我们的ArrayList采用泛型进行书写，在泛型中创建数组需要一种不一样的写法，不可以像下面这样进行书写：

```java
Item[] items = new Item[8];
```

而要像下面这样进行书写：

```java
Item[] items = (Item []) new Object[8];
```

尽管这样进行书写会出现编译警告，但是是微不足道的。我们所做的另一个更改是在removeLast方法中将我们“删除”的item赋值为null。 而在以前，我们没有理由将已删除的元素归零，对于通用对象，我们确实希望将我们存储的对象的引用归零。 这是为了避免“游荡”。 回想一下，Java 仅在最后一个引用丢失时才销毁对象。 如果我们未能将引用归零，那么 Java 将不会对已添加到列表中的对象进行垃圾回收。
