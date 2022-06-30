/**
 * @author Li Zezhong
 * @create 2022-05-20 16:02
 */

public class BST61B{
    public static void main(String[] args) {

    }
}

 class BST <Key> {
    public Key key;
    public BST left;
    public BST right;

    public BST(Key key){
        this.key = key;
    }

    public BST(BST left,BST right,Key key){
        this.left = left;
        this.right = right;
        this.key = key;
    }

    /* 如果树非常浓密，则该操作时间复杂度为Θ(log(N)) (log(N)为树高)
    * 注意：这里应该为课上写的pseudo code，正式的代码需要你在对应的lab中完成！ */
    public static BST search(BST T,Key key){
        if(T==null){
            return null;
        }
        if(T.key.equals(key)){
            return T;
        } else if(key>T.key){
            return search(T.right,key);
        } else{
            return search(T.left,key);
        }
    }


     /* 利用递归实现BST的insert操作！
      * 注意：这里应该为课上写的pseudo code，正式的代码需要你在对应的lab中完成！ */
    public static BST insert(BST T, Key ik){
        if(T==null){
            return new BST(ik);
        }
        if(ik<T.key){
            T.left = insert(T.left,ik);
        }
        else if(ik>T.key){
            T.right = insert(T.right,ik);
        }
        return T;
    }
//
//    public static BST delete(){
//
//    }
}
