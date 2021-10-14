package SwordOffer;

import java.util.Arrays;

/**
 * 2021/10/12
 *
 * n个骰子的点数
 *
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 收藏，动态规划
 * */
public class _60_DicesProbability {
    // 动态规划，并在空间上进行
    public double[] dicesProbability(int n) {
        // res的结果数目有5*n+1个
        double[] dp = new double[6] ;
        Arrays.fill(dp , 1 / 6.0);

        for (int i = 2 ; i <= n ; i++){
            double[] tmp = new double[5 * i + 1] ;
            // 计算每一个位置的贡献度
            for (int j = 0 ; j < dp.length ; j++){
                for (int k = 0 ; k < 6 ; k++){
                    tmp[j + k] += dp[j] / 6.0 ;
                }
            }
            dp = tmp ;
        }

        return dp ;
    }
    public static void main(String[] args) {
        _60_DicesProbability obj = new _60_DicesProbability() ;
        int n = 2 ;
        System.out.print(Arrays.toString(obj.dicesProbability(n)));
    }
}
