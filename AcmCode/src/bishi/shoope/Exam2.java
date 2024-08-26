package bishi.shoope;

/**
 * @author daiYang_wu
 */
public class Exam2 {
    public static void main(String[] args) {
        System.out.println(reverses("Shopee is Our family 123"));
    }

    public static String reverses(String original_str) {
        // write code here
        String[] strs = original_str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            String n = reverse(s);
            sb.append( n + " ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static String reverse(String str) {
        char [] charArray = str.toCharArray();
        int l = 0, r = str.length() - 1;

        while (l < r) {
            while(!(charArray[l] - 'a' >= 0 && charArray[l] -'a' <= 25)){
                System.out.println(!(charArray[l] - 'a' >= 0 && charArray[l] -'a' <= 25)) ;
                if (l < r) l++;
                else break;
            }
            while(!(charArray[r] - 'a' >= 0 && charArray[r]  -'a' <= 25)){
                if (l < r) r--;
                else break;
            }
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
            l++;
            r--;
        }
        return String.valueOf(charArray);
    }
}
