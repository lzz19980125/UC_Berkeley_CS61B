/**
 * @author Li Zezhong
 * @create 2022-05-08 20:07
 */
public interface List61B <item>{
    public void addLast(item x);
    public void addFrist(item x);
    public item removeLast();
    public item get(int x);
    public item getFirst();
    public item getLast();
    public void insert(item x,int position);
    public int size();
}
