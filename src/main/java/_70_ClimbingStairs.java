/**
 * 2021/09/09
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * */
public class _70_ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1){
            return 1 ;
        }
        // 动态规划数组中的每个数代表到目前台阶为止有几种走法
        int[] dp = new int[n] ;
        dp[0] = 1 ;
        dp[1] = 2 ;
        for (int i = 2 ; i < n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2] ;
        }
        return dp[n - 1] ;
    }
    public static void main(String[] args) {
        _70_ClimbingStairs obj = new _70_ClimbingStairs() ;
        int n = 1 ;
        System.out.println(obj.climbStairs(n));
    }
}
