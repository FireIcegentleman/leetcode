import javax.swing.text.MaskFormatter;
import java.util.Map;

/**
 * 2021/09/13
 * 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * */
public class _121_BestTimetoBuyandSellStock {
    // 198/211 内存炸了
    public int maxProfit_map(int[] prices) {
        int n = prices.length ;
        int[][] map = new int[n][n] ;

        for (int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                map[i][j] = prices[j] - prices[i] ;
            }
        }
        int res = 0 ;
        for (int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                res = Math.max(res , map[i][j]) ;
            }
        }
        return res ;
    }
    // 200/211 时间炸了
    public int maxProfit_time(int[] prices) {
        int n = prices.length ;
        int res = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(prices[j] > prices[i]){
                    res = Math.max(res , prices[j] - prices[i]) ;
                }
            }
        }
        return res ;
    }
    // 通过语句顺序保证后面减前面
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE ;
        int maxPro = 0 ;

        for(int i = 0 ; i < prices.length ; i++){
            minprice = Math.min(minprice , prices[i]) ;
            maxPro = Math.max(maxPro , prices[i] - minprice) ;
        }
        return maxPro ;
    }
    public static void main(String[] args) {
        _121_BestTimetoBuyandSellStock obj = new _121_BestTimetoBuyandSellStock() ;
        int[] prices = {7,1,5,3,6,4} ;
        System.out.print(obj.maxProfit(prices));
    }
}
