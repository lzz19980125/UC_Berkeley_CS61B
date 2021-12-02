/**
 * @author Li Zezhong
 * @create 2021-12-02 15:29
 */


public class Hello {
    public static void main(String[] args) {
        System.out.println(larger(5,10));
    }
    public static int larger(int x,int y){
        if (x>y){
            return x;
        }
        return y;
    }
}
