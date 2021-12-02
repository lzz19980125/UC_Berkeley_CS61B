/**
 * @author Li Zezhong
 * @create 2021-12-02 15:29
 */


public class practice {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        Dog.bark();
        d1.bark();
        //Dog.shout();
        d1.shout();
    }
}

    class Dog{
    public static void bark(){
        System.out.println("bark!");
    }
    public void shout(){
        System.out.println("shout!");
    }
}





