/**
 * @author Li Zezhong
 * @create 2021-12-15 9:12
 */

public class lecutre4_1 {
    public static void main(String[] args) {
//        List61B <String > a = new AList<>();
        List61B <String > a = new SList<>(null);
        a.addLast("dadsfadsf");
        a.addLast("eadsfadsgasgfdgf");
        a.addLast("c");
        a.addLast("bsdfdgsfdg");
        a.addLast("av");
        a.addFirst("123");
        a.positive_print();
    }
    public static String smallest(SList<String> input){
        String buffer = input.get(0);
        int size = input.size();
        for(int i=0; i<size; i+=1){
            if(input.get(i).length()<buffer.length()){
                buffer = input.get(i);
            }
        }
        return buffer;
    }
}



