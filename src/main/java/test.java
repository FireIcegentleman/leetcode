import java.util.HashSet;
import java.util.Set;

/**
 * https://codetop.cc/home 企业高频题目
 * */
public class test {
    public static Set<Integer> set = new HashSet<>();
    public static int tmp = 0 ;

    public static void main(String[] args) {
        int[] arr = {2,2,4,4,4,4};
        fullSort(arr, 0, arr.length - 1);
        for (int i : set){
            System.out.print(i + ",");
        }
    }

    public static void fullSort(int[] arr, int start, int end) {
        // 递归终止条件
        if (start == end) {
            for (int i : arr) {
                tmp = tmp * 10 + i ;
            }
            set.add(tmp) ;
            tmp = 0 ;
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(arr, start + 1, end);
            swap(arr, i, start);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
