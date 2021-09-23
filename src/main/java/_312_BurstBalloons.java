/**
 * 2021/09/21
 * 中秋快乐！
 *
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 * */

public class _312_BurstBalloons {
    // 每戳破一个气球，当前气球序列发生一次变化
    public int maxCoins(int[] nums) {
        int n = nums.length ;
        int[] temp = new int[n + 2] ;
        temp[0] = 1 ;
        temp[n + 1] = 1 ;
        for (int i = 1 ; i <= n ; i++){
            temp[i] = nums[i - 1] ;
        }


        int[][] dp = new int[n + 2][n + 2] ;
        // 这个开区间的长度
        for (int len = 3 ; len <= n + 2 ; len++){
            // 开区间左端点的取值
            for (int i = 0 ; i <= n + 2 - len ; i++){
                int res = 0 ;
                // k为开区间内的索引
                for (int k = i + 1 ; k < i + len - 1 ; k++){
                    int left = dp[i][k] ;
                    int right = dp[k][i + len - 1] ;
                    res = Math.max(res , left + temp[i] * temp[k] * temp[i + len - 1] + right) ;
                }
                dp[i][i + len - 1] = res ;
            }
        }
        return dp[0][n + 1] ;
    }

    public static void main(String[] args) {
        _312_BurstBalloons obj = new _312_BurstBalloons() ;
        int[] nums = {3,1,5,8} ;
        System.out.println(obj.maxCoins(nums));
    }
}
