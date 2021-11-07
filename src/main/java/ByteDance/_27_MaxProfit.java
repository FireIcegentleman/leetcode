package ByteDance;

/**
 * 2021/11/5
 *
 * 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * */
public class _27_MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0 ;
        int minPrice = prices[0] ;
        int len = prices.length ;

        for (int i = 0 ; i < len ; i++){
            minPrice = Math.min(minPrice , prices[i]) ;
            maxProfit = Math.max(maxProfit , prices[i] - minPrice) ;
        }
        return maxProfit ;
    }
    public static void main(String[] args) {
        _27_MaxProfit obj = new _27_MaxProfit() ;
        int[] prices = {7,1,5,3,6,4} ;
        System.out.println(obj.maxProfit(prices));
    }
}
