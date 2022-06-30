# B Tree

## Tree height，Tree depth以及Balance的定义

![2022-05-23_214756](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_214756.PNG)

“spindly Tree”(细长的树)拥有更高的height（O(N)）和Average Depth，而“bushy Tree”（浓密的树）拥有相对较短的height(O(log(N)))和Average Depth:

![2022-05-23_215101](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_215101.PNG)

![2022-05-23_214930](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_214930.PNG)

**balance的定义：如果我们讲一个树是balance的，那么就是在讲这棵树的所有叶子节点距离其根节点的距离（历经的边的个数）全部相等！**

## 为什么要引进B Tree

在现实情况中，对BST进行randomly insert操作，得到的树一般是较为浓密的，然而许多场景下，我们需要连续为BST添加顺序数据，这就会造成下面这种情况：

![2022-05-23_220807](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-05-23_220807.PNG)

当原本浓密的BST变得细长时，search效率将会下降，为了避免这一缺点，我们将引入B树结构：

## B Tree的定义以及基本操作

要想使树变得不再浓密，一个自然而然的想法就是像下面这样：

![2022-06-03_201110](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\2022-06-03_201110.PNG)

上面这棵树的height是balance了，但当数据量达到一定规模时，`search`仍然是O(N)，因此我们需要设置让每个节点所包含的元素数量不能超过一定的限制，以防止上述情况。考虑如下的解决方案：

![B](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\B.PNG)

上图中，我们规定了每个节点包含的元素不能够超过阈值`L=3`，这样，虽然搜索同一节点所消耗的时间复杂度会从O(1)变为O(L)，但这是可以接受的。上述情况仅仅是当叶子节点包含的元素超限时，所做的更改。当非叶子节点所包含的元素超限时，修改方式如下：

![B1](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\B1.PNG)

若根包含的元素数量超限，则如下图所示：

![B2](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\B2.PNG)

这种数据结构可以完美地保证树是balanced，如上面3种情况所示，如果根节点超限，则调整树的结构会使树整个的height增加1，而除根结点外的非叶子节点或叶子节点超限，则不会对height有影响。该种数据结构的search操作可完美保证O(logN),这种数据结构称之为B Tree. B Tree的不变量(invariants)定义如下:

![B3](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\B3.PNG)

事实上，B tree将保证其height永远log(N)，`contains`以及`add`的操作的时间复杂度都为O(log(N))

**最后，记住一条铁律：B树永远是balanced！**

## 有关树的Rotate操作

B树同样是存在缺点的，它的缺点一个是较难实现，并且经常需要忍受含有2个元素或者3个元素的节点之间进行互相转换，且在添加节点是需要进行节点的分裂操作，因此这里首先介绍一下树的Rotate操作.考虑以下的树结构，操作`rotateLeft(G)`是将G变成目前G右子节点的左子节点，操作过程如下：

![rotate1](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\rotate1.PNG)

既然P是G的右子节点，那么G就是新P的左子节点，此时G缺一个右子节点，而P存在3个节点，那么最终把k作为新G的右子节点即可：

![rotate2](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\rotate2.PNG)

**所以有关于`rotate(x)`的口诀是：如果需要`rotateright(x)`，考虑x和其左子树的关系；需要`rotateleft(x)`，则考虑x和其右子树的关系。**掌握了rotate操作，可以不使用B树那么复杂的结构，就使得细长的树变得bushy，如下图所示：

![rotate3](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\rotate3.PNG)

`rotateright(x)`和`rotateleft(x)`的操作：

![rotate4](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\rotate4.PNG)

# 左倾红黑树（Left leaning red black tree, LLRB）

先前，我们先后介绍了B树和对于BST的rotate操作，它们都可以使得树由细长而变得bushy。这里我们进一步定义一种利用二叉树结构模拟B树的数据结构，称为红黑树(red black tree)，如下图所示，每当出现包含两个元素的节点时，我们采用左倾操作将其拆分（其实同样可以右倾，只是普林斯顿算法读本这样进行规定，因此也有了我们标题的名称：左倾红黑树，LLRB）：

![read_black_2](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\read_black_2.PNG)

红黑指的是啥呢？请看下图：

![read_black_1](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\read_black_1.PNG)

“红”色链接将原B树含有多个元素节点的元素通过二叉树的结构进行“glue”,而“黑”色链接则是链接其余的普通节点，因此称之为红黑树。

### LLRB的一些性质

1. **判断一个LLRB是否合法，一个快速方法是将其逆映射，画出唯一与之对应的B tree，之后判断该B tree是否合法(需满足：1.是否balanced 2.是否每一个拥有k个元素的非叶子节点都拥有k+1个子节点)**

![red_black_3](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\red_black_3.PNG)

2. 每个子节点到根节点所经过的黑边数必须相等（“黑边”平衡性），并且不允许有两条红边都经过某一节点（与B树中“每一个拥有k个元素的非叶子节点都拥有k+1个子节点”的概念相对应）
2. 某一红黑树对应的B树高度为H，则该红黑树的最大高度应等于2H+1。因此如果B树的树高之于输入数据是O(log(N))的话，红黑树的树高也是一样的。

### LLRB的构建过程

1. 当只有一个节点s，且需要添加一个节点E时，应该使用红色链接，如下图：

![LLRB_build_1](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\LLRB_build_1.PNG)

2. 当时下面这种情况时，就需要用到旋转操作：`rotate(E)`

![LLRB_build_2](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\LLRB_build_2.PNG)

3. 当增加累计增加两个节点到子节点时，我们首先假设可以有暂时违规的中间态（一个子节点被两个红边相连）：`rotate(Z)`

![LLRB_build_3](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\LLRB_build_3.PNG)

4. 最后，我们将过渡态转换至正确的红黑树形态，此操作不涉及任何旋转操作，只需要单纯的将经过B点的红边变成黑边，黑边变成红边即可，可记录此操作方法为`flip(B)`

![LLRB_build_4](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\LLRB_build_4.PNG)

5. 偶尔的，我们在构建红黑树时会发生如下情况：红黑树不符合左倾特性(s应该在B上面)，因此我们需要再对B进行`rotateleft(B)`操作

![LLRB_build_5](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\LLRB_build_5.PNG)

![LLRB_build_6](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\LLRB_build_6.PNG)

**LLRB的运行时间分析**

![LLRB_runtime](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\LLRB_runtime.PNG)

**最后，java中的`TreeMap`就是使用了Red Black Tree(只是不是左倾的)**
