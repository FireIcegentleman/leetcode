package All;
/**
 * 2021/10/26
 *
 * 搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * */

/**
 * 要求时间复杂度为O(log n)，显然是二分搜索
 * */
public class _33_Search {
    public int search_direction(int[] nums, int target) {
        int res = -1 ;

        boolean direction = target >= nums[0];

        if (direction){// 正向找
            for (int i = 0 ; i < nums.length ; i++){
                if (nums[i] == target){
                    return i ;
                }
            }
        }else{// 反向找
            for (int i = nums.length - 1 ; i >= 0 ; i--){
                if (nums[i] == target){
                    return i ;
                }
            }
        }
        return res ;
    }
    // 二分法的进阶设计，k预先是不知道的
    // 先找到旋转的位置索引，然后分左右寻找
    // 这个索引之前的升序，之后的在小于nums[0]之后的递增
    public int search(int[] nums, int target) {
        int len = nums.length ;
        if (len == 0){
            return -1 ;
        }

        if (len == 1){
            return nums[0] == target ? 0 : -1 ;
        }

        int left = 0 , right = len - 1 ;

        while (left <= right){
            int mid = (left + right) / 2 ;
            if (nums[mid] == target){
                return mid ;
            }
            if(nums[0] <= nums[mid]){// 肯定有一半是有序的，通过比较两个端点大小找到有序的部分
                // 左半边有序
                // 因为只旋转了一次，则下面的判据一定能得到是完全排序
                if (nums[0] <= target && target < nums[mid]){
                    right = mid - 1 ;
                }else{// 否则有伴扁你有序
                    left = mid + 1 ;
                }
            }else{
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1 ;
                }else{
                    right = mid - 1 ;
                }
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        _33_Search obj = new _33_Search() ;
        int[] nums = {4,5,6,7,0,1,2} ;
        int target = 0 ;
        System.out.println(obj.search(nums , target));
    }
}
