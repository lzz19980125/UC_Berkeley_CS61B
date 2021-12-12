import java.net.PasswordAuthentication;

/**
 * @author Li Zezhong
 * @create 2021-12-04 9:05
 */

/** Single List */
public class lecture2_2 {
    public static void main(String[] args) {
        SList<Integer> L = new SList<>(63,15);
        L.addFirst(10);
        L.addFirst(5);
        L.positive_print();
        System.out.println();
        L.negative_print();
    }
}


class SList<buber> {
     class IntNode{
        public buber item;
        public IntNode next;
        public IntNode prev;
//        public IntNode prev;
        public IntNode(buber i,IntNode n){
            item = i;
            next = n;
        }
        public IntNode(buber i,IntNode n,IntNode m){
            item = i;
            next = n;
            prev = m;
        }
    }
    private IntNode sentinel;
    private int size;
    private IntNode last;
    public SList(buber intnode){
        sentinel = new IntNode(intnode,null,null);
        last = sentinel;
        size = 0;
    }
    public SList(buber intnode,buber x){
        sentinel = new IntNode(intnode,null,null);
        sentinel.next = new IntNode(x,null,sentinel);
        size = 1;
        last = sentinel.next;
    }
    public void addFirst(buber y){
        sentinel.next = new IntNode(y,sentinel.next,sentinel);
        if(sentinel.next.next!=null){
            sentinel.next.next.prev = sentinel.next;
        } else{
            last = sentinel.next;
        }
        size +=1;
    }
    public buber getFirst(){
        return sentinel.next.item;
    }
    public buber getLast(){
        return last.item;
    }
//    public void addLast(int x){
//        IntNode p = sentinel;
//        while(p.next !=null){
//            p = p.next;
//        }
//        p.next = new IntNode(x,null);
//        size +=1;
//    }
    public void addLast(buber x){
        last.next = new IntNode(x,null,last);
        last = last.next;
        size +=1;
    }
//    public static int size(IntNode p){
//        if(p.next ==null){
//            return 1;
//        }
//        return 1+size(p.next);
//    }
//    public int size(){
//        return size(sentinel.next);
//    }
    public int size(){
        return size;
    }
    public void positive_print(){
        IntNode p=sentinel.next;
        while(p !=last){
            System.out.println(p.item);
            p = p.next;
        }
        System.out.println(p.item);
    }
    public void negative_print(){
        IntNode p=last;
        while(p !=sentinel){
            System.out.println(p.item);
            p = p.prev;
        }
    }
}












