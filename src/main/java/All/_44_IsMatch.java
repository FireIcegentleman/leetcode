package All;

import java.sql.CallableStatement;

/**
 * 2021/11/13
 *
 * 通配符匹配
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * */
public class _44_IsMatch {
    // 通配符匹配
    public boolean isMatch_dp(String s, String p){
        int slen = s.length() ;
        int plen = p.length() ;

        // s的第i位和p的第j位是否匹配
        boolean[][] dp = new boolean[slen + 1][plen + 1] ;
        dp[0][0] = true ;

        // 初始化时，如果模式串里有*号，则可以匹配一切，直到模式串当前位置没有星号
        for (int i = 1 ; i <= plen ; i++){
            if (p.charAt(i - 1) == '*'){
                dp[0][i] = true ;
            }else{
                break;
            }
        }

        for (int i = 1 ; i <= slen ; i++){
            for (int j = 1 ; j <= plen ; j++){
                // 对于p有三种情况，字符、？、*
                if (p.charAt(j - 1) == '?'){
                    // ？匹配所有的字符，所以与前一个位置的值相等
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (p.charAt(j - 1) == '*'){
                    // * 匹配任意数量的任意字符
                    // 是否使用这个*
                    // 面对*，它可以表示空字符，也就是说直接把*去掉，看没有*是否能匹配，即保持i不动，j-1；
                    // 另一种情况是*表示多个字符，我们得把*留着，所以j不动，然后看当前字符之前的字符是否也能被*匹配，
                    // 如果之前字符能，那么再加上现在的一个字符，*就能匹配这几个连续字符了
                    dp[i][j] = dp[i][j - 1] | dp[i - 1][j] ;
                }else{
                    // 是普通字符，判断当前的两个字符是否匹配成功
                    if (s.charAt(i - 1) == p.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] ;
                    }else {
                        dp[i][j] = false ;
                    }
                }
            }
        }
        return dp[slen][plen] ;
    }

    // 贪心算法
    public boolean isMatch(String s, String p) {
        int sRight = s.length() , pRight = p.length() ;

        // 从后往前，遇到*停止
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*'){
            if (charMatch(s.charAt(sRight - 1) , p.charAt(pRight - 1))){
                --sRight ;
                --pRight ;
            }else{
                return false ;
            }
        }

        if (pRight == 0){
            return sRight == 0 ;
        }

        int sIndex = 0 , pIndex = 0 ;
        int sRecord = -1 , pRecord = -1 ;

        while (sIndex < sRight && pIndex < pRight){
            if (p.charAt(pIndex) == '*'){
                ++pIndex ;
                sRecord = sIndex ;
                pRecord = pIndex ;
            }else if(charMatch(s.charAt(sIndex) , p.charAt(pIndex))){
                ++sIndex ;
                ++pIndex ;
            }else if(sRecord != -1 && sRecord + 1 < sRight){
                ++sRecord ;
                sIndex = sRecord ;
                pIndex = pRecord ;
            }else{
                return false ;
            }
        }
        return allStars(p , pIndex , pRight) ;
    }

    private boolean allStars(String p, int pIndex, int pRight) {
        for (int i = pIndex ; i < pRight ; i++){
            if (p.charAt(i) != '*'){
                return false ;
            }
        }
        return true ;
    }

    private boolean charMatch(char a , char b) {
        return a == b || b == '?' ;
    }

    public static void main(String[] args) {
        _44_IsMatch obj = new _44_IsMatch() ;
        String s = "aa" ;
        String p = "a" ;
        System.out.println(obj.isMatch(s , p));
    }


}
