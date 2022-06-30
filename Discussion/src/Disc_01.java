/**
 * @author Li Zezhong
 * @create 2022-05-05 15:31
 */

public class Disc_01 {
    public static void main(String[] args) {
        fib.fib_01(6);
    }
}

class fib{
    public static void fib_01(int n){
        int f0=0;
        int f1=1;
        int f2;
        int k=1;
        while(k<=n){
            System.out.print(f0+", ");
            f2=f0+f1;
            f0=f1;
            f1=f2;
            k=k+1;
        }
    }
}


