import java.util.Arrays;

/**
 * 2021/09/21
 *
 * 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 找到最长严格递增子序列的长度
 * * */
public class _300_LongestIncreasingSubsequence {
    // 返回严格递增子序列的长度
    public int lengthOfLIS_dp(int[] nums) {
        int res = 0 ;
        int n = nums.length ;
        if (n == 0){
            return res ;
        }

        // dp的每一个值代表到目前位置的最大子序列长度
        int[] dp = new int[n] ;
        // 方程初始化
        Arrays.fill(dp , 1);

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < i ; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1) ;
                }
            }
            res = Math.max(dp[i] , res) ;
        }
        return res ;
    }
    // 返回严格递增子序列的长度，+ 二分法
    public int lengthOfLIS(int[] nums) {
        int res = 0 ;
        int n = nums.length ;
        if (n == 0){
            return res ;
        }

        // 当前长度为i + 1的尾部元素的值
        // 如果tails中的元素都比Num小，则将其插入到最后
        // 否则，用它覆盖掉比它大的元素中最小的那个
        int[] tails = new int[n] ;
        for (int num : nums){
            int i = 0 , j = res ;
            while(i < j){
                int m = (i + j) / 2;
                if (tails[m] < num){
                    i = m + 1 ;
                }else{
                    j = m ;
                }
            }
            tails[i] = num ;
            if (res == j){
                res++ ;
            }
        }

        return res ;
    }
    public static void main(String[] args) {
        _300_LongestIncreasingSubsequence obj = new _300_LongestIncreasingSubsequence() ;
        int[] nums = {10,9,2,5,3,7,101,18} ;
        System.out.print(obj.lengthOfLIS(nums));
    }
}
