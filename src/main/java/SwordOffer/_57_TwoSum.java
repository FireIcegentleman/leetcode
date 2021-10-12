package SwordOffer;

import java.util.Arrays;

/**
 * 2021/10/09
 *
 * 和为S的两个数字
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * */
public class _57_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int left = 0 , right = nums.length - 1 ;

        int res = 0 ;
        while (left < right){
            res = nums[left] + nums[right] ;
            if (res == target){
                return  new int[]{nums[left] , nums[right]} ;
            }else if(res < target){
                left ++ ;
            }else{
                right -- ;
            }
        }
        return new int[]{nums[left] , nums[right]} ;
    }
    public static void main(String[] args) {
        _57_TwoSum obj = new _57_TwoSum() ;
        int[] nums = {10,26,30,31,47,60} ;
        int target = 40 ;
        System.out.print(Arrays.toString(obj.twoSum(nums , target)));
    }
}
