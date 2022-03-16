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

class SLList<Item> implements List61B<Item>{

    @Override
    public void addFirst(Item x) {
    }

    @Override
    public void addLast(Item y) {
    }

    @Override
    public Item getFirst() {
        return null;
    }

    @Override
    public Item getLast() {
        return null;
    }

    @Override
    public Item removeLast() {
        return null;
    }

    @Override
    public Item get(int i) {
        return null;
    }

    @Override
    public void insert(Item x, int position) {
    }

    @Override
    public int size() {
        return 0;
    }
}


