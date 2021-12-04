import java.net.PasswordAuthentication;

/**
 * @author Li Zezhong
 * @create 2021-12-04 9:05
 */

/** Single List */
public class lecture2_2 {
    public static void main(String[] args) {
        SList L = new SList(15);
        L.addFirst(10);
        L.addFirst(5);
        int x = L.getFirst();
        System.out.println(x);
        System.out.println(L.size());
        L.addLast(1);
        System.out.println(L.size());
        System.out.println(L.getLast());
    }
}


class SList{
    static class IntNode{
        public int item;
        public IntNode next;
//        public IntNode prev;
        public IntNode(int i,IntNode n){
            item = i;
            next = n;
        }
    }
    private IntNode sentinel;
    private int size;
    private IntNode last;
    public SList(){
        sentinel = new IntNode(63,null);
        last = sentinel.next;
        size = 0;
    }
    public SList(int x){
        sentinel = new IntNode(63,null);
        sentinel.next = new IntNode(x,null);
        last = sentinel.next;
        size = 1;
    }
    public void addFirst(int y){
        sentinel.next = new IntNode(y,sentinel.next);
        size +=1;
    }
    public int getFirst(){
        return sentinel.next.item;
    }
    public int getLast(){
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
    public void addLast(int x){
        last.next = new IntNode(x,null);
        last = last.next;
        size +=1;
    }
    public static int size(IntNode p){
        if(p.next ==null){
            return 1;
        }
        return 1+size(p.next);
    }
    public int size(){
        return size(sentinel.next);
    }
//    public int size(){
//        return size;
//    }
}












