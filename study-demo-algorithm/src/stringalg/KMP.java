package stringalg;

import java.util.Arrays;

/**
 * @author wdy
 * @description: KMP ALG Implenment
 * @date 2021/7/24 11:42
 */
public class KMP {
    /**
     * @description:暴力解法
     * @param: ts:主串 ps:匹配串
     * @return: int
     * @author wdy
     * @date: 2021/7/24 13:25
     */
    public static int bruteForce(String ts, String ps) {
        if (ps == "") return -1;
        char[] tsarray = ts.toCharArray();
        char[] psarray = ps.toCharArray();
        for (int i = 0; i < tsarray.length; i++) {
            for (int j = 0; j <= psarray.length; j++) {
                if (j == psarray.length) return i;
                if (psarray[j] != tsarray[i + j]) break;
            }
        }
        return -1;
    }

    /**
     * @description: {@link # "https://upload-images.jianshu.io/upload_images/11023579-8e5da803cfa21d91.png?imageMogr2/auto-orient/strip|imageView2/2/w/1200/format/webp"}
     * 原理:主串在前后缀相同情况下可以不用比较，直接从前后缀长度+1的位置开始匹配
     * @param: ts:主串
     * @return: int[]
     * @author wdy
     * @date: 2021/7/24 16:54
     */
    public static int[] getKmpNext(String ps) {
        char[] psarray = ps.toCharArray();
        int[] nexts = new int[psarray.length];
        nexts[0] = 0;
        int now = 0;
        for (int i = 1; i < psarray.length; i++) {
            if (psarray[i] == psarray[now]) {
                now += 1;
                nexts[i] = now;
            } else {
                now = 0;
                nexts[i] = now;
            }
        }
        return nexts;
    }

    /**
     * @description:
     * ts:dabxabxababxabwabxad ps:abxabwabxad next=[0, 0, 0, 1, 2, 0, 1, 2, 3, 4, 0]
     *
     * @author wdy
     * @date 2021/7/24 20:23
     */
    public static int kmp(String ts, String ps) {
        if (ps == "") return -1;
        char[] tsarray = ts.toCharArray();
        char[] psarray = ps.toCharArray();
        int[] nexts = getKmpNext(ps);
        System.out.println(Arrays.toString(nexts));
        int t_idx=0;
        int p_idx=0;
        while (t_idx < tsarray.length && p_idx < psarray.length) {
            if(tsarray[t_idx]==psarray[p_idx]){
                p_idx++;
            }else{
                if(p_idx>0)
                    p_idx=nexts[p_idx-1];
            }
            if(p_idx==psarray.length) return t_idx-p_idx+1;
            t_idx++;
        }
        return -1;

    }

    public static void main(String[] args) {
        int res = KMP.kmp("dabxabxababxabwabxad", "abxabwabxad");
        System.out.println(res);
    }
}
