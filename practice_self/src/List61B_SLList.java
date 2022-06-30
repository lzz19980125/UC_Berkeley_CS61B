/**
 * @author Li Zezhong
 * @create 2022-05-08 20:17
 */
public class List61B_SLList<item> implements List61B<item> {
    item first;
    List61B_SLList <item> next;

    public List61B_SLList(item first){
        this.first = first;
        next = null;
    }


    @Override
    public void addLast(item x) {
        this.next.first = x;
        this.next.next = null;
    }

    @Override
    public void addFrist(item x) {

    }

    @Override
    public item removeLast() {
        return null;
    }

    @Override
    public item get(int x) {
        return null;
    }

    @Override
    public item getFirst() {
        return null;
    }

    @Override
    public item getLast() {
        return null;
    }

    @Override
    public void insert(item x, int position) {

    }

    @Override
    public int size() {
        return 0;
    }
}
