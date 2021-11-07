package ByteDance;
/**
 * 2021/11/5
 *
 * 买卖股票的最佳时机II
 *
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * */
public class _28_MaxProfit {
    // 尽可能多的交易，且没有冷冻期
    // 动态规划，dp[i][j]表示到下标为i的这一天，持股状态为J时，我们手上拥有的最大利润
    // 第二维j对应的数字为0说明那一天是持有现金，为1说明是持有股票
    public int maxProfit(int[] prices) {
        int len = prices.length ;
        int[][] dp = new int[len][2] ;

        if (len <= 1){
            return 0 ;
        }
        // 对应股票价格的第1天如果没有买，持有金钱
        dp[0][0] = 0 ;
        // 对应股票价格的第1天如果有买了，持有股票
        dp[0][1] = -prices[0] ;

        for (int i = 1 ; i < len ; i++){
            // 第i天持有现金，没有股票，手中的最大利润等于前一天的没有股票 max 今天把股票卖掉（前一天有股票时对应的利润加上这天的卖掉时的股票价格）
            dp[i][0] = Math.max(dp[i - 1][0] , dp[i - 1][1] + prices[i]);
            // 第i天持有股票，手中的最大现金数等于前一天持有股票的利润 max 前一天持有的金钱数减去当天的买股票的金额
            dp[i][1] = Math.max(dp[i - 1][1] , dp[i - 1][0] - prices[i]);
        }

        // 最后一天持有
        return dp[len - 1][0] ;
    }
    public static void main(String[] args) {
        _28_MaxProfit obj = new _28_MaxProfit() ;
        int[] prices = {7,1,5,3,6,4} ;
        System.out.println(obj.maxProfit(prices));
    }
}
