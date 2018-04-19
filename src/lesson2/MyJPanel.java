package lesson2;

import java.awt.*;

/**
 * Created by Krzysztof Podlaski on 22.03.2018.
 */
public class MyJPanel extends javax.swing.JPanel {
    Figure figs[];
    Color  colors[];

    public MyJPanel(){
        figs = new Figure[2];
        figs[0]=new Rectangle(12,13,45,23);
        figs[1]=new Circle(123,145,15);

        colors = new Color[2];
        colors[0] = Color.BLUE;
        colors[1] = new Color(56,156,2);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int i=0;
        for(Figure f : figs){
            g.setColor(colors[i++]);
            f.draw(g);
        }
    }
}
