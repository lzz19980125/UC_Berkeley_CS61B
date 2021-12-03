/**
 * @author Li Zezhong
 * @create 2021-12-02 15:29
 */


public class Discussion_01 {
    public static void main(String[] args) {
        int[] inputArray = new int [] {3, 0, 4, 6, 3};
        System.out.println(mystery(inputArray,2));
        int [] inputArray2  =new int[]{3, 0, 4, 6, 3};
        mystery2(inputArray2);
        System.out.println(java.util.Arrays.toString(inputArray2));
        System.out.println(Fibonacci.fib(3));
    }
    public static int mystery(int[] inputArray, int k){
        int x = inputArray[k];
        int answer = k;
        int index = k+1;
        while(index <inputArray.length){
            if(inputArray[index] <x){
                x = inputArray[index];
                answer = index;
            }
            index +=1;
        }
        return answer;
    }
    public static void mystery2(int [] inputArray){
        int index = 0;
        while(index < inputArray.length){
            int targetIndex = mystery(inputArray,index);
            int temp = inputArray[index];
            inputArray[targetIndex] = inputArray[index];
            inputArray[index] =temp;
            index += 1;
        }
    }
}

class Fibonacci{
    public static int fib(int n){
        if(n==1){
            return 0;}
        if(n==2){
            return 1;}
        return fib(n-1)+fib(n-2);
    }
}








