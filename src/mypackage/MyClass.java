package mypackage;

/**
 * Created by Krzysztof Podlaski on 23.03.2018.
 */
public class MyClass {
    public int x;
    private double r;
    protected String name;
    int y; //package access

    void increseX(int v){
        x=x+v;
    }
    void multiplyR(double f){
        r=r*f;
    }

    public static void main(String[] a){
        MyClass obj = new MyClass();
        obj.x=12;
        obj.r=12.5;
        MyClass obj2 = new MyClass();
        obj2.increseX(3);
        System.out.println(obj.x);
        System.out.println(obj2.x);
    }
}

