package Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SocketTest {

    public static void main(String args[]) throws UnknownHostException {

        InetAddress addr = InetAddress.getByName("180.101.49.12");
        System.out.println(addr.getCanonicalHostName());
    }

}
