package SwordOffer;


import java.util.HashSet;

/**
 * 2021/10/11
 *
 * 丑数
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 两种方法：
 *      1. 分析每个数
 *      2. 以空间换取时间
 * */
public class _49_UglyNumber {
    // 只包含质因子 2、3 和 5 的数字，返回第n个数字
    public int nthUglyNumber_force(int n) {
        if (n <= 0){
            return 0 ;
        }

        int number = 1 ; // 当前分析的数字
        int uglyNumber = 1 ; // 当前已经得到的丑数个数

        while (uglyNumber < n){
            number++ ;
            if (isUgly(number)){
                uglyNumber++ ;
            }
        }

        return number ;
    }

    private boolean isUgly(int number) {
        while (number % 5 == 0){
            number /= 5;
        }

        while (number % 3 == 0){
            number /= 3;
        }

        while (number % 2 == 0){
            number /= 2;
        }

        return number == 1 ? true : false ;
    }

    // 以空间换取时间
    // 丑数的递推性质： 丑数只包含因子 2, 3, 5,因此有 “丑数 == 某较小丑数 × 某因子” （例如：10 = 5 × 2）。
    public int nthUglyNumber(int n) {
        if (n <= 0){
            return 0 ;
        }

        int p2 = 0 , p3 = 0 , p5 = 0 ;
        int[] dp = new int[n] ;
        dp[0] = 1 ;

        for (int i = 1 ; i < n ; i++){
            int min = Math.min(Math.min(dp[p2] * 2 , dp[p3] * 3) , dp[p5] * 5) ;
            dp[i] = min ;

            if (dp[i] == dp[p2] * 2){
                p2++ ;
            }

            if (dp[i] == dp[p3] * 3){
                p3++ ;
            }

            if (dp[i] == dp[p5] * 5){
                p5++ ;
            }
        }
        return dp[n - 1] ;
    }

    public static void main(String[] args) {
        _49_UglyNumber obj = new _49_UglyNumber() ;
        int n = 10 ;
        System.out.print(obj.nthUglyNumber(n));
    }
}
