package SwordOffer;

import java.util.HashMap;

/**
 * 2021/09/28
 *
 * 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * */
public class _10_Fibonacci {
    public int fib_force(int n) {
        if (n == 0){
            return 0 ;
        }else if (n == 1){
            return 1 ;
        }else{
            return fib_force(n - 1) + fib_force(n - 2) ;
        }
    }

    // 动态规划
    public int fib(int n){
        int[] dp =  new int[n + 1] ;

        if (n == 0){
            return 0 ;
        }
        if (n == 1){
            return 1 ;
        }
        dp[0] = 0 ;
        dp[1] = 1 ;


        for (int i = 2 ; i <= n ; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007 ;
        }
        return dp[n] ;
    }


    public static void main(String[] args) {
        _10_Fibonacci obj = new _10_Fibonacci() ;
        int n = 5 ;
        System.out.println(obj.fib(48));
    }

}
