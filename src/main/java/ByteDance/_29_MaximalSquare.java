package ByteDance;
/**
 * 2021/11/7
 *
 * 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * */
public class _29_MaximalSquare {
    public int res ;
    public int maximalSquare(char[][] matrix) {
        res = 0 ;
        int m = matrix.length ;
        int n = matrix[0].length ;

        // dp[i][j]记录以(i,j)为右下角时的最大正方形面积
        int[][] dp = new int[m][n] ;

        for (int i = 0 ; i < m ; i++){
            if (matrix[i][0] == '1'){
                dp[i][0] = 1 ;
            }
        }

        for (int j = 0 ; j < n ; j++){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1 ;
            }
        }

        for (int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n ; j++){
                if (matrix[i][j] == '0'){
                    dp[i][j] = 0 ;
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] , Math.min(dp[i - 1][j] , dp[i][j - 1])) + 1 ;
                }
            }
        }

        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                res = Math.max(res , dp[i][j]) ;
            }
        }
        return res*res ;
    }
    public static void main(String[] args) {
        _29_MaximalSquare obj = new _29_MaximalSquare() ;
        //char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}} ;
        char[][] matrix = {{'1','1'},{'1','1'}} ;

        System.out.println(obj.maximalSquare(matrix));
    }
}
