/**
 * 2021/09/25
 * 目标和
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * */

public class _494_TargetSum {
    public static int res ;
    //递归
    public int findTargetSumWays_(int[] nums, int target) {
        res = 0 ;
        dfs(nums , 0 , 0 , target) ;
        return res ;
    }

    private void dfs(int[] nums, int index, int now, int target) {
        if (index == nums.length){
            if (now == target){
                res++ ;
            }
            return;
        }

        now += nums[index] ;
        dfs(nums , index + 1 , now , target);

        now -= 2 * nums[index] ;
        dfs(nums , index + 1 , now , target);
    }

    // 动态规划的解法
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    public static void main(String[] args) {
        _494_TargetSum obj = new _494_TargetSum() ;
        int[] nums = {1} ;
        int target = 1 ;
        System.out.println(obj.findTargetSumWays(nums , target));
    }
}
