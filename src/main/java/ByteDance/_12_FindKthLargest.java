package ByteDance;

import java.util.Random;

/**
 * 2021/10/31
 *
 * 数组中的第k个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 手写排序法，然后返回倒数第K个最大的元素
 *
 * 快速排序+随机化
 * */
public class _12_FindKthLargest {
    // 先排序，然后返回倒数第k个位置的值
    public int findKthLargest_quick(int[] nums, int k) {
        int len = nums.length ;
        int left = 0 ;
        int right = len - 1 ;

        // 第K大的元素的索引下标
        int target = len - k ;

        while (true){
            int index = partition(nums , left , right) ;
            if (index == target){
                return nums[index] ;
            }else if(index < target){
                left = index + 1 ;
            }else{
                right = index - 1 ;
            }
        }
    }

    public Random random = new Random() ;
    private int partition(int[] nums, int left, int right) {
        // 引入随机化过程，避免极限情况
        if (right < left){
            int tmp = left + 1 + random.nextInt(right - left) ;
            swap(nums , tmp , left) ;
        }

        int pivot = nums[left] ;
        int index = left ;

        for (int i = left + 1 ; i <= right ; i++){
            if (nums[i] < pivot){
                index++ ;
                swap(nums , index , i);
            }
        }

        swap(nums , left , index);
        return index ;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a] ;
        nums[a] = nums[b] ;
        nums[b] = tmp ;
    }

    // 堆排序，大顶堆
    private int findKthLargest(int[] nums, int k) {
        int len = nums.length ;

        buildHeap(nums , len) ;

        for (int i = nums.length - 1 ; i >= nums.length - k + 1 ; i--){
            swap(nums , 0 , i);
            len-- ;
            heapify(nums , len , 0);
        }
        return nums[0] ;
    }

    private void buildHeap(int[] nums, int len) {
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
        _12_FindKthLargest obj = new _12_FindKthLargest() ;
        int[] nums = {3,2,1,5,6,4} ;
        int k = 2 ;
        System.out.println(obj.findKthLargest_quick(nums , k));
    }

}
