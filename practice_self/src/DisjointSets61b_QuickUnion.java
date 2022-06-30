/**
 * @author Li Zezhong
 * @create 2022-05-19 22:28
 */
public class DisjointSets61b_QuickUnion implements DisjointSets61B{
    private int[] id;

    public DisjointSets61b_QuickUnion(int N){
        id = new int[N];
        for(int i=0;i<id.length;i++){
            id[i]=i;
        }
    }

    public int find(int item){
        if(id[item]==-1){
            return item;
        }
        return find(id[item]);
    }

    /*Quick Union
    Time Complexity:上限（最坏情况）为：O(N)*/
    @Override
    public void connect(int p, int q) {
        id[find(p)] = find(q);
    }

    /*
    Time Complexity:上限（最坏情况）为：O(N)*/
    @Override
    public boolean isConnected(int p, int q) {
        return (find(p)==find(q));
    }
}
