package communicator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Krzysztof Podlaski on 24.05.2018.
 */
public class Client implements Receiver{
    Communicator com;

    @Override
    public void receive(int c) {
        System.out.print((char) c);
    }

    void startAsClient(int port,  String address) throws IOException {
        Socket s = new Socket(address,port);
        com = new Communicator(s);
        com.addReceiver(this);
        com.connect();
        startKeyboard();
    }

    void startAsServer(int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        Socket s = ss.accept();
        com = new Communicator(s);
        com.addReceiver(this);
        com.connect();
        startKeyboard();
    }

    private void startKeyboard() {
        int c;
        try {
            while( (c = System.in.read())!=-1 ){
                com.send(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Client c = new Client();
            System.out.println("Im a Server");
            c.startAsServer(8001);

    }
}
