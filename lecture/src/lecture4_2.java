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

//        VengefulSLList <String> n = new VengefulSLList<>(null);
//        n.addLast("a");
//        n.addLast("d");
//        n.addLast("b");
//        n.addLast("c");
//        n.removeLast();
//        n.removeLast();
//        n.removeLast();
//        n.print_deletedItems();
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
