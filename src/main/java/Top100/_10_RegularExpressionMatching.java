package Top100;

/**
 * 2021/2/1
 * leetcode 10
 * 正态符号匹配
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * 这题好难:(
 * */
enum Result {
    TRUE, FALSE
}
public class _10_RegularExpressionMatching {
    public Result[][] dp ;
    boolean dp(int i , int j , String s , String p){
        if(dp[i][j] != null){
            return dp[i][j] == Result.TRUE ;
        }
        boolean ans ;
        if(j == p.length()){
            ans = (i == s.length()) ;
        }else{
            boolean first_match = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) ;
            if(j + 1 < p.length() && p.charAt(j+1) == '*'){
                ans = (dp(i , j+2 ,s ,p) || first_match && dp(i+1 ,j ,s ,p)) ;
            }else{
                ans = first_match && dp(i+1 , j+1 , s , p) ;
            }
        }
        dp[i][j] = ans ? Result.TRUE : Result.FALSE ;
        return ans ;
    }
    public boolean isMatch(String s, String p) {
        // 用动态规划的思路思考
        dp = new Result[s.length() + 1][p.length() + 1] ;
        return dp(0 , 0 , s , p);
    }

    public boolean isMatch_simple(String s , String p){
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        String s = "aab" ;
        String p = "c*a*b" ;
        _10_RegularExpressionMatching obj = new _10_RegularExpressionMatching() ;
        System.out.println(obj.isMatch(s , p)) ;
    }
}
/**
 * dp思路是比较容易考虑的
 * https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
 * 如果 p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]；
 * 如果 p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]；
 * 如果 p.charAt(j) == '*'：
 *  如果 p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
 *  如果 p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.'：
 *      dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
 *      or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
 *      or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
 *
 *  本质上来说，各种解法所依据的状态转移函数是一样的，
 *  在过程中需要多考虑的是‘*’的状态。
 * */
