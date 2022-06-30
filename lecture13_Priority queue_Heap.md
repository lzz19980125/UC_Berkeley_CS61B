# Heap and Priority Queue

### PQ(Priority Queue)的各种method，以及该数据结构有何优势

优先队列(Priority Queue)的方法包括;

![Heap1](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\Heap1.PNG)

优先队列的特点是：你可以把它当成一袋东西，然后你可以向里面添加item，或者得知它共有多少个item，此外，供你交互的只有队列里的最小的item。

以如下的例子说明应该在何时使用优先队列：

![heap2](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap2.PNG)

假设你需要收集24小时的消息，然后挑出m条最不和谐(unharmonious)的信息出来。一种通常的解法是：

![heap3](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap3.PNG)

即收集24小时的全部消息，然后对其进行排序，这会使得占用巨大的内存(O(N)).而使用PQ（Priority queue）则可将内存消耗降低为O(M).其解法如下：

![heap4](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap4.PNG)

首先开始添加消息，并使用优先队列，当添加到m个消息时，每再添加一个，就将优先队列中的最小消息删去，这样就可一直保持内存消耗，并且最终留下的m条消息即为所求。

接下来我们将利用Heap(堆)去实现优先队列，以下是目前所有学过的数据结构对于实现优先队列的各种操作的时间消耗：

![heap5](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap5.PNG)

### Heap

堆(heap)的定义强调两种属性：

1. min—heap，即堆的最小属性。这指的是若用二叉树实现堆，则每个节点的值必须小于或者等于其所有子节点的值
2. Complete，即完整性。这指的是若用二叉树实现堆，则若有item缺失的情况，只能发生在bottom level（即只能是每个子树的倒数第二层的节点对应的子节点没有满），并且所有节点尽可能地向左进行倾斜

一些heap的例子：

![heap6](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap6.PNG)

![heap7](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap7.PNG)

利用这种heap(最小堆)实现PQ具有天然的优势：

1. 对于getSmallest()，直接返回heap的根节点即可
2. 对于add() ，以下展示了两种解决情况：

![heap8](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap8.PNG)

首先，上述堆是合法的，既满足min性质，也满足compelete性质，我们要添加3，则需要添加在首先保持满足compelete性质的位置（如下图所示）：

![heap9](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap9.PNG)

![heap10](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap10.PNG)

![heap11](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap11.PNG)

![heap12](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap12.PNG)

此时，再举一个添加"5"的例子：

![heap13](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap13.PNG)

![heap14](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap14.PNG)

3. 对于removesmallest() ，以下同样展示了两种解决情况：

![heap15](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap15.PNG)

![heap16](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap16.PNG)

![heap17](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap17.PNG)

![heap18](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap18.PNG)

![heap19](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap19.PNG)

![heap20](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap20.PNG)

![heap21](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap21.PNG)

利用堆(heap)去实现优先队列的所有操作方法：

![heap22](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\heap22.PNG)

这里面着重注意一下`add`操作中的`last position`以及`removeSmallest`操作中的`the rightmost person`指的是哪个位置！！！！！！！！！！

### Tree represantation

在各种编程语言中，java普遍有这几种实现形式：

![image-20220611124722337](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220611124722337.png)

![image-20220611125022106](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220611125022106.png)

![image-20220611125028365](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220611125028365.png)

不同于上述三种方法，以下这种方法通过维护两个Array(key数组和parents数组)来表示树结构：

![image-20220611125204024](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220611125204024.png)

而事实上，我们可以不去维护parents数组，而只去维护keys数组，以表示整个树结构，如下图所示：

![image-20220611125604174](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220611125604174.png)

那么在去掉了parents数组后，我们如何得知某一节点的父节点是谁呢（譬如我输入1或者2，需要返回0；输入3或者4，需要返回1.......），答案如下图;

![image-20220611125944567](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220611125944567.png)

事实上，我们稍微将key数组的定义方式再小小的改变一下，就可以方便的检索任意item的左，右子节点以及父节点;

![image-20220611130303280](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220611130303280.png)