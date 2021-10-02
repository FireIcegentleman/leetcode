package SwordOffer;

import java.util.Arrays;

/**
 * 2021/10/02
 *
 * 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * */
public class _21_AdjustArray {
    // 使奇数位于偶数前面
    // 双指针
    public int[] exchange(int[] nums) {
        int odd_index = 0 ;
        int even_index = nums.length - 1 ;
        while (odd_index < even_index){
            while (odd_index < even_index && nums[odd_index] % 2 == 1){
                odd_index++ ;
            }

            while (odd_index < even_index && nums[even_index] % 2 == 0){
                even_index-- ;
            }

            swap(nums , odd_index , even_index);
        }
        return nums ;
    }

    private void swap(int[] nums, int odd_index, int even_index) {
        int tmp = nums[odd_index] ;
        nums[odd_index] = nums[even_index] ;
        nums[even_index] = tmp ;
    }

    public static void main(String[] args) {
        _21_AdjustArray obj = new _21_AdjustArray() ;
        int[] nums = {1,2,3,4} ;
        System.out.println(Arrays.toString(obj.exchange(nums)));
    }
}
