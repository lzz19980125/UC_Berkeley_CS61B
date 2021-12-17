/**
 * @author Li Zezhong
 * @create 2021-12-03 20:28
 */

public class lecture2_1 {
    public static void main(String[] args) {
        //正向构建List
        IntList list1 = new IntList(3,null);
        IntList list2 = new IntList(2,list1);
        IntList list3 = new IntList(1,list2);
        //反向构建List
        list1.rest = new IntList(2,null);
        list1.rest.rest = new IntList(1,null);
        //调用size(),IterativeSize(),get(),IterativeGet()
        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());
        System.out.println(list3.IterativeSize());
        System.out.println(list3.get(1));
        System.out.println(list3.IterativeGet(1));
        //调用addFirst()
        IntList list4 = new IntList(5,null);
        list4.addFirst(10);
        System.out.println(list4.first);
        System.out.println(list4.rest.first);
    }
}

class IntList{
    int first;
    IntList rest;
    public IntList(int f, IntList r){
        this.first = f;
        this.rest = r;
    }
    public int size(){
        if(this.rest == null){
            return 1;
        }
        return 1+this.rest.size();
    }
    public int IterativeSize(){
        IntList p;
        int result=0;
        p = this;
        while(p !=null){
            result +=1;
            p = p.rest;
        }
        return result;
    }
    public int get(int n){
        if(n==0){
            return this.first;
        }
        return this.rest.get(n-1);
    }
    public int IterativeGet(int n){
        IntList p=this;
        while(n!=0){
            p = p.rest;
            n -=1;
        }
        return p.first;
    }
    public void addFirst(int x){
        int y = first;
        this.first = x;
        this.rest = new IntList(y,null);
    }
}


