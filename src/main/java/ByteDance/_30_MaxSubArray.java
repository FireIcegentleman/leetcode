package ByteDance;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 2021/11/7
 *
 * 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * */
public class _30_MaxSubArray {
    // 求出最大子序和
    // 动态规划
    public int maxSubArray(int[] nums) {
        int len = nums.length ;
        if (len == 0){
            return 0 ;
        }
        // dp[i]表示以i结尾的最大子序和
        int[] dp = new int[len] ;
        // 对于初始化状态而言，第一个数可选可不选
        int res = nums[0] ;
        dp[0] = nums[0] ;
        for (int i = 1 ; i < len ; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i] , nums[i]) ;
            res = Math.max(res , dp[i]) ;
        }

        return res ;
    }

    public static void main(String[] args) {
        _30_MaxSubArray obj= new _30_MaxSubArray() ;
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4} ;
        System.out.println(obj.maxSubArray(nums));
    }
}
