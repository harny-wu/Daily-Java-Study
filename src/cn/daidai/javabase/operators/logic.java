package cn.daidai.javabase.operators;

/**
 * @author Lenovo
 * @description: TODO
 * @date 2021/7/27 22:39
 */
public class logic {
    public static void main(String[] args) {
        int i=2;
        int j=11;
        System.out.println("i="+i);
        System.out.println("i binary="+Integer.toBinaryString(i));
        System.out.println("j binary="+Integer.toBinaryString(j));
        System.out.println("i<< binary="+Integer.toBinaryString(i<<2));
        System.out.println("i<<="+(i<<2));
        System.out.println("~i binary:="+Integer.toBinaryString(~i));
        System.out.println("~i="+~i);
        System.out.println(i&j);
    }
}
