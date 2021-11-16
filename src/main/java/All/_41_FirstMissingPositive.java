package All;

import java.util.HashSet;
import java.util.Set;

/**
 * 2021/11/12
 *
 * 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。 
 *
 * */
public class _41_FirstMissingPositive {
    // 找出没有出现的最小正整数
    public int firstMissingPositive(int[] nums) {
        int len = nums.length ;

        for (int i = 0 ; i < len ; i++){
            // 满足在指定的范围内，并且没有防止在正确的位置上时才交换
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                swap(nums , nums[i] - 1 , i) ;
            }
        }

        for (int i = 0 ; i < len ; i++){
            if (nums[i] != i + 1){
                return i + 1 ;
            }
        }
        return len + 1 ;
    }

    public void swap(int[] nums , int a , int b){
        int tmp = nums[a] ;
        nums[a] = nums[b] ;
        nums[b] = tmp ;
    }
    public static void main(String[] args) {
        _41_FirstMissingPositive obj = new _41_FirstMissingPositive() ;
        int[] nums = {3,4,-1,1} ;
        System.out.println(obj.firstMissingPositive(nums));

    }
}
