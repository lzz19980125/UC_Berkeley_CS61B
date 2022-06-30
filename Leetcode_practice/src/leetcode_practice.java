import javax.print.attribute.standard.PageRanges;
import java.util.*;

/**
 * @author Li Zezhong
 * @create 2022-05-14 9:49
 */
public class leetcode_practice {
    public static void main(String[] args) {
        int [] a = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(a,2)));
    }

    static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> entry1,Map.Entry<Integer,Integer> entry2){
                return entry1.getValue()-entry2.getValue();
            }
        });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(pq.size()<k){
                pq.add(entry);
            } else{
                pq.add(entry);
                pq.poll();
            }
        }
        int [] result = new int [k];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:pq){
            result[i] = entry.getKey();
        }
        return result;
    }
}


