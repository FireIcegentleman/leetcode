package All;

/**
 * 2021/10/26
 *
 *  搜索插入位置
 *
 *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *  请必须使用时间复杂度为 O(log n) 的算法。
 *
 * */
public class _35_SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length ;
        int left = 0 , right = len - 1 ;

        while (left <= right){
            int mid = (left + right) >> 1 ;
            if (nums[mid] == target){
                return mid ;
            }else if(nums[mid] > target){
                right = mid - 1 ;
            }else{
                left = mid + 1 ;
            }
        }
        /**
         * 以上while循环中，若找到了target直接返回
         * 当原数组不包含target时，考虑while循环最后一次执行的总是 left=right=mid,
         * 此时nums[mid] 左边的数全部小于target，nums[mid]右边的数全部大于target,
         * 则此时我们要返回的插入位置分为两种情况：
         * ①就是这个位置，即nums[mid]>target时，此时执行了right=mid-1，返回left正确
         * ②是该位置的右边一个，即nums[mid]<target时，此时执行了left=mid+1,返回left也正确
         * */
        return left ;
    }
    public static void main(String[] args) {
        _35_SearchInsert obj = new _35_SearchInsert() ;
        int[] nums = {1,3,5,6} ;
        int target = 7 ;
        System.out.println(obj.searchInsert(nums , target));
    }
}
