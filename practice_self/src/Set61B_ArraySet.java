import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * @author Li Zezhong
 * @create 2022-05-14 18:42
 */
public class Set61B_ArraySet<E> implements Set61B<E>,Iterable<E>{
    private E [] items;
    private int size;


    public Iterator<E> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<E>{
        private int position;

        public ArraySetIterator(){
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public E next() {
            E result = items[position];
            position +=1;
            return result;
        }
    }

    public Set61B_ArraySet(){
        items = (E[]) new Object[100];
        this.size = 0;
    }

    @Override
    public boolean add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if(contains(value)){
            return false;
        }
        items[size]=value;
        this.size +=1;
        return true;
    }

    @Override
    public boolean contains(E value) {
        for (int i = 0; i < size; i += 1) {
            if(items[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("{");
        int i=0;
        for(;i<size-1;i++){
            result.append(items[i].toString());
            result.append(", ");
        }
        result.append(items[i].toString());
        result.append("}");
        return result.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Set61B_ArraySet<E> o = (Set61B_ArraySet<E>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (E item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }
}
