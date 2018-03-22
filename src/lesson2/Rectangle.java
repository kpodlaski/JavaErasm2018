package lesson2;

import java.awt.*;

/**
 * Created by Krzysztof Podlaski on 22.03.2018.
 */
public class Rectangle extends Figure {
    private double w,h;

    public Rectangle(double x, double y, double w, double h){
        setPositionY(y);
        setPositionX(x);
        this.w=w;
        this.h=h;
    }

    public double getWidth() {
        return w;
    }

    public void setWidth(double w) {
        this.w = w;
    }

    public double getHeight() {
        return h;
    }

    public void setHeight(double h) {
        this.h = h;
    }

    @Override
    public void draw(Graphics g) {
        System.out.println("Drawing rectangle");
        g.drawRect((int) getPositionX(),
                (int) getPositionY(),
                (int) getWidth(),
                (int) getHeight());
    }
}
