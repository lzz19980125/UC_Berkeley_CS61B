# Binary Search Tree（BST）

## BST的由来

![2022-05-23_201104](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_201104.PNG)

对于上述这种ordered Linkedlist这一类ADT而言，`contains`以及`add`都需要O(N)的线性时间，因此我们考虑优化其结构，以加快其查找时间，因此引入BST。BST与Binary Search有着很强的关联关系，考虑设定一指针指向上述ADT中的中位数(即“D”)，并将“D”以前的指针反向，于是有：

![2022-05-23_201459](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_201459.PNG)

这样我们再查找某个key时，遍历的时间就会缩减为O(N/2)，此时继续进行优化，即对于“E——>F——>G”与“C——>B——>A”继续定义中位数指针，并且使一半的指针反向，再将其按不同的高度略微进行调整，于是就得到了所谓的二叉搜索树(BST)

![2022-05-23_201640](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_201640.PNG)

## BST定义

首先考虑树的定义：

1. A set of nodes

2. A set of edges connect those nodes

   **constrains: There is exactly one path between any two nodes.**

![2022-05-23_201953](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_201953.PNG)

上图中，红色两张张图中个别结点对不满足constrains，因此红色的图都不属于是树！

BST则是Binary Tree中的一种（一个节点只能够有最多两个子节点），其满足：某个节点左边的子树所有节点的key都小于该节点的key，而某个节点右边的子树所有的节点的key都大于该节点的key。

## Search，Insert以及Delete操作

**lecture中仅仅提供了pseudo code，正式java代码在对应的lab中给出**

```java
class BST <Key> {
    public Key key;
    public BST left;
    public BST right;

    public BST(Key key){
        this.key = key;
    }

    public BST(BST left,BST right,Key key){
        this.left = left;
        this.right = right;
        this.key = key;
    }

    /* 如果树非常浓密，则该操作时间复杂度为Θ(log(N)) (log(N)为树高)
    * 注意：这里应该为课上写的pseudo code，实现方式为naked recursion，正式的代码需要你在对应的lab中完成！ */
    public static BST search(BST T,Key key){
        if(T==null){
            return null;
        }
        if(T.key.equals(key)){
            return T;
        } else if(key>T.key){
            return search(T.right,key);
        } else{
            return search(T.left,key);
        }
    }


     /* 利用递归实现BST的insert操作！
      * 注意：这里应该为课上写的pseudo code，实现方式为naked recursion，正式的代码需要你在对应的lab中完成！ */
    public static BST insert(BST T, Key ik){
        if(T==null){
            return new BST(ik);
        }
        if(ik<T.key){
            T.left = insert(T.left,ik);
        }
        else if(ik>T.key){
            T.right = insert(T.right,ik);
        }
        return T;
    }
}
```

对于BST的delete操作相对而言比较复杂，需要考虑三种情况，即要删除的节点分别没有节点，仅有1个节点，有两个节点，这三种情况的删除操作的复杂程度依次递增：

- **需要删除的节点没有子节点：**

![2022-05-23_203359](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_203359.PNG)

**只要把flat.right赋值为null，glut node将会被garbage collector自动回收**

- **需要删除的节点有一个子节点：**

![2022-05-23_203828](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_203828.PNG)

**我们需要让flat的parent node，即dog指向flat的child node，即elf，则flat会被garbage collector自动回收，如下图：**

![2022-05-23_204057](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_204057.PNG)

**需要删除的节点有两个子节点：**

这种情况比较复杂，请看如下的例子：

![2022-05-23_204207](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_204207.PNG)

这种情况下，典型的思路是：选取k的左子树中最靠右的节点，且该节点至多只能有一个子节点；或选择k的右子树中最靠左的节点，且该节点同样至多只能有一个子节点，将选择的该节点替代掉k，成为新的根节点，同时删除掉选择节点原来在树结构中的位置，如下图：

![2022-05-23_204207](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_204207.PNG)

![2022-05-23_204657](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_204657.PNG)

## 利用BST对Set和Map进行加速

BST的search搜索效率可达O(logN)，因此可运用该数据结构实现Set或Map，从而实现search操作的加速：

- 利用BST实现Set：

![2022-05-23_205109](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_205109.PNG)

- 利用BST实现Map（仅需要除了key属性，再多定义一个value属性，然后search的时候通过key查询，返回value即可）

![2022-05-23_205212](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_205212.PNG)

**这已经非常接近`TreeMap`和`TreeSet`的实现了！**