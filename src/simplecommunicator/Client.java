package simplecommunicator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Krzysztof Podlaski on 24.05.2018.
 */
public class Client {

    private final int port;
    private final String address;
    private Socket socket;
    private OutputStream out;

    public Client(int port, String ip) {
        this.port=port;
        this.address=ip;
    }

    public static void main(String[] args) throws IOException {
        int port = 8000;
        String ip = "localhost";//127.0.0.1
        Client c = new Client(port, ip);
        c.connect();
    }

    private void connect() throws IOException {
        socket = new Socket(address,port);
        out = socket.getOutputStream();
        Thread listener = new Thread(new SocketListener());
        listener.start();
        startKebord();
    }

    private void startKebord() {
        int c;
        try {
            while( (c = System.in.read())!=-1 ){
                send(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void send(int c){
        try {
            out.write(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class SocketListener implements Runnable {
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                int c;
                while ((c = in.read())!=-1 ){
                    System.out.println((char) c);
                }
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
