package SwordOffer;

import java.util.Arrays;

/**
 * 2021/10/11
 *
 * n个骰子的点数
 *
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * */
public class _60_DicesProbability {
    public double[] dicesProbability(int n) {
        return new double[0] ;
    }
    public static void main(String[] args) {
        _60_DicesProbability obj = new _60_DicesProbability() ;
        int n = 2 ;
        System.out.print(Arrays.toString(obj.dicesProbability(n)));
    }
}
