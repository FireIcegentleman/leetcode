import jdk.nashorn.internal.runtime.arrays.IteratorAction;

import java.awt.image.RasterOp;
import java.awt.image.WritableRaster;
import java.util.*;

/**
 * 2021/09/16
 * 数组中的第k个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * */

/**
 * 两种方法：快速排序、堆排序
 *
 * 快速排序过程需要引入随机化的过程
 * http://haoyuanliu.github.io/2016/12/18/Partition%E7%AE%97%E6%B3%95%E5%89%96%E6%9E%90/
 *
 * */
public class _215_KthLargestElementinanArray {
    // 暴力解法
    private int findKthLargest_dir(int[] nums, int k) {
        // 排序
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();
        for (int num : nums){
            res.add(num) ;
        }
        Collections.reverse(res);
        return res.get(k - 1) ;
    }

    private Random random = new Random() ;
    // 快速排序
    private int findKthLargest_quick(int[] nums, int k) {
        int len = nums.length ;
        int left = 0 ;
        int right = len - 1 ;

        // 转换一下，第 k 大元素的下标是 len - k
        int target = len - k ;

        while(true){
            int index = partition(nums , left , right) ;
            if (index == target){
                return nums[index] ;
            }else if(index < target){
                left = index + 1 ;
            }else {
                right = index - 1 ;
            }
        }
    }

    // 引入随机化过程，在循环开始的时候随即交换第一个元素与它后面的任意一个元素
    // 在区间nums[left，right]执行Partition操作
    private int partition(int[] nums, int left, int right) {
        /*引入随机化*/
        if (right > left){
            int ran = left + 1 + random.nextInt(right - left) ;
            swap(nums , ran , left);
        }
        int pivot = nums[left]  ;
        int index = left ;

        for (int i = index + 1 ; i <= right ; i++){
            if (nums[i] < pivot){
                index++ ;
                swap(nums , index , i);
            }
        }

        swap(nums , index , left);
        //索引值
        return index ;
    }

    public void swap(int[] arr , int i , int j){
        int tmp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = tmp ;
    }

    private int findKthLargest(int[] nums, int k) {
        int len = nums.length ;

        buildMaxHeap(nums , len) ;

        for (int i = nums.length  - 1 ; i >= nums.length - k + 1 ; i--){
            swap(nums , 0 , i);
            --len ;
            heapify(nums , len , 0);
        }
        // 第k次调整时的最大值
        return nums[0] ;
    }

    private void buildMaxHeap(int[] nums, int len) {
        for (int i = (int)Math.floor(len / 2) ; i >= 0 ; i--){
            heapify(nums , len , i) ;
        }
    }

    private void heapify(int[] nums, int len, int i) {
        int left = 2 * i + 1 ;
        int right = 2 * i + 2 ;
        int largest = i ;

        if (left < len && nums[left] > nums[largest]){
            largest = left ;
        }
        if (right < len && nums[right] > nums[largest]){
            largest = right ;
        }

        if (largest != i){
            swap(nums , largest , i);
            heapify(nums , len , largest);
        }
    }

    public static void main(String[] args) {
        _215_KthLargestElementinanArray obj = new _215_KthLargestElementinanArray() ;
        int[] nums = {3,2,3,1,2,4,5,5,6} ;
        int k = 4 ;
        System.out.println(obj.findKthLargest(nums, k));
    }
}
