package netcode.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author wdy
 * @description: TODO
 * @date 2021/7/26 23:29
 */
public class SocketServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("init servet,port=9999");
        while (true){
            //BIO
            Socket socket=serverSocket.accept();
            new Thread(()->{
                try {
                    handle(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    public static void handle(Socket socketclient) throws IOException {
        InputStream inputStream=socketclient.getInputStream();
        byte[]buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            String msg=new String(buffer,0,len);
            System.out.println(msg);
            System.out.println(Arrays.toString(buffer));
        }
    }
}
