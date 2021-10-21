package All;

import SwordOffer._10_FogSteps;

/**
 * 2021/10/19
 *
 * 正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * */
public class _10_IsMatch {
    // 动态规划
    // dp[i][j]表示s[i]到p[j]是否匹配
    public boolean isMatch(String s, String p) {
        s = " " + s ;
        p = " " + p ;

        int slen = s.length() ;
        int plen = p.length() ;

        if (slen == 0 && plen == 0){// 同时为空字符串
            return true ;
        }else if(slen * plen == 0){// 其中一个为空
            return false ;
        }

        boolean[][] dp = new boolean[slen + 1][plen + 1] ;

        // 动态规划有两个重要的点：
        // 1. 初始状态：在前面添加一个空字符，做到” “ == ” “
        dp[0][0] = true ;

        // 2. 状态转移函数：
        for (int i = 1 ; i <= slen ; i++){
            for (int j = 1 ; j <= plen ; j++){
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){// 普通的匹配
                    dp[i][j] = dp[i-1][j-1] ;
                }else if (p.charAt(j - 1) == '*'){// 为'*'
                    // 有两种情况
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.'){
                        dp[i][j] = dp[i][j - 2] ;
                    }else{
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j] ;
                    }
                }
            }
        }

        return dp[slen][plen] ;
    }
    public static void main(String[] args) {
        _10_IsMatch obj = new _10_IsMatch() ;
        String s = "aab" ;
        String p = "c*a*b" ;
        System.out.println(obj.isMatch(s , p));
    }
}
