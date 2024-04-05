package string;

/**
 * @author daiYang_wu
 */
public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("A");
        StringBuffer s2 = new StringBuffer("B");
        modify(s1,s2);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
    public static void modify(StringBuffer a,StringBuffer b){
        a.append(b);
        b = a;

    }
}
