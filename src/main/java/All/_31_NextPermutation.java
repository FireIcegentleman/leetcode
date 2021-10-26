package All;


import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Arrays;

/**
 * 2021/10/25
 *
 * 下一个排列
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * */
public class _31_NextPermutation {
    // 获取下一个排列的函数，如果不存在下一个更大的排列，则将数字重新排列成最小的序列
    // 要求必须原地修改，且只允许使用额外常数空间

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int tmp = nums[start] ;
            nums[start] = nums[end] ;
            nums[end] = tmp ;
            start++ ;
            end-- ;
        }
    }

    private void swap(int[] nums, int i, int k) {
        int tmp = nums[i] ;
        nums[i] = nums[k] ;
        nums[k] = tmp ;
    }
    /**
     * 算法：
     *      1. 从后往前，找到第一组相邻数对存在，num[i-1] < num[i]，记录下此时的i-1
     *      2. 从后往前，找到第一个大于nums[i-1]的数字nums[k]，swap(nums[i - 1] , nums[k])
     *      3. 将i-1之后的序列倒转，变为升序序列
     * */
    public void nextPermutation(int[] nums) {
        int len = nums.length  ;

        int i = len - 1 ;
        while (i > 0 && nums[i - 1] >= nums[i]){
            i-- ;
        }

        // 数组中的元素按照降序排列，直接倒转
        if (i == 0){
            reverse(nums , 0 , len - 1) ;
            return;
        }

        // 如果不按照倒序排列，找到这个升序数对，那么将这个nums[i - 1]和后半部分降序序列中最小的数字交换
        for (int k = len - 1 ; k >= 0 ; k--){
            if (nums[i - 1] < nums[k]){
                swap(nums , i - 1 , k) ;
                break;
            }
        }
        reverse(nums , i , len - 1);
    }



    public static void main(String[] args) {
        _31_NextPermutation obj = new _31_NextPermutation() ;
        int[] nums = {} ;
        obj.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
