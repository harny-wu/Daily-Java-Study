package leetcode.byteTop;

/**
 * @author daiYang_wu
 */
public class compareVersion {
    public static void main(String[] args) {
        String v1 = "0001.1";
        String v2 = "001.1";
        System.out.println(compareVersion(v1,v2));
    }

    public static int compareVersion(String version1,String version2){
        String [] versions1 = version1.split("\\.");
        String [] versions2 = version2.split("\\.");
        removeZero(versions1);
        removeZero(versions2);
        for (int i = 0; i < versions1.length; i++){
            if (Integer.parseInt(versions1[i]) > Integer.parseInt(versions2[i])) return 1;
            if (Integer.parseInt(versions1[i]) < Integer.parseInt(versions2[i])) return -1;
        }
        return 0;
    }

    public static void removeZero(String [] vs){
        for (int k = 0; k < vs.length; k ++){
            String v = vs[k];
            if (v.length() == 1) continue;
            int start = 0;
            for (int i = 0 ; i < v.length(); i++){
                if (v.charAt(i) == '0') start++;
                else break;
            }
            vs[k] = v.substring(start);
        }
    }
}
