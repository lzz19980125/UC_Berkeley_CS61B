# BFS（广度优先搜索）

不同于典型的DFS，典型的BFS并不基于递归，并且其中运用了数据结构Queue（队列，后进 addLast() 先出 removefirst()）。BFS的主要原理如下所示：

![image-20220613193354778](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613193354778.png)

基于与DFS上一章同样的图，对BFS的整个算法流程进行阐述：

![image-20220613195133275](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195133275.png)

这里讨论的是s——t的无权重最短路问题，即找出每个vertex距离source的最短路径有多长。为解决这一问题，BFS（BreadthFirstPaths）本身需要维护3个Array，即marked，edgeTo以及distTo（相比之下s-t connect问题中，DFS只需要维护两个Array，即marked以及edgeTo）

![image-20220613195858339](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195858339.png)

![image-20220613195913588](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195913588.png)

![image-20220613195918024](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195918024.png)

![image-20220613195923212](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195923212.png)

![image-20220613195927331](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195927331.png)

![image-20220613195931639](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195931639.png)

![image-20220613195935719](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195935719.png)

![image-20220613195939886](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195939886.png)

![image-20220613195944032](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195944032.png)

![image-20220613195951948](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195951948.png)

![image-20220613195956025](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613195956025.png)

![image-20220613200000093](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613200000093.png)

![image-20220613200004108](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613200004108.png)

![image-20220613200008948](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613200008948.png)

![image-20220613200012822](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613200012822.png)

![image-20220613200016905](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613200016905.png)

![image-20220613200020603](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613200020603.png)

![image-20220613200024397](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613200024397.png)

![image-20220613200028672](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613200028672.png)

## Graph API

如果我们需要切实的implement我们的DFS和BFS算法，我们需要以下两个东西：

![image-20220613201105548](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613201105548.png)

* Graph API
* 某种用于代表Graph的数据结构

事实上，几乎所有的Graph API都会对所有的vertices进行编号，如下图所示：

![image-20220613201603471](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613201603471.png)

下图为普林斯顿提供的Graph API：

![image-20220613203855831](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613203855831.png)

计算每个vertex的degree的函数：

![image-20220613203958711](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613203958711.png)

打印出图的所有边的关系的函数：

![image-20220613204250027](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613204250027.png)

## The data structure to represent Graph

* 邻接矩阵(Adjacency Matrix)：

![image-20220613204555321](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613204555321.png)

利用这种邻接矩阵实现求解每个节点的邻居，需要Θ(V²)的时间复杂度：

![image-20220613210038270](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613210038270.png)

* HashSet<Edge> 即利用Hash集合表示所有边：

![image-20220613210150027](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613210150027.png)

* Adjacency Lists（邻接列表，最为流行的一种表示方法）

![image-20220613210257295](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613210257295.png)

采用邻接列表完成求解每个节点的邻居，需要Θ(V+E)的时间复杂度：

![image-20220613210504976](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613210504976.png)

上述三种data structure对于Graph API中大部分操作的时间复杂度需要：

![image-20220613211243997](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613211243997.png)

最后是普林斯顿对于Graph API的implementation：

![image-20220613211353250](C:\Users\lizi2\AppData\Roaming\Typora\typora-user-images\image-20220613211353250.png)