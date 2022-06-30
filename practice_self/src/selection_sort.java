import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author Li Zezhong
 * @create 2022-05-08 19:13
 */
public class selection_sort {
    public static void main(String[] args) {
        int [] a = {2, 3, 1, 0, 7, 5, 3};
        int buffer;
        int buffer_id;
        for(int i=0;i<a.length;i++){
            buffer = a[i];
            buffer_id = i;
            for(int j=i;j<a.length;j++){
                if(a[j]<buffer){
                    buffer_id = j;
                    buffer = a[j];
                }
            }
            a[buffer_id]=a[i];
            a[i] = buffer;
        }
        int k=0;
        for(;k<a.length-1;k++){
            if(a[k]==a[k+1]){
                break;
            }
        }
        System.out.println(a[k]);
    }
}
