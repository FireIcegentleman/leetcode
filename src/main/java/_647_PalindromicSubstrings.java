/**
 * 2021/09/27
 *
 * 回文子串
 *
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * */
public class _647_PalindromicSubstrings {
    // 统计回文子串的个数
    // 使用动态规划，dp[i][j]表示从i到j的子串是否为回文子串
    public int countSubstrings_dp(String s) {
        int n = s.length() ;
        // 统计回文子串的个数
        int res = 0 ;

        boolean[][] dp = new boolean[n][n] ;

        for (int j = 0 ; j < n ; j++){
            for (int i = 0 ; i <=j ; i++){
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true ;
                    res++;
                }
            }
        }
        return res ;
    }

    // 中心扩展法
    public int countSubstrings(String s) {
        int ans = 0 ;
        for (int center = 0 ; center < 2 * s.length() - 1 ; center++){
            // left和right指针和中心点的关系是？
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // 大致的关系出来了，可以选择带两个特殊例子进去看看是否满足。
            int left = center / 2 ;
            int right = left + center % 2 ;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                ans++ ;
                left -- ;
                right++ ;
            }
        }
        return ans ;
    }

    public static void main(String[] args) {
        _647_PalindromicSubstrings obj = new _647_PalindromicSubstrings() ;
        String s = "abc" ;
        System.out.println(obj.countSubstrings(s));
    }
}
