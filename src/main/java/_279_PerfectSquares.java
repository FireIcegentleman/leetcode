/**
 * 2021/09/18
 * 完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，
 * 而 3 和 11 不是。
 *
 * 硬币问题 , 动态规划
 * */
public class _279_PerfectSquares {
    public int[] square = new int[100] ;

    public int numSquares(int n) {
        int[] dp = new int[n + 1] ;
        for (int i = 1 ; i <= n ; i++){
            dp[i] = i ;
            for (int j = 1 ; i - j * j >= 0 ; j++){
                dp[i] = Math.min(dp[i] , dp[i - j * j] + 1) ;
            }
        }
        return dp[n] ;
    }

    public static void main(String[] args) {
        _279_PerfectSquares obj = new _279_PerfectSquares() ;
        int n = 12 ;
        System.out.print(obj.numSquares(n));
    }
}
