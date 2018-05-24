package communicator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Krzysztof Podlaski on 24.05.2018.
 */
public class Communicator {
    private Socket socket;
    private OutputStream out;
    private Receiver receiver;

    public Communicator(Socket s){
        this.socket=s;
    }

    public void addReceiver(Receiver r){
        receiver=r;
    }

    public void connect() throws IOException {
        Thread listener = new Thread(new SocketListener());
        out = socket.getOutputStream();
        listener.start();
    }

    public void send(int c) throws IOException {
        out.write(c);
    }

    class SocketListener implements Runnable {
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                int c;
                while ((c = in.read())!=-1 ){
                    receiver.receive(c);
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
