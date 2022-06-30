/**
 * @author Li Zezhong
 * @create 2022-05-10 22:04
 */
public interface Map61B <item>{
    public void put(item key,int value);
    public boolean containsKey(item key);
    public int get(item key);
    public SLList keys();
    public int size();
}
