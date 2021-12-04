# 海象之谜（待完成）

java除了byte、short、int、long、float、double、boolean、char这8大类型之外，其余所有引用类型都是引用类型。

```java
/**
 * @author Li Zezhong
 * @create 2021-12-02 15:29
 */


public class lecture_1 {
    public static void main(String[] args) {
        Warlus x = new Warlus(1000,15.0);
        Warlus y = new Warlus(500,10.0);
        y = x;
        y.weight = 8000;
        y.tusksize = 20.0;
        int i = 10;
        System.out.println(x.toString());
        System.out.println(x.toString());
        Warlus.doStuff(x,i);
        System.out.println(x.toString());
        System.out.println(i);
        
        int [] x,y;
        x = new int[] {1,2,3,4,5};
        y = x;
        System.out.println(Arrays.toString(y));
        x[0] = 0;
        System.out.println(Arrays.toString(y));
        x = new int [] {-1,2,5,4,99};
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }
}

class  Warlus{
    int weight;
    double tusksize;
    public Warlus(int w,double ts){
        this.weight = w;
        this.tusksize = ts;
    }
    public String toString(){
        return String.format("weight %d,tusk size %.2f",this.weight,this.tusksize);
    }
    public static void doStuff(Warlus W,int x){
        W.weight = W.weight-5;
        x = x -5;
    }
}
```

# 双向链表（Intnode中的prev指针）（project1 待完成）

# DList中会使用泛型，还没搞明白

