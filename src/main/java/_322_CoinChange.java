import java.util.Arrays;

/**
 * 2021/09/22
 * 零钱兑换
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 腾讯二面
 * */
public class _322_CoinChange {
    // 计算并返回可以凑成总金额所需要的最少硬币个数
    // 从最接近且小于当前总数的硬币开始取，尽可能取大的，当小于当前大的的时候再取次大的
    // 仅考虑最大的是否能满足，小的组合没有考虑
    public int coinChange_greedy(int[] coins, int amount) {
        Arrays.sort(coins);

        if (amount == 0){
            return 0 ;
        }
        if (amount < coins[0]){
            return -1 ;
        }

        int n = coins.length ;
        int res = 0 ;
        int index = 0 ;

        while(amount > 0){
            // 当前最接近且小于amount的硬币面额
            index = find(coins , amount) ;
            amount -= coins[index] ;
            res++ ;
        }
        if (amount == 0){
            return res ;
        }else{
            return -1 ;
        }
    }

    private int find(int[] coins, int amount) {
        // 比当前最大的硬币面额都大
        if (coins[coins.length - 1] <= amount){
            return coins.length - 1 ;
        }
        for (int i = coins.length - 2 ; i >= 0 ; i--){
            if (amount >= coins[i] && amount < coins[i + 1]){
                return i ;
            }
        }
        return 0 ;
    }

    // 递归 + 记忆化搜索
    public int coinChange(int[] coins, int amount) {
        if (amount < 1){
            return 0 ;
        }
        return coinChange(coins , amount , new int[amount]) ;
    }
    // 计算出结果后保存到count数组中
    public int coinChange(int[] coins, int rem , int[] count){
        if (rem < 0){
            return  -1 ;
        }

        if (rem == 0){
            return 0 ;
        }

        if (count[rem - 1] != 0){
            return count[rem - 1] ;
        }

        int min = Integer.MAX_VALUE ;
        for (int coin : coins){
            int res = coinChange(coins , rem - coin , count) ;
            if (res >= 0 && res < min){
                min = 1 + res ;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min ;
        return count[rem - 1] ;
    }

    public int coinChange_dp(int[] coins, int amount) {
        int max = amount + 1 ;
        int[] dp = new int[max] ;
        Arrays.fill(dp , max);

        dp[0] = 0 ;

        for (int i = 1 ; i <= amount ; i++){
            for (int j = 0 ; j < coins.length ; j++){
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i] , dp[i - coins[j]] + 1) ;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount] ;
    }
    public static void main(String[] args) {
        _322_CoinChange obj = new _322_CoinChange() ;
        int[] coins = {1,2,5} ;
        int amount = 11 ;
        System.out.println(obj.coinChange_dp(coins , amount));
    }
}
