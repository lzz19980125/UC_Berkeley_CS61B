/**
 * @author Li Zezhong
 * @create 2021-12-13 10:17
 */
public class lecture_2_5 {

}

class AList {
    int [] items;
    int size;
    public AList() {
        this.items = new int [100];
        this.size = 0;
    }

    private void resize(int capacity){
            int [] a = new int [capacity];
            System.arraycopy(items,0,a,0,size);
            items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(size ==items.length){
            resize(size+1);
        }
        items[size]=x;
        size +=1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int results = items[size-1];
        items[size-1]=0;             //这一句是非必要的，因为我们目前与ArrayList的所有交互都是通过size进行，因此只需要改动size即可
        size -=1;
        return results;
    }
}