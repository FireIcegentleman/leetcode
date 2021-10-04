/**
 * 2021/09/17
 * */
package Sort;

public class QuickSort {
    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right){
            int partitionIndex = partition(arr , left , right) ;
            quickSort(arr , left , partitionIndex - 1) ;
            quickSort(arr , partitionIndex + 1 , right) ;
        }
        return arr ;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left ;
        // index记录比pivot小的数字序列的最大序号
        int index = pivot + 1 ;

        for (int i = index ; i<= right ; i++){
            if (arr[i] < arr[pivot]){
                swap(arr , i , index);
                index++ ;
            }
        }
        swap(arr , pivot , index - 1);
        return index - 1 ;
    }

    public void swap(int[] a , int i , int j){
        int tmp = a[i] ;
        a[i] = a[j] ;
        a[j] = tmp ;
    }
    public static void main(String[] args) {
        QuickSort obj = new QuickSort() ;
        int[] nums = new int[]{5,9,2,1,4,7,5,8,3,6} ;
        int[] res = obj.quickSort(nums , 0 , nums.length - 1) ;
        for (int num : res){
            System.out.print(num);
        }
    }
}
