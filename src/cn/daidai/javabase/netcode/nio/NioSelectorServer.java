package cn.daidai.javabase.netcode.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wdy
 * @description: TODO
 * @date 2021/7/28 16:59
 */
public class NioSelectorServer {
    public static void main(String[] args) throws IOException {
        // create NIO ServerSocketChannel , 类似BIO中的ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
        //设置ServerSocketChannel为非阻塞
        serverSocketChannel.configureBlocking(false);
        //打开selector处理channal，即创建epoll
        Selector selector = Selector.open();
        //将ServerSocketChannel注册至Selector,SelectionKey.OP_ACCEPT:监听accept()事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("init nio service,port=8888");

        while (true) {
            //阻塞等待需要处理的事务发生
            selector.select();
            //获取selector中注册的全部事件的selectorKey实例
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            //遍历事件进行处理
            while (iterator.hasNext()) {
                SelectionKey sk = iterator.next();
                //如果是OP_ACCEPT 事件，则进行连接与事件注册
                if (sk.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) sk.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    //这里只注册了读事件，如果需要给客户端发送数据可以注册写事件
                    SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("client connect success!");
                } else if (sk.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len = socketChannel.read(byteBuffer);
                    if (len > 0) {
                        System.out.println("recive message:" + new String(byteBuffer.array()));
                    } else if (len == -1) {
                        System.out.println("client disconnect");
                        socketChannel.close();
                    }
                }
                iterator.remove();
            }
        }
    }
}
