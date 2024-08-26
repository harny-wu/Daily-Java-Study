package leetcode.byteTop;

import java.util.Arrays;

/**
 * @author daiYang_wu
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println(18 / 10);
        System.out.println(18 % 10);
        int i;
        int arr[] = {30, 40, 60, 10, 20, 50};
        System.out.println(Arrays.toString(arr));

//        quickSort(arr, 0, arr.length - 1);
        mergeSort(arr,0,arr.length-1,new int[arr.length]);

        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();

    }


    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;

        // 第一种方式，找到 nums[x] 的填空处
        int i = l, j = r, x = arr[i]; // 第一个当基准点

        while (i < j) {
            while (i < j && arr[j] > x) j--;
            if (i < j) arr[i++] = arr[j];
            while (i < j && arr[i] < x) i++;
            if (i < j) arr[j--] = arr[i];
        }

        // 此时 i 是待填处
        arr[i] = x;
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);


//        while(i < j){
//            while(arr[i] < x) i++;
//            while(arr[j] < x) j--;
//            swap(arr,i,j);
//        }



    }

    public static void mergeSort(int[] arr, int l, int r, int[] temp) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid, temp);
            mergeSort(arr, mid + 1, r, temp);
            merge(arr, l, mid, r, temp);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r, int[] temp) {
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r){
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while(i <= mid) temp[k++] = arr[i++];
        while(j <= r) temp[k++] = arr[j++];

        k = 0;
        while(l <= r){
            arr[l++] = temp[k++];
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
