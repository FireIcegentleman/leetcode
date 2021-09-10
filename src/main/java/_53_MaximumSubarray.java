import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.lang.Math.max;

/**
 * 2021/09/08
 * 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 原则上只要头尾都不可能是负数，所以就是记录从每一个正数开始，到当前数的下一个数是负数为止的每一个子序列的和
 * 然后取最大值
 * */
public class _53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0 ;
        }
        // dp使用动态规划的算法，每个位置的数字表示从开头到这里的最大连续子数组的和
        int[] dp = new int[nums.length] ;
        dp[0] = nums[0] ;
        for(int i = 1 ; i < nums.length ; i++){
            /*if(nums[i] <= 0){
                dp[i] = dp[i - 1] + nums[i];
            }else{*/
                dp[i] = Math.max(dp[i - 1] + nums[i] , nums[i]) ;
            //}
        }

        Arrays.sort(dp);
        return  dp[nums.length - 1];
    }

    public static void main(String[] args) {
        _53_MaximumSubarray obj = new _53_MaximumSubarray() ;
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4} ;
        System.out.println(obj.maxSubArray(nums));
    }
}
/**
 * 第一次提交 186/203
 * 卡在[-2,-1]
 *
 * */
