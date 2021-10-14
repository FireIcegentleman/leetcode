package SwordOffer;

import javax.swing.text.MaskFormatter;

/**
 * 2021/10/14
 *
 * 股票的最大利润
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * */
public class _63_MaxProfit {
    // 买卖一次股票可能获得的最大收益
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE ;
        int maxProfit = 0 ;

        for (int price : prices){
            minPrice = Math.min(minPrice , price) ;
            maxProfit = Math.max(maxProfit , price - minPrice) ; // 同样则为0
        }

        return maxProfit ;
    }

    public static void main(String[] args) {
        _63_MaxProfit obj = new _63_MaxProfit() ;
        int[] prices = {7,1,5,3,6,4} ;
        System.out.println(obj.maxProfit(prices));
    }
}
