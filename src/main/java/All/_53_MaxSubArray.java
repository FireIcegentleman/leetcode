package All;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/**
 * 2021/11/15
 *
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * */
public class _53_MaxSubArray {
    // 动态规划
    public int maxSubArray_dp(int[] nums) {
        int[] dp = new int[nums.length] ;
        if (nums.length == 1){
            return nums[0] ;
        }
        dp[0] = nums[0] ;
        int res = dp[0] ;

        for (int i = 1 ; i < nums.length ; i++){
            dp[i] = Math.max(nums[i] , dp[i] + nums[i]) ;
            res = Math.max(res , dp[i]) ;
        }
        return res ;
    }
    private int maxSubArray(int[] nums) {
        int res = nums[0] ;
        int sum = 0 ;
        for (int num : nums){
            if (sum > 0){
                sum += num ;
            }else{
                sum = num ;
            }
            res = Math.max(res , sum) ;
        }
        return res ;
    }

    public static void main(String[] args) {
        _53_MaxSubArray obj = new _53_MaxSubArray() ;
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4} ;
        System.out.println(obj.maxSubArray(nums));
    }
}
