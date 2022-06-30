# DFS（深度优先搜索）

### 树的定义

![image-20220613141350877](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613141350877.png)

### 树的遍历顺序(Tree Traversal)

* Preorder(前序遍历)

![image-20220613141713277](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613141713277.png)

* Inorder(中序遍历)

![image-20220613141749324](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613141749324.png)

* Postorder(后序遍历)

![image-20220613141832498](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613141832498.png)

* Levelorder

![image-20220613141924495](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613141924495.png)

### Graphs(图)的基本概念和定义

![image-20220613144634545](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613144634545.png)

树的定义是：一系列的节点，并且每个节点必须有至少一条边进行连接，其限制条件是：两个节点之间只允许有一种路径通过。

上述中红色的图都符合图的定义：

![image-20220613144741621](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613144741621.png)

![image-20220613144812536](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613144812536.png)

simple Graph（简单图）定义的限制有：1） no loops 2） no parallel edges

以下显示了一些有关Graph的术语：

![image-20220613145258899](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613145258899.png)

![image-20220613145309630](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613145309630.png)

### Graph Problems

![image-20220613150100602](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613150100602.png)

### DFS

DFS可用来解决s-t Path问题以及连通性问题(Connectivity)

DFS的核心主旨思想为：

![image-20220613152535247](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613152535247.png)

以上图右下角的图为例，以DepthFirstPaths问题为背景，阐释DFS的具体流程如下：

![image-20220613152839541](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613152839541.png)

在mark(1)之前首先 set degeTo(1)=0

![image-20220613152945458](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613152945458.png)

以此类推

![image-20220613152959450](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613152959450.png)

![image-20220613153007635](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153007635.png)

![image-20220613153011356](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153011356.png)

![image-20220613153025684](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153025684.png)

![image-20220613153029373](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153029373.png)

![image-20220613153040950](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153040950.png)

![image-20220613153055394](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153055394.png)

![image-20220613153100311](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153100311.png)

![image-20220613153107654](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153107654.png)

![image-20220613153112342](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153112342.png)

![image-20220613153123130](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153123130.png)

![image-20220613153130570](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153130570.png)

![image-20220613153136509](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153136509.png)

![image-20220613153152110](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153152110.png)

![image-20220613153159103](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153159103.png)

![image-20220613153205306](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153205306.png)

### DFS的preorder以及postorder

![image-20220613153308582](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613153308582.png)