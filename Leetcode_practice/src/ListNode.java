import java.util.Arrays;

/**
 * @author Li Zezhong
 * @create 2022-05-14 9:44
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode last;
    public int size;
    public ListNode(int val){
        this.next = null;
        this.val = val;
        this.last = this;
        this.size = 1;
    }

    public ListNode(int val,ListNode next){
        this.next =next;
        this.val = val;
        this.last = this;
        this.size = 1;
    }


    public void add(int x){
        this.last.next = new ListNode(x);
        this.last = this.last.next;
        this.size ++;
    }

    public static ListNode ArrayToListNode(int [] list){
        ListNode result = new ListNode(list[0]);
        for(int i=1;i<list.length;i++){
            result.add(list[i]);
        }
        return result;
    }

    public void print(){
        if(size==0){
            System.out.println("null");
            return ;
        }
        ListNode p = this;
        StringBuilder string = new StringBuilder("[");
        while(p.next!=null){
            string.append(((Integer)p.val).toString());
            string.append(", ");
            p = p.next;
        }
        string.append(((Integer)p.val).toString());
        string.append("]");
        System.out.print(string.toString());
    }
}
