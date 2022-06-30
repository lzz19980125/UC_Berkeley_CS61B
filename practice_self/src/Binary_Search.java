import java.util.Arrays;

/**
 * @author Li Zezhong
 * @create 2022-05-18 20:18
 */
/* Binary Search Time complexity： Θ(log(N))*/
public class Binary_Search {
    public static void main(String[] args) {
        int [] array = new int []{6,13,14,25,33,43,51,53,64,72,84,93,95,96,97};
        System.out.println(binary_search(array,97));
    }

    public static int binary_search(int [] array,int target){
        Arrays.sort(array);
        int first =0;
        int last =array.length-1;
        int mid = array.length/2;
        while(first<=last){
            if(array[mid]>target){
                last = mid-1;
            } else if(array[mid]<target){
                first = mid+1;
            } else{
                break;
            }
            mid = (first+last)/2;
        }
        return mid;
    }
}
