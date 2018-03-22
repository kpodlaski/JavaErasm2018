package lesson2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by Krzysztof Podlaski on 22.03.2018.
 */
public class MainGUI {
    private JTextField textField1;
    private JButton button1;
    private JPanel panel;
    private JPanel drawingPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainGUI");
        frame.setContentPane(new MainGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
    }

    public MainGUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
                textField1.setText(text+" "+"AAA");
                MyJPanel mjpanel = (MyJPanel) drawingPanel;
                mjpanel.figs[0].move(20,20);
                drawingPanel.repaint();
            }
        });
        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                MyJPanel mjpanel = (MyJPanel) drawingPanel;
                mjpanel.figs[1].setPositionX(e.getX());
                mjpanel.figs[1].setPositionY(e.getY());
                drawingPanel.repaint();
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        drawingPanel =new MyJPanel();
    }
}
