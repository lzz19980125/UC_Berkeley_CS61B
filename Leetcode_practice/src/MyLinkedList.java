/**
 * @author Li Zezhong
 * @create 2022-06-24 17:42
 */

class MyLinkedList {
    static class ListNODE {
        ListNODE next;
        int val;
        public ListNODE(int val, ListNODE next){
            this.val = val;
            this.next = next;
        }
    }

    ListNODE first;
    int size;

    public MyLinkedList() {
        this.first = new ListNODE(-1, null);
        this.size=0;
    }

    public int get(int index) {
        if(index>=size||index<0){return -1;}
        int i=0;
        ListNODE p1 = this.first.next;
        while(i<index){
            p1 = p1.next;
            i++;
        }
        return p1.val;
    }

    public void addAtHead(int val) {
        this.first.next = new ListNODE(val, this.first.next);
        this.size++;
    }

    public void addAtTail(int val) {
        ListNODE p1 = this.first;
        while(p1.next!=null){
            p1 = p1.next;
        }
        p1.next = new ListNODE(val, null);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(index<=0){
            this.addAtHead(val);
            return ;
        }
        int i=0;
        ListNODE p1 = this.first;
        while(i<index){
            p1 = p1.next;
            i++;
        }
        p1.next = new ListNODE(val, p1.next);
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=size){return ;}
        int i=0;
        ListNODE p1 = this.first;
        while(i<index){
            p1 = p1.next;
            i++;
        }
        p1.next = p1.next.next;
        size--;
    }

    public void print(){
        ListNODE p = this.first.next;
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

