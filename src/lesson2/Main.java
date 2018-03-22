package lesson2;

/**
 * Created by Krzysztof Podlaski on 22.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        Figure f1 = new Circle(12.3,-13,45);
        Figure f2 = new Rectangle(-12.22,
                23,45,20);
        //f1.draw();
        //f2.draw();
        Figure figs[] = new Figure[2];
        figs[0]=f1;
        figs[1]=f2;
    }
}
