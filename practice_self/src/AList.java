import java.util.Arrays;

/**
 * @author Li Zezhong
 * @create 2022-05-08 19:13
 */
public class AList  {
    private int size;
    private int [] item;

    public AList() {
        this.size = 0;
        this.item = new int [size];
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        item[size+1] =x;
        size +=1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return this.item[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return this.item[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return this.size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int x = this.getLast();
        size -=1;
        return x;
    }
}
