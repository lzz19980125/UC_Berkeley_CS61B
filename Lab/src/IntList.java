/**
 * @author Li Zezhong
 * @create 2021-12-10 20:33
 */


public class IntList{
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
    public static void print_List(IntList L){
        IntList n = L;
        while(n !=null){
            System.out.println(n.first);
            n = n.rest;
        }
    }
    public static void dSquareList(IntList L){
        IntList p=L;
        while(p!=null){
            p.first *= p.first;
            p = p.rest;
        }
    }
    public static IntList copy(IntList L){
        IntList p = new IntList(L.first,null);
        IntList n = p;
        IntList m = L;
        while(m.rest!=null){
            m = m.rest;
            p.rest = new IntList(m.first,null);
            p = p.rest;
        }
        return n;
    }
    public static IntList squareListIterative(IntList L){
        IntList p = copy(L);
        dSquareList(p);
        return p;
    }
    public static IntList dcatenate(IntList A, IntList B){
        IntList p = A;
        while(p.rest!=null){
            p = p.rest;
        }
        p.rest = B;
        return A;
    }
    public static IntList catenate(IntList A, IntList B){
        IntList p = copy(A);
        IntList m = p;
        while(p.rest!=null){
            p = p.rest;
        }
        p.rest = B;
        return m;
    }
}


