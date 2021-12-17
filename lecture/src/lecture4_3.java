import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Li Zezhong
 * @create 2021-12-16 16:30
 */

public class lecture4_3 {
    public static void main(String[] args){
        Dog[] dogs = new Dog[]{new Dog("Elyse", 3), new Dog("Sture", 9), new Dog("Benjamin", 15)};
        max(dogs).bark();
        Comparator<Dog> nc = Dog.getNameComparator();
        System.out.println(nc.compare(dogs[0],dogs[2]));
    }

    public static Dog max(Dog[] items){
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }

    public static void getWords(String inputFileName){
        List<String> lst = new ArrayList<String>();
        In in = new In();
        
    }
}

class Dog implements Comparable<Dog>{
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    @Override
    public int compareTo(Dog o) {
        return this.size - o.size;
    }

    private static class NameComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}

