package SwordOffer;
/**
 * 2021/10/05
 *
 * 正则表达式匹配
 *
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * */
public class _19_IsMatch {
    public boolean isMatch(String s, String p) {
        int m = s.length() ;
        int n = p.length() ;

        boolean[][] dp = new boolean[m + 1][n + 1] ;

        for (int i = 0 ; i <= m ; i++){
            for (int j = 0 ; j <= n ; j++){
                // 空正则
                if (j == 0){
                    dp[i][j] = i == 0 ;
                }else{// 非空正则
                    if (p.charAt(j - 1) != '*'){
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')){
                            dp[i][j] = dp[i - 1][j - 1] ;
                        }
                    }else{// 是*
                        // 分为看和不看两种情况
                        // 不看
                        if (j >= 2){
                            dp[i][j] |= dp[i][j - 2] ;
                        }
                        // 看
                        if(i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')){
                            dp[i][j] |= dp[i - 1][j] ;
                        }
                    }
                }
            }
        }
        return dp[m][n] ;
    }

    public static void main(String[] args) {
        _19_IsMatch obj = new _19_IsMatch() ;
        String s = "aa" ;
        String p = "a*" ;
        System.out.println(obj.isMatch(s , p));
    }
}
