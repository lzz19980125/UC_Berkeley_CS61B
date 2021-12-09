/**
 * @author Li Zezhong
 * @create 2021-12-07 20:15
 */
public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntNode incrList(IntNode L, int x) {
        /* Your code here. */
        int i=L.size()-1;
        IntNode p=new IntNode(L.get(i)+x,null);
        while(i>0){
            i -=1;
            p = new IntNode(L.get(i)+x,p);
        }
        return p;
    }


    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntNode dincrList(IntNode L, int x) {
        IntNode p = L;
        while(p !=null){
            p.first -=x;
            p = p.rest;
        }
        return L;
    }

    public static void main(String[] args) {
        IntNode L = new IntNode(5, null);
        L.rest = new IntNode(7, null);
        L.rest.rest = new IntNode(9, null);

//        System.out.println(L.size());
//        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
//        System.out.println(L.get(1));
        IntNode p = Lists1Exercises.incrList(L,2);
        int i=0;
//        System.out.println(p.size());
        while(i<p.size()){
            System.out.println(p.get(i));
            i +=1;
        }
        i=0;
        while(i<L.size()){
            System.out.println(L.get(i));
            i +=1;
        }
        IntNode m = Lists1Exercises.dincrList(L,2);
        i=0;
        while(i<L.size()){
            System.out.println(L.get(i));
            i +=1;
        }
//         System.out.println(dincrList(L, 3));
    }
}
