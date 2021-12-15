/**
 * @author Li Zezhong
 * @create 2021-12-13 10:17
 */
public class lecture2_5 {

}

class AList<Item> implements List61B<Item>{
    Item [] items;
    int size;
    public AList() {
        this.items = (Item []) new Object [100];
        this.size = 0;
    }

    private void resize(int capacity){
            Item [] a = (Item []) new Object[capacity];
            System.arraycopy(items,0,a,0,size);
            items = a;
    }

    private void resize_first(int capacity){
        Item [] a = (Item []) new Object[capacity];
        System.arraycopy(items,0,a,1,size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(Item x) {
        if(size ==items.length){
            resize(size+1);
        }
        items[size]=x;
        size +=1;
    }

    @Override
    public void addFirst(Item x){
        resize_first(size+1);
        items[0] = x;
        size +=1;
    }

    /** Returns the item from the back of the list. */
    @Override
    public Item getFirst(){return items[0];}

    @Override
    public Item getLast() {
        return items[size-1];
    }

    /** Gets the ith item in the list (0 is the front). */
    @Override
    public Item get(int i) {
        return items[i];
    }

    @Override
    public void insert(Item x, int position) {
        Item [] a = (Item []) new Object[size+1];
        System.arraycopy(items,0,a,0,position);
        System.arraycopy(items,position,a,position+1,size-position);
        a[position]=x;
        items = a;
        size +=1;
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    @Override
    public Item removeLast() {
        Item results = items[size-1];
        items[size-1]= null;             //这一句是非必要的，因为我们目前与ArrayList的所有交互都是通过size进行，因此只需要改动size即可
        size -=1;
        return results;
    }
}