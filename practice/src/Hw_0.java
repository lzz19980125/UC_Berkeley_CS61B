/**
 * @author Li Zezhong
 * @create 2021-12-02 15:29
 */


public class Hw_0 {
    public static void main(String[] args) {
        Draw_triangle(10);
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(MaxArray(numbers));
        int[] a = new int[]{1,2,-3,4,5,4};
        int n = 3;
        windowPosSum(a,n);
        System.out.println(java.util.Arrays.toString(a));
    }

    public static void Draw_triangle(int max){
        for(int i=1;i<=max;i +=1){
            for(int count=i;count>0;count -=1){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static int MaxArray(int[] Array){
        int bigger = Array[0];
        for(int i =1 ; i<Array.length ;i +=1){
            if(bigger<Array[i]){
                bigger = Array[i];
            }
        }
        return bigger;
    }

    public static void windowPosSum(int[] a, int n) {
        for(int i=0;i<a.length;i +=1){
            if(a[i]<0){
                continue;
            }
            for(int j=i+1;j<=i+n;j +=1){
                if(j==a.length){
                    break;
                }
                a[i] +=a[j];
            }
        }
    }
}






