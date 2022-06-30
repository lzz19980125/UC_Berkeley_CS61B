/**
 * @author Li Zezhong
 * @create 2022-05-08 19:11
 */
public class SLList {
        static class IntNode {
            public int item;
            public IntNode next;

            public IntNode(int i, IntNode n) {
                item = i;
                next = n;
            }
        }

        private IntNode first;
        private int size;
        private IntNode sentinel;
        public SLList(int x) {
            first = new IntNode(x, null);
            sentinel = new IntNode(0,first);
            size = 1;
        }

        public SLList(){
            sentinel = new IntNode(0,null);
            first = null;
            size = 0;
        }

        public int getFirst(){
            return this.first.item;
        }

        public void addFirst(int b){
            this.sentinel.next = new IntNode(b, this.first);
            this.first = this.sentinel.next;
            this.size +=1;
        }

        public void addLast(IntNode p, int x){
            if(p.next ==null) {
                p.next = new IntNode(x, null);
            } else{
                addLast(p.next,x);
            }
        }

        public void addLast(int x){
            addLast(this.sentinel,x);
            this.size +=1;
        }

        public int size(){
            return this.size;
        }

        public void print_SLList(){
            IntNode p =this.first;
            while(p.next !=null){
                System.out.println(p.item);
                p = p.next;
            }
            System.out.println(p.item);
        }
}
