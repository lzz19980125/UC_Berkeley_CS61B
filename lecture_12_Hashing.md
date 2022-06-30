# Hashing

### 为什么要研究哈希

为了实现Set或者Map，我们目前已经学了这么多的数据结构：

![Hash_motivate1](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\Hash_motivate1.PNG)

它们每一个都有些许缺点，对基于BST的树模型（BST,2-3 Tree,LLRB）来讲，其有如下显著缺点：

1. 上述树模型只适合Comparable的数据类型，当数据类型无法进行比较时，其并不能进行有效检索与添加
2. O(log(N))已经足够好了，但有没有可能做的更好呢？

![Hash_motivate2](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\Hash_motivate2.PNG)

首先，我们将考虑正整数的数据类型。为了解决问题2，我们可以将数据作为Index并设计出如下的数据结构：

![Hash_motivate3](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\Hash_motivate3.PNG)

这种数据类型无论`contains()`还是`add()`的复杂度都是O(1)的，但是该种数据结构及其耗费计算机内存。我们研究Hash就是基于上述数据结构，找一个折中的办法，使之在保持O(1)复杂度的同时，还能够解决数据`Comparable`的问题。

### Generalizing the DataIndexedIntegerSet idea

不同于只储存数字，我们如何运用上述数据结构去存储“英文单词”呢？

一种方法是：我们采用类似于数学中的10进制去对英文中的26个字母进行表示（只要基大于等于26即可避免任意两种英文单词发生碰撞（collisions），下图中采用了基=27）

![avoid_collisions1](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\avoid_collisions1.PNG)

![avoid_collisions2](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\avoid_collisions2.PNG)

在成功表示完英文单词之后，我们可能有更大的字符集需要表示，诸如"2Pac",甚至是一些汉字，而这时就需要将我们的基数进行较大的扩充，然而在Java中，最大的Integer的值为2147,483,647.我们很容易就会使整数陷入用尽的地步，这个时候就会产生Overflow（溢出）的问题。

我们最初试图将近似无限的空间(英文单词，长度任意)去映射至有限的空间(java最大的Integer是有限的)，以方便利用DataIndexedIntegerSet这种数据结构去实现O(1)的`add()`以及`contains`操作。然而只要存在溢出，就一定会产生溢出所带来的问题：collision。为了解决棘手的collision问题，提出了`HashTable`:

### Hash Table

事实上，java的Integer本身是有限的，因此我们试图将近似无限的空间一一映射至有限的空间就一定会发生collision。因此我们只能允许这样的collision产生，但是产生collision并不代表最终的`add()`和`contains()`操作结果就不能唯一了。HashTable就对上述情况做了如下的定义：

![HashTable1](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\HashTable1.PNG)

“moo”和“Nep”都可计算出718的hashcode，则在718后定义一个Bucket，里面再装上“moo”和“Nep”即可。Bucket的实现可以是一个链表, etc.

![hashTable2](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\hashTable2.PNG)

在这种数据结构情况下，两种操作的最坏时间复杂度都为O(Q)，其中Q代表最大的Bucket链表长度。而实际上，在定义完上述数据结构后，我们其实还可以极大的缩减灰色链表的长度，方法是计算出hashcode后，我们通过某种函数（譬如取模函数，模=10，mod）即仅仅关注hashcode计算结果的最后一位，这样灰色链表的长度即可缩减至0~9：

![hashTable](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\hashTable.PNG)

### Improve the Hash Table performance

![HashTable_performance1](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\HashTable_performance1.PNG)

上图中，如果数据分布不均匀，则HashTable的`add`以及`contains`效率最差为O(N)，如果理想情况下，数据均匀的分布至5个bucket内，则HashTable的效率为O(N/M)（M为bucket的数量，即灰色链表的长度）。现假设我们拥有足够好的hash函数，这个函数可将数据均匀分布至每个bucket内，那么我们如何保证O(N/M)=O(1)呢？

答案是：我们同样令M随着N的规模变大而变大，只要保证M=O(N)，则可保证O(N/M)=O(1)。

![HashTable_performance2](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\HashTable_performance2.PNG)

如上图，我们通常称N/M为负载因子(load factor).

![HashTable_performance3](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\HashTable_performance3.PNG)

上图显示了当N=6时，M/N=1.5，因此将M进行了翻倍，此时之前所有的item都需要重新进行bucket的分配，而该操作是需要消耗大量时间的，即O(N).总的来说，上述HashTable需要的时间复杂度包括经常性的O(1)，而偶尔需要resize，即O(N)的平均时间复杂度决定。

### java的Hash函数

显而易见，好的Hash函数能够令不同的item均匀分布地放入bucket内。

java中hash函数以31作为基底，至于为什么不以126为基底，请观看cs61C.
