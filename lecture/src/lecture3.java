import java.util.Arrays;

/**
 * @author Li Zezhong
 * @create 2021-12-14 18:37
 */
public class lecture3 {
    public static void main(String[] args) {
//        String [] first = new String[]{"i", "have", "an", "egg"};
//        Testsort testsort = new Testsort(first);
//        testsort.testSort();
        String [] a = new String []{"i", "have", "an", "egg"};
        Sort sort = new Sort(a);
        sort.sort();
    }
}

class Testsort{
    public String [] input;
    public String [] expected;
    public Testsort(String [] first){
        this.input = first;
    }
    public void testSort(){
        String [] expected = new String[]{"an", "egg", "have", "i"};
        for (int i=0;i<input.length;i+=1){
            if(!input[i].equals(expected[i])){
                System.out.println("Mismatch in position " + i + ", expected: " + expected[i] + ", but got: " + input[i] + ".");
                break;
            }
        }
    }
    public void testsort(){
        String [] expected = new String[]{"an", "egg", "have", "i"};
        org.junit.Assert.assertArrayEquals(expected, input);
    }
}

class Sort{
    String [] input;
    public Sort(String [] input){
        this.input = input;
    }
    public void sort(){
        for(int i=0;i<input.length;i +=1){
            String buffer = input[i];
            int j_notes = i;
            for(int j=i;j<input.length-1;j +=1){
                if((input[j+1].compareTo(buffer))<0){
                    j_notes = j+1;
                    buffer = input[j+1];
                }
            }
            input[j_notes]=input[i];
            input[i]=buffer;
        }
        System.out.println("输出为："+ Arrays.toString(input));
    }
}
