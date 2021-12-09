/**
 * @author Li Zezhong
 * @create 2021-12-07 21:58
 */
public class IntNode {
    public int first;
    public IntNode rest;

    public IntNode(int f, IntNode r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if(rest ==null){
            return 1;
        }
        return 1+rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntNode p = this;
        int size = 1;
        while(p.rest != null){
            size +=1;
            p = p.rest;
        }
        return size;
    }

    /** Returns the ith value in this list.*/
    public int get(int i) {
        if(i==0){
            return first;
        }
        return rest.get(i-1);
    }

    public static void main(String[] args) {
        IntNode L = new IntNode(15, null);
        L = new IntNode(10, L);
        L = new IntNode(5, L);

//        System.out.println(L.iterativeSize());
//        System.out.println(L.get(0));
        System.out.println(L.iterativeSize());
    }
}
