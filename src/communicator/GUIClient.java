package communicator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Krzysztof Podlaski on 24.05.2018.
 */
public class GUIClient implements Receiver{
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton sendButton;
    private JButton startAsServerButton;
    private JButton startAsClientButton;
    private JPanel mainpanel;
    private Communicator com;

    public GUIClient() {
        startAsServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerSocket ss = null;
                try {
                    ss = new ServerSocket(8000);
                    com = new Communicator(ss.accept());
                    com.addReceiver(GUIClient.this);
                    com.connect();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        startAsClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket s = new Socket("localhost",8000);
                    com = new Communicator(s);
                    com.addReceiver(GUIClient.this);
                    com.connect();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String text = textField1.getText();
                    byte[] msg = text.getBytes();
                    for(int i = 0; i<msg.length; i++){
                        com.send(msg[i]);

                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    @Override
    public void receive(int c) {
        textArea1.append(""+(char) c);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIClient");
        frame.setContentPane(new GUIClient().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
