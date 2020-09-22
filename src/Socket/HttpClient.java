package Socket;


import java.io.*;
import java.net.Socket;

public class HttpClient {

    String host="www.javathinker.net";
    String port="80";

    Socket socket;

    public void createSocket() throws IOException {
        socket=new Socket(host,80);
    }

    public void communicate() throws IOException {
        StringBuffer str = new StringBuffer("GET " +
                "/index.jsp"+" HTTP/1.1\r\n");
        str.append("Host: "+host+"\r\n");
        str.append("Accept:*/*\r\n");
        str.append("Accept-Language:zh-cn\r\n");
        str.append("Accept-Encoding:gzip,deflate\r\n");
        str.append("User-Agent:HTTPClient\r\n");
        str.append("Connection:keep-Alive\r\n\r\n");

        OutputStream socketOut=socket.getOutputStream();
        socketOut.write(str.toString().getBytes());
        socketOut.flush();

        InputStream socketIn=socket.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] buff=new byte[1024];
        int len=-1;
        while((len=socketIn.read(buff))!=-1){
            buffer.write(buff,0,len);
        }

        System.out.println(new String(buffer.toByteArray()));
        socket.close();
    }

    public static void main(String args[]) throws IOException {
        HttpClient client = new HttpClient();
        client.createSocket();
        client.communicate();
    }
}
