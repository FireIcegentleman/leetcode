package SwordOffer;

import java.util.Arrays;

/**
 * 2021/10/05
 *
 * 连续子数组的最大和
 * */
public class _42_MaxSubArray {
    // 动态规划,dp[i]记录到当前位置的最大连续子数组
    public int maxSubArray_dp(int[] nums) {
        int len = nums.length ;
        int[] dp = new int[len] ;
        dp[0] = nums[0] ;

        for (int i = 1 ; i < len ; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i] , nums[i]) ;
        }
        Arrays.sort(dp);
        return dp[len - 1] ;
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0] ;
        for (int i = 1 ; i < nums.length ; i++){
            nums[i] += Math.max(nums[i - 1] , 0) ;
            res = Math.max(res , nums[i]) ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _42_MaxSubArray obj = new _42_MaxSubArray() ;
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4} ;
        System.out.println(obj.maxSubArray(nums));
    }
}
