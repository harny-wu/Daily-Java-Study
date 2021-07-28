package cn.daidai.javabase.netcode.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wdy
 * @description: TODO
 * @date 2021/7/28 15:37
 */
public class NioServer {
    //保存客户端链接
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // create NIO ServerSocketChannel , 类似BIO中的ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        //设置ServerSocketChannel为非阻塞
        serverSocketChannel.configureBlocking(false);
        System.out.println("init nio service,port=9000");

        while (true) {
            //非阻塞模式下accept 方法不会阻塞，
            //NIO 的非阻塞是由操作系统内部实现的，底层调用了linux内核的accept函数
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                System.out.println("connect success");
                //设置socketChannel同样为非阻塞
                socketChannel.configureBlocking(false);
                channelList.add(socketChannel);
            }
            // 遍历连接读取数据
            Iterator<SocketChannel> iterator = channelList.iterator();
            while (iterator.hasNext()) {
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                int len = sc.read(byteBuffer);
                if (len > 0) {
                    System.out.println("recive message:" + new String(byteBuffer.array()));
                } else if (len == -1) {
                    iterator.remove();
                    System.out.println("client disconnect");
                }
            }
        }
    }
}
