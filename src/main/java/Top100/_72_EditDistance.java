/**
 * 2021/09/09
 * 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 *  1.插入一个字符
 *  2.删除一个字符
 *  3.替换一个字符
 *
 *  https://zhuanlan.zhihu.com/p/91667128
 * */
public class _72_EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length() ;
        int n = word2.length() ;
        if(n * m == 0){
            return n + m ;
        }
        // 我们定义dp[i][j]的含义为：word1的前i个字符和word2的前j个字符的编辑距离。意思就是word1的前i个字符，变成word2的前j个字符，最少需要这么多步。
        int[][] dp = new int[m + 1][n + 1] ;
        for(int i = 0 ; i <= m ; i++){
            dp[i][0] = i ;
        }
        for(int j = 0 ; j <= n ; j++){
            dp[0][j] = j ;
        }

        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] ;
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] , Math.min(dp[i - 1][j],dp[i][j - 1])) + 1 ;
                }
            }
        }
        return dp[m][n] ;
    }
    public static void main(String[] args) {
        _72_EditDistance obj = new _72_EditDistance() ;
        String word1 = "" ;
        String word2 = "a" ;
        System.out.println(obj.minDistance(word1,word2));
    }
}

/**
 * 注意动态规划数组中的数字代表的含义，word1的前i个字符组成的字符串到word2的前j个字符组成的字符串的距离
 * */
