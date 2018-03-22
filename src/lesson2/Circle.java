package lesson2;

import java.awt.*;

/**
 * Created by Krzysztof Podlaski on 22.03.2018.
 */
public class Circle extends Figure {
    private double r;

    public Circle(double x, double y, double r){
        setPositionX(x);
        setPositionY(y);
        this.r=r;
    }

    @Override
    public void draw(Graphics g) {
        System.out.println("Drawing a circle");
        g.fillOval((int) (getPositionX()-getRadius()),
                (int) (getPositionY()-getRadius()),
                (int) (2.0*getRadius()),
                (int) (2*getRadius())
        );

    }

    public void setRadius(double r){
        this.r=r;
    }

    public double getRadius(){
        return r;
    }
}
