package Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

//为每一个客户端分配一个线程
public class EchoServer {

    public ServerSocket socketServer;

    public int port=8000;

    public  EchoServer() throws IOException {
        this.socketServer=new ServerSocket(port);
        System.out.println("服务器已经启动!");
    }

    ExecutorService es = Executors.newCachedThreadPool();
    class Handler implements Runnable{

        Socket socket;
        public Handler(Socket socket) {
            this.socket=socket;
        }

        @Override
        public void run() {
            System.out.println("连接成功："+Thread.currentThread().getId());
            try {
                socket.close();
                System.out.println("断开连接");
            } catch (IOException e) {
                System.out.println("断开连接失败");
            }
        }
    }

    public void Service() throws IOException {//服务端方法
        Socket socket = null;
        while (true){
            socket=socketServer.accept();
            //Thread socketThread = new Thread(new Handler(socket));
            es.submit(new Handler(socket));
        }
    }

    public static void main(String args[]) throws IOException {
        new EchoServer().Service();
    }
}
