/**
 * 2021/09/17
 * 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * */
public class _216_MaximalSquare {
    // 动态规划
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length ;
        int n = matrix[0].length ;
        // dp[i][j]表示以i,j为右下角顶点的最大正方形边长
        int[][] dp = new int[m][n] ;

        for (int i = 0 ; i < m ; i++){
            if (matrix[i][0] == '1'){
                dp[i][0] = 1 ;
            }
        }
        for (int j = 0 ; j < n ; j++){
            if (matrix[0][j] == '1'){
                dp[0][j] = 1 ;
            }
        }

        for (int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n ; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i - 1][j - 1] , Math.min(dp[i - 1][j] , dp[i][j - 1])) + 1 ;
                }else{
                    dp[i][j] = 0 ;
                }
            }
        }

        int max = Integer.MIN_VALUE ;
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0 ; j < n ; j++){
                max = Math.max(max , dp[i][j]) ;
            }
        }
        return max * max;
    }
    public static void main(String[] args) {
        _216_MaximalSquare obj = new _216_MaximalSquare() ;
        /*char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}} ;*/
        char[][] matrix = {{'0','1'}} ;
        System.out.print(obj.maximalSquare(matrix));
    }
}
