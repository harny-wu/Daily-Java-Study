package cn.daidai.javabase.ioclass;

import java.io.*;

/**
 * @author Lenovo
 * @description: TODO
 * @date 2021/7/26 23:18
 */
public class IoDemo {
    public static void main(String[] args) throws IOException {
        File f=new File("D:\\code\\codeplace\\JavaStudy\\DataStruckAndAlg\\src\\cn\\daidai\\javabase\\ioclass\\data.txt");
        System.out.println(f.exists());
        InputStream inputStream=new FileInputStream(f);
        byte[]buff=new byte[1024];
        int len;
        while((len=inputStream.read(buff))!=-1){
            System.out.println(buff);
        }
    }
}
