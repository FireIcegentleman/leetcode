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
        return left ;
    }
    public static void main(String[] args) {
        _35_SearchInsert obj = new _35_SearchInsert() ;
        int[] nums = {1,3,5,6} ;
        int target = 7 ;
        System.out.println(obj.searchInsert(nums , target));
    }
}
