package SwordOffer;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 2021/10/11
 *
 * 0~n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * */
public class _53_MissingNumber {
    public int missingNumber_force(int[] nums) {
        int len = nums.length ;
        if (nums[0] != 0){
            return 0 ;
        }
        for (int i = 0 ; i < len - 1 ; i++){
            if (nums[i] != nums[i + 1] - 1){
                return nums[i] + 1 ;
            }
        }

        return len ;
    }

    // 排序数组中的搜索问题，首先想到二分法来解决
    // 之前nums[i] = i
    // 之后nums[i] != i
    // 二分法查找右子数组的首位元素
    public int missingNumber(int[] nums) {
        int len = nums.length ;
        int left = 0 , right = len - 1 ;

        int mid = 0 ;
        while (left <= right){
            mid = (left + right) / 2 ;
            if (nums[mid] == mid){
                left = mid + 1 ;
            }else{
                right = mid - 1 ;
            }
        }
        return left ;
    }
    public static void main(String[] args) {
        _53_MissingNumber obj = new _53_MissingNumber() ;
        int[] nums = {0} ;
        System.out.print(obj.missingNumber(nums));
    }
}
