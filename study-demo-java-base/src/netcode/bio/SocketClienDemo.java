package netcode.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Lenovo
 * @description: TODO
 * @date 2021/7/26 23:22
 */
public class SocketClienDemo {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",9999);
        OutputStream outputStream = socket.getOutputStream();
        Class<? extends OutputStream> aClass = outputStream.getClass();
        System.out.println(aClass.getName());
        outputStream.write("hello,java网络编程".getBytes());
    }
}
