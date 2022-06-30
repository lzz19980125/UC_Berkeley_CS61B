/**
 * @author Li Zezhong
 * @create 2022-05-19 21:45
 */
public class DisjointSets61b_QuickFind implements DisjointSets61B{
    private int[] id;

    public DisjointSets61b_QuickFind(int N){
        id = new int[N];
        for(int i=0;i<id.length;i++){
            id[i]=i;
        }
    }

    /*
    Time Complexity:Θ(N) */
    @Override
    public void connect(int p, int q) {
        for(int i=0;i<id.length;i++){
            if(id[i]==id[p]){
                id[i]=id[q];
            }
        }
    }

    /*Quick Find
    Time Complexity:O(1) */
    @Override
    public boolean isConnected(int p, int q) {
        return (id[p]==id[q]);
    }
}
