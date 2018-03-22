package lesson2;

import java.awt.*;

/**
 * Created by Krzysztof Podlaski on 22.03.2018.
 */
public abstract class Figure {
    private double x,y;

    public abstract void draw(Graphics g);

    public void move(double dx, double dy){
        x+=dx;
        y+=dy;
    }

    public double getPositionX(){
        return x;
    }

    public void setPositionX(double x){
        this.x=x;
    }

    public double getPositionY(){
        return y;
    }

    public void setPositionY(double y){
        this.y=y;
    }
}
