package ByteDance;

import java.util.Arrays;

/**
 * 2021/10/31
 *
 * 最长连续递增序列
 *
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，
 * 都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 * 动态规划
 * */
public class _11_FindLengthOfLCIS {
    public int res ;
    public int findLengthOfLCIS(int[] nums) {
        res = 1 ;

        int len = nums.length ;
        if (len == 1){
            return res ;
        }

        int[] dp = new int[len] ;

        // 每个位置最初的到自己的最长递增数字序列的长度均为1
        Arrays.fill(dp , 1);

        for (int i = 1 ; i < len ; i++){
            if (nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1 ;
                res = Math.max(res , dp[i]) ;
            }else{
                dp[i] = 1 ;
            }
        }

        return res ;
    }
    public static void main(String[] args) {
        _11_FindLengthOfLCIS obj = new _11_FindLengthOfLCIS() ;
        int[] nums = {1,3,5,4,2,3,4,5} ;
        System.out.print(obj.findLengthOfLCIS(nums));
    }
}
