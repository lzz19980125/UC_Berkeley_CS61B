/**
 * @author Li Zezhong
 * @create 2021-12-07 21:56
 */
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    private static void lectureQuestion() {
        SLList L = new SLList();
        IntNode n = new IntNode(5, null);
    }

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }
    public SLList(int [] a){
        sentinel = new IntNode(63,null);
        IntNode p = sentinel;
        size = 0;
        int i=0;
        while(i<a.length){
            p.next = new IntNode(a[i],null);
            p = p.next;
            i +=1;
            size +=1;
        }
    }

    public int get(int i){
        IntNode p = sentinel.next;
        while(i!=0){
            p = p.next;
            i -=1;
        }
        return p.item;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds x to the end of the list. */
    public void addLast(int x) {
        size = size + 1;
        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    public void deleteFirst(){
        sentinel.next = sentinel.next.next;
        size -=1;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList();
        L.addLast(20);
        L.addLast(10);
        L.addLast(5);
        int i = 0;
        while(i<L.size()){
            System.out.println(L.get(i));
            i +=1;
        }
        System.out.println();
        L.deleteFirst();
        i=0;
        while(i<L.size()){
            System.out.println(L.get(i));
            i +=1;
        }
        System.out.println();
        i=0;
        int [] q = new int []{1,2,3,4,5};
        SLList n = new SLList(q);
        while(i<n.size()){
            System.out.println(n.get(i));
            i +=1;
        }
    }
}
