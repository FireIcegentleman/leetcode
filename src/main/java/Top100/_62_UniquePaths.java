/**
 * 2021/09/09
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 深度优先遍历到（m,n）
 * */
public class _62_UniquePaths {
    public int res = 0 ;
    public void dfs(int m , int n , int i ,int j){
        if(i == (m - 1) && j == (n - 1)){
            res ++ ;
            return ;
        }
        if(i < (m - 1) && j < (n - 1)){
            dfs(m , n , i + 1 , j) ;
            dfs(m , n  , i , j + 1) ;
        }else if(i < (m - 1) && j == (n - 1)){
            dfs(m , n  , i + 1, j) ;
        }else if(i == (m - 1) && j < (n - 1)){
            dfs(m , n , i , j + 1) ;
        }
    }
    public int uniquePaths_dfs(int m, int n) {
        dfs(m , n , 0 , 0) ;
        return res ;
    }
    // 采用简单动态规划的做法，每一格有两种走法，总路径数为上+左的路径和
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = 1 ;
            }
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] ;
            }
        }
        return dp[m - 1][n - 1] ;


    }
    public static void main(String[] args) {
        _62_UniquePaths obj = new _62_UniquePaths() ;
        int m = 7, n = 3 ;
        System.out.println(obj.uniquePaths(m,n));
    }
}

/**
 * 简单的DFS，41/61
 * 超时
 * */
