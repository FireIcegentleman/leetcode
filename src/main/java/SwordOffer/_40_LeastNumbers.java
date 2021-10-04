package SwordOffer;

import java.util.Arrays;
import java.util.Random;

/**
 * 2021/10/04
 *
 * 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * */
public class _40_LeastNumbers {
    public int[] getLeastNumbers_force(int[] arr, int k) {
        Arrays.sort(arr);

        int[] res = new int[k] ;
        for (int i = 0 ; i < k ; i++){
            res[i] = arr[i] ;
        }
        return res ;
    }
    // 堆排解决问题
    public int[] getLeastNumbers_heap(int[] arr, int k) {
        int len = arr.length ;

        int[] res = new int[k] ;
        buildMaxHeap(arr , len) ;

        for (int i = len - 1 ; i >= 0 ; i--){
            swap(arr , 0 , i);
            len-- ;
            heapify(arr , 0 , len);
        }

        for (int i = 0 ; i < k ; i++){
            res[i] = arr[i] ;
        }
        return res ;
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1 ;
        int right = 2 * i + 2 ;
        int largest = i ;

        if (left < len && arr[largest] < arr[left]){
            largest = left ;
        }

        if (right < len && arr[largest] < arr[right]){
            largest = right ;
        }

        if (largest != i){
            swap(arr , i , largest);
            heapify(arr , largest , len);
        }
    }

    // 倒数第二层
    private static void buildMaxHeap(int[] arr, int len){
        // 最后一个数的父节点
        for (int i = (int)Math.floor(len / 2) ; i >= 0 ; i--){
            heapify(arr , i , len);
        }
    }

    private static void swap(int[] a, int i, int j){
        int tmp = a[i] ;
        a[i] = a[j] ;
        a[j] = tmp ;
    }

    public Random random = new Random() ;
    public int[] getLeastNumbers(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public static void main(String[] args) {
        _40_LeastNumbers obj = new _40_LeastNumbers() ;
        int[] arr = {0,0,1,2,4,2,2,3,1,4} ;
        int k = 8 ;
        System.out.println(Arrays.toString(obj.getLeastNumbers(arr, k)));
    }
}
