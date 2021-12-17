/**
 * @author Li Zezhong
 * @create 2021-12-15 20:25
 */
public class lecture4_2 {
    public static void main(String[] args) {
        RotatingSLList <String> n = new RotatingSLList<>(null);
        n.addLast("a");
        n.addLast("b");
        n.addLast("c");
        n.rotateRight();

        System.out.println(do_twice(new Tenx(),2));
        VengefulSLList <String> f =  (VengefulSLList <String>) new SList<String>(null);
//        n.addLast("a");
//        n.addLast("d");
//        n.addLast("b");
//        n.addLast("c");
//        n.removeLast();
//        n.removeLast();
//        n.removeLast();
//        n.print_deletedItems();
    }
    public static int do_twice(Hight_order_fun f, int x){
        return f.apply(f.apply(x));
    }
}

class RotatingSLList<Item> extends SList<Item>{
    public RotatingSLList(Item intnode) {
        super(intnode);
    }
    public void rotateRight(){
        addFirst(this.getLast());
        removeLast();
    }
}

class VengefulSLList<Item> extends SList<Item>{
    SList <Item> deletedItems = new SList<>(null);

    public VengefulSLList(Item intnode) {
        super(intnode);
    }

    @Override
    public Item removeLast(){
        Item m = super.removeLast();
        deletedItems.addLast(m);
        return m;
    }

    public void print_deletedItems(){
        deletedItems.positive_print();
    }
}

class Tenx implements Hight_order_fun{

    @Override
    public int apply(int x) {
        return 10*x;
    }
}