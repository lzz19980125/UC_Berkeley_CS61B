import java.sql.SQLOutput;
import java.util.*;

/**
 * @author Li Zezhong
 * @create 2022-05-05 18:22
 */
public class lecture_02_practice {
    public static void main(String[] args) {
        int [][] grid = {{1,2,5},{3,2,1}};
        System.out.println(maxValue(grid));
    }

    public static int maxValue(int[][] grid) {
        int i=0;
        int j=0;
        int sum= grid[0][0];
        while((i<grid.length-1)|(j<grid[0].length-1)){
            sum +=grid[i][j];
            if(j==grid[0].length-1){
                i = i+1;
                continue;
            }
            if(i==grid.length-1){
                j=j+1;
                continue;
            }
            if((grid[i+1][j]>grid[i][j+1])){
                i=i+1;
            } else if((grid[i+1][j]<=grid[i][j+1])){
                j=j+1;
            }
        }
        return sum;
    }
}








