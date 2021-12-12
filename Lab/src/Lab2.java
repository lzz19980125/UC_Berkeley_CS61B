/**
 * @author Li Zezhong
 * @create 2021-12-10 20:34
 */


public class Lab2 {
    public static void main(String[] args) {
        IntList list1 = new IntList(3,null);
        list1.rest = new IntList(2,null);
        list1.rest.rest = new IntList(1,null);

        IntList list2 = new IntList(6,null);
        list2.rest = new IntList(5,null);
        list2.rest.rest = new IntList(4,null);

//        IntList.print_List(list1);
//        IntList.print_List(IntList.copy(list1));
//        IntList.dSquareList(list1);
//        IntList.print_List(list1);
//        IntList.print_List(IntList.squareListIterative(list1));
//        System.out.println();
//        IntList.print_List(list1);
//        IntList.print_List(IntList.dcatenate(list1,list2));
//        IntList.print_List(IntList.catenate(list1,list2));
//        System.out.println();
//        IntList.print_List(list1);


    }
}


