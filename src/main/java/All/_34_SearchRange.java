package All;
/**
 * 2021/10/26
 *
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * */

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.sql.Struct;
import java.util.Arrays;

/**
 * O(log n)，二分搜索
 * */
public class _34_SearchRange {
    // 二分搜索，找到位置后向外扩展
    public int[] searchRange_range(int[] nums, int target) {
        int len = nums.length ;
        if (len == 0){
            return new int[]{-1 , -1} ;
        }

        int left = 0 , right = len - 1 , mid = 0 ;
        while (left <= right){
            mid = (left + right) / 2 ;
            if (nums[mid] < target){
                left = mid + 1 ;
            }else if(nums[mid] > target){
                right = mid - 1 ;
            }else{
                break;
            }
        }

        if (left > right){
            return new int[]{-1 , -1} ;
        }

        int leftIndex = mid , rightIndex = mid ;
        while (leftIndex >= 1 && nums[leftIndex] == nums[leftIndex - 1]){
            leftIndex-- ;
        }
        while (rightIndex < len - 1 && nums[rightIndex] == nums[rightIndex + 1]){
            rightIndex++ ;
        }

        return new int[]{leftIndex , rightIndex} ;
    }

    /**
     * 考虑 target 开始和结束位置，其实我们要找的就是数组中「第一个等于target 的位置」（记为 leftIdx）和
     * 「第一个大于target 的位置减一」（记为 rightIdx）。
     *
     * 二分查找中，寻找 leftIdx 即为在数组中寻找第一个大于等于 target 的下标，
     * 寻找 rightIdx 即为在数组中寻找第一个大于target 的下标
     *
     * */
    // 用标识符来表示是否等于
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = BinarySearch(nums , target , true) ;
        int rightIndex = BinarySearch(nums , target , false) - 1 ;

        if (leftIndex <= rightIndex && rightIndex <= nums.length && nums[leftIndex] == target && nums[rightIndex] == target){
            return new int[]{leftIndex , rightIndex} ;
        }
        return new int[]{-1 , -1} ;
    }

    private int BinarySearch(int[] nums, int target, boolean lower) {
        int len = nums.length ;

        int left = 0 , right = len - 1 , res = nums.length;
        while (left <= right){
            int mid = (left + right) / 2 ;
            if (nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid - 1 ;
                res = mid ;
            }else{
                left = mid + 1 ;
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        _34_SearchRange obj = new _34_SearchRange() ;
        int[] nums = {1} ;
        int target = 1 ;
        System.out.println(Arrays.toString(obj.searchRange(nums , target)));
    }
}
