package lesson1;

/**
 * Created by Krzysztof Podlaski on 15.03.2018.
 */
public class OurFirstJavaClass {
    private int x;
    private double y;
    private String str;

    public double multiplication()
    {
        return x*y;
    }
    public static void main(String[] args) {
        System.out.println("Hello to you");
        OurFirstJavaClass ofjc = new OurFirstJavaClass();
        ofjc.x =12;
        ofjc.y = 154.22;
        ofjc.str = "Something";
        ofjc.str = new String("Something");
        System.out.println(
                ofjc.multiplication());
        System.out.println("an object "+ofjc);
        OurFirstJavaClass ofjc2 = new OurFirstJavaClass();
        ofjc2.x=12;
        ofjc2.y = 154.22;
        System.out.println(ofjc==ofjc2);
        System.out.println(ofjc.equals(ofjc2));
    }

    @Override
    public String toString() {
        return "OurFirstJavaClass{" +
                "x=" + x +
                ", y=" + y +
                ", str='" + str + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OurFirstJavaClass that = (OurFirstJavaClass) o;

        if (x != that.x) return false;
        return Double.compare(that.y, y) == 0;
    }


}
