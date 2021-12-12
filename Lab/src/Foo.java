/**
 * @author Li Zezhong
 * @create 2021-12-12 18:16
 */

public class Foo {
    public int x, y;
    public Foo (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void switcheroo (Foo a, Foo b) {
        Foo temp = a;
        a = b;
        b = temp;
    }

    public static void fliperoo (Foo a, Foo b) {
        Foo temp = new Foo(a.x, a.y);
        a.x = b.x;
        a.y = b.y;
        b.x = temp.x;
        b.y = temp.y;
    }

    public static void swaperoo (Foo a, Foo b) {
        Foo temp = a;
        a.x = b.x;
        a.y = b.y;
        b.x = temp.x;
        b.y = temp.y;
    }

    public static void main (String[] args) {
        Foo foobar = new Foo(10, 20);
        Foo baz = new Foo(30, 40);
        switcheroo(foobar, baz);
        System.out.println("foobar.x="+foobar.x+" foobar.y="+foobar.y+" baz.x="+baz.x+" baz.y="+baz.y);
        System.out.println();
        fliperoo(foobar, baz);
        System.out.println("foobar.x="+foobar.x+" foobar.y="+foobar.y+" baz.x="+baz.x+" baz.y="+baz.y);
        System.out.println();
        swaperoo(foobar, baz);
        System.out.println("foobar.x="+foobar.x+" foobar.y="+foobar.y+" baz.x="+baz.x+" baz.y="+baz.y);
    }
}
