# 渐进分析导论以及大O复杂度

### 常用`for loop`的复杂度分析：

`for loop 1`：

```java
int N = A.length;
for (int i = 0; i < N; i += 1)
   for (int j = i + 1; j < N; j += 1)
      if (A[i] == A[j])
         return true;
return false;
```


$$
1+2+...+N=\frac{N\left( N-1 \right)}{2}=O\left( N^2 \right)
$$
`for loop 2`：

```java
public static void printParty(int N) {
   for (int i = 1; i <= N; i = i * 2) {
      for (int j = 0; j < i; j += 1) {
         System.out.println("hello");   
         int ZUG = 1 + 1;
      }
   }
}
```

$$
a_1+a_1q+a_1q^2+...+a_1q^{N-1}=\frac{a_1\left( q^N-1 \right)}{q-1}
$$

$$
\Rightarrow 1+2+4+...+N=2N-1=O\left( N \right)
$$

### `recursion`的复杂度分析

```java
public static int f3(int n) {
   if (n <= 1) 
      return 1;
   return f3(n-1) + f3(n-1);
}
```

分析递归程序的复杂度需要看其函数的总调用次数，如下图所示：

![asymptotics2_tree2](C:\Users\lizi2\Desktop\python_reptile_practice\UC_Berkeley_CS61B\picture\asymptotics2_tree2.png)

如果输入数字为N，则f3的调用次数为：
$$
1+2+4+...+2^{N-1}=2^N-1=O\left( 2^N \right)
$$

### Binary Search（二分查找）时间复杂度分析

```java
public class Binary_Search {
    public static void main(String[] args) {
        int [] array = new int []{6,13,14,25,33,43,51,53,64,72,84,93,95,96,97};
        System.out.println(binary_search(array,13));
    }

    public static int binary_search(int [] array,int target){
        Arrays.sort(array);
        int first =0;
        int last =array.length-1;
        int mid = array.length/2;
        while(first<=last){
            if(array[mid]>target){
                last = mid-1;
            } else if(array[mid]<target){
                first = mid+1;
            } else{
                break;
            }
            mid = (first+last)/2;
        }
        return mid;
    }
}
```

$$
f\left( N \right) =1+f\left( \frac{N}{2} \right) =1+1+f\left( \frac{N}{4} \right) =...=x+f\left( \frac{N}{2^x} \right) \Leftrightarrow x+f\left( 1 \right) 
\\
x=\log _2N
\\
f\left( N \right) =O\left( \log _2N \right) 
$$

### MergeSort（归并排序）

### 代码实现待完成！

$$
f\left( N \right) =\varTheta \left( N\log \left( N \right) \right) 
$$

