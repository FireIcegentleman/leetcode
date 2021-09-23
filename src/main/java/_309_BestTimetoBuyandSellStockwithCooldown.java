/**
 * 2021/09/21
 *
 * 买卖股票的最佳时机 含冷冻期
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *  1. 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *  2. 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * * */
public class _309_BestTimetoBuyandSellStockwithCooldown {
    /**
     * 我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]；
     * 我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1].
     * 我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]。
     * */
    // 买卖股票的最佳时机，包含冷冻期
    public int maxProfit(int[] prices) {
        int n = prices.length ;
        if (n == 0){
            return 0 ;
        }

        int res = 0 ;
        // 前n天共收益了多少钱
        int[][] dp =  new int[n][3] ;
        dp[0][0] = -prices[0] ;
        dp[0][1] = 0 ;
        dp[0][1] = 0 ;

        for (int i = 1 ; i < n ; i++){
            // 当前持有股票时的最大收益为前一天持有股票的最大收益，或者前一天不处于冷冻期且没有股票时的最大收益-当前价格
            dp[i][0] = Math.max(dp[i - 1][0] , dp[i - 1][2] - prices[i]) ;
            // 当前不持有股票且处于冷冻期，说明前一天持有股票且卖掉
            dp[i][1] = dp[i - 1][0] + prices[i] ;
            // 当前不持有股票且不处于冷冻期，说明当天没有采取任何操作
            dp[i][2] = Math.max(dp[i - 1][1] , dp[i - 1][2]) ;
        }

        return  Math.max(dp[n - 1][1] , dp[n - 1][2]);
    }
    public static void main(String[] args) {
        _309_BestTimetoBuyandSellStockwithCooldown obj = new _309_BestTimetoBuyandSellStockwithCooldown() ;
        int[] prices = {1,2,3,0,2} ;
        System.out.println(obj.maxProfit(prices));
    }
}
