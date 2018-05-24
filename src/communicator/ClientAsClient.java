package communicator;

import java.io.IOException;

/**
 * Created by Krzysztof Podlaski on 24.05.2018.
 */
public class ClientAsClient {

    public static void main(String[] args) throws IOException {
           Client c = new Client();
        System.out.println("Im a Client");
           c.startAsClient(8001,"localhost");


    }
}
