import java.util.Arrays;

/**
 * @author Li Zezhong
 * @create 2021-12-04 21:02
 */

public class lecture2_4 {
    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] z = new int[3][];
        z[0] = x[0];
        z[1] = x[1];
        z[2] = x[2];
        z[0][0] = -z[0][0];
        System.out.println(Arrays.toString(z[0]));
        System.out.println(Arrays.toString(z[1]));
        System.out.println(Arrays.toString(z[2]));
        System.out.println(Arrays.toString(x[0]));

        int[][] w = new int[3][3];
        System.arraycopy(x[0], 0, w[0], 0, 3);
        System.arraycopy(x[1], 0, w[1], 0, 3);
        System.arraycopy(x[2], 0, w[2], 0, 3);
        w[0][0] = -w[0][0];
        System.out.println(Arrays.toString(w[0]));


    }
}






