/**
 * 2021/09/17
 *
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * */
package Sort;

public class HeapSort {


    private static void swap(int[] a, int i, int j){
        int tmp = a[i] ;
        a[i] = a[j] ;
        a[j] = tmp ;
    }

    // 倒数第二层
    private static void buildMaxHeap(int[] arr, int len){
        // 最后一个数的父节点
        for (int i = (int)Math.floor(len / 2) ; i >= 0 ; i--){
            heapify(arr , i , len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1 ;
        int right = 2 * i + 2 ;
        int largest = i ;

        if (left < len && arr[left] > arr[largest]){
            largest = left ;
        }
        if (right < len && arr[right] > arr[largest]){
            largest = right ;
        }

        if (largest != i){
            swap(arr , i , largest);
            heapify(arr , largest , len);
        }
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort() ;
        int[] nums = new int[]{5,9,2,1,4,7,5,8,3,6} ;

        int len = nums.length ;

        buildMaxHeap(nums , len) ;

        for (int i = len - 1 ; i > 0 ; i--){
            swap(nums , 0 , i) ;
            len-- ;
            heapify(nums , 0 , len) ;
        }
        for (int num : nums){
            System.out.print(num);
        }
    }
}

/**
 * 堆是一个近似完全二叉树的结构，并同时满足堆积的性质：子节点的键值或索引总是小于（或大于）其父节点
 * */
