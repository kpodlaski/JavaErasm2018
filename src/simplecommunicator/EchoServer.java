package simplecommunicator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Krzysztof Podlaski on 24.05.2018.
 */
public class EchoServer {

    private final int port;
    private Socket socket;
    private OutputStream out;

    public EchoServer(int port) {
        this.port = port;
    }
    public static void main(String[] args) throws IOException {
        int port =8000;
        EchoServer server = new EchoServer(port);
        server.waitForClients();
    }

    private void waitForClients() throws IOException {
        ServerSocket ss = new ServerSocket(port);
        socket = ss.accept();
        System.out.println("Connection is Open");
        Thread listener = new Thread(new SocketListener());
        out = socket.getOutputStream();
        listener.start();
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
                    //Echo == send this back
                    send(c);
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
