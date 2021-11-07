package ByteDance;
/**
 * 2021/10/30
 *
 * 搜算旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * */
public class _10_Search {
    // 搜索旋转排序数组
    // 二分，一定有一半是有序的
    public int search(int[] nums, int target) {
        int len = nums.length ;

        int left = 0 ;
        int right = len - 1 ;

        while (left <= right){
            int mid = (left + right) >> 1 ;
            // 左半边有序
            if (nums[mid] == target){
                return mid ;
            }

            if (nums[0] <= nums[mid]){
                // 注意target可以等于这个边界，等于也要放在有序的这边继续判断
                if (nums[0] <= target && target < nums[mid]){
                    right = mid - 1 ;
                }else {
                    left = mid + 1 ;
                }
            }else{// 右半边有序
                if (nums[mid] < target && target <= nums[len - 1]){
                    left = mid + 1 ;
                }else{
                    right = mid - 1 ;
                }
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        _10_Search obj = new _10_Search() ;
        int[] nums = {1,3,5} ;
        int target = 3 ;
        System.out.print(obj.search(nums , target));
    }
}
