# Disjointed Sets

不相交集的两个操作：

1. `connect(x, y)`: connect `x` and `y`. Also known as `union`
2. `isConnected(x, y)`: returns true if `x` and `y` are connected (Also known as `Find`).

不相交集的接口文件：

```java
public interface DisjointSets {
    /** connects two items P and Q */
    void connect(int p, int q);

    /** checks to see if two items are connected */
    boolean isConnected(int p, int q); 
}
```

lecture的思路是运用Array（数组）去实现一个Disjointed Sets，其中数组的索引代表Disjointed Sets的元素，而数组的元素代表各个集合的编号，集合编号相同代表对应的索引属于同一集合。

### Quick Find

这里的`QuickFind`时间复杂度为Θ(1)

```java
public class QuickFindDS implements DisjointSets {

    private int[] id;

    /* Θ(N) */
    public QuickFindDS(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    /* need to iterate through the array => Θ(N) */
    public void connect(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == pid){
                id[i] = qid;
            }
        }
    }

    /* Θ(1) */
    public boolean isConnected(int p, int q){
        return (id[p] == id[q]);
    }
}
```

### Quick Union

lecture在Quick Union部分更改了对Disjointed Sets的定义方式，即把每一个Sets想象成一个树的形式（只是还是采用array来表达），根节点索引对应的元素值为-1，获取索引对应的元素值，再以元素值作为索引继续获取元素值，最终可遍历至每个Sets对应的根结点处。这个向上遍历至根节点的功能被lecture定义为辅助函数`find()`。

![2022-05-21_222221](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-21_222221.PNG)

```java
public class QuickUnionDS implements DisjointSets {
    private int[] parent;

    public QuickUnionDS(int num) {
        parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = i;
        }
    }

    private int find(int p) {
        while (parent[p] >= 0) {
            p = parent[p];
        }
        return p;
    }

    /* 最好情况 Θ(1)，最坏情况Θ(N) */
    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j= find(q);
        parent[i] = j;
    }

    /* 最好情况 Θ(1)，最坏情况Θ(N) */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
```

对于`QuickUnion(int p,int q)`而言，最好的结果是`p`和`q`分别为两个树的根节点，这样将其进行connect仅仅需要O(1)的时间复杂度，而最坏的情况为O(N)，如下图所示：

![9.3.3](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\9.3.3.png)

### Weighted Quick Union (WQU)

