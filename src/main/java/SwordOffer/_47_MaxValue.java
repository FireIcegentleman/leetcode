package SwordOffer;

/**
 * 2021/10/10
 *
 * 礼物的最大价值
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * */
public class _47_MaxValue {
    // 本质是从左上角到右下角找到权值最大的路径
    // 动态规划，dp[i][j]表示记录到（i,j）位置的礼物最大价值
    public int maxValue_dp(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;

        int[][] dp = new int[m][n] ;
        dp[0][0] = grid[0][0] ;
        int sum = 0 ;
        for (int i = 0 ; i < m ; i++){
            dp[i][0] = sum + grid[i][0] ;
            sum += grid[i][0] ;
        }
        sum = 0 ;
        for (int i = 0 ; i < n ; i++){
            dp[0][i] = sum + grid[0][i] ;
            sum += grid[0][i] ;
        }

        for (int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n ; j++){
                dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]) + grid[i][j] ;
            }
        }
        return dp[m - 1][n - 1] ;
    }

    // 一维数组优化
    public int maxValue(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;

        // 前面的是这行，后面的是上一行
        int[] maxValue = new int[n] ;

        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                int left = 0 ;
                int up = 0 ;

                if (i > 0){// 由左值的条件
                    left = maxValue[j] ;
                }

                if (j > 0){// 有上值的条件
                    up = maxValue[j - 1] ;
                }

                maxValue[j] = Math.max(left , up) + grid[i][j] ;
            }
        }

        return maxValue[n - 1] ;
    }

    public static void main(String[] args) {
        _47_MaxValue obj = new _47_MaxValue() ;
        int[][] grid = {{1 , 3 , 1} ,
                        {1 , 5 , 1} ,
                        {4 , 2 , 1}} ;
        System.out.print(obj.maxValue(grid));
    }
}
