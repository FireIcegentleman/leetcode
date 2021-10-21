package All;
/**
 * 2021/10/18
 *
 * 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 有一个叫马拉车的，暂时就算了，反正也记不住
 *
 * 重点是中心扩展法
 * */
public class _5_LongestPalindrome {
    // 最长回文子串，给定一个字符串s，找到s中的最长回文子串
    // 动态规划算法
    // dp[i][j] = dp[i + 1][j - 1] & (S[i] == S[j])
    // 初始条件
    public String longestPalindrome_dp(String s) {
        int len = s.length() ;

        if (len == 1){//单字符字符串一定为回文子串
            return s ;
        }

        boolean[][] dp = new boolean[len][len] ;
        for (int i = 0 ; i < len ; i++){
            // 每个位置本身都是长度为1的字符串
            dp[i][i] = true ;
        }

        char[] charArray = s.toCharArray() ;

        int maxlen = 1 ;
        int start = 0 ;

        // 先枚举子串长度
        for (int L = 2 ; L <= len ; L++){
            // 枚举开始的位置
            for (int i = 0 ; i < len ; i++){
                int j = i + L - 1 ;
                if (j >= len){
                    break;
                }

                if (charArray[i] != charArray[j]){
                    dp[i][j] = false ;
                }else{
                    if (j - i < 3){// 两个相邻的字符相同
                        dp[i][j] = true ;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1] ;
                    }
                }

                if (j - i + 1 > maxlen && dp[i][j]){
                    start = i ;
                    maxlen = j - i + 1;
                }
            }
        }
        return s.substring(start , start + maxlen) ;
    }

    // 中心扩展算法
    // 分奇数、偶数情况进行扩展，选择其中更长的
    public String longestPalindrome(String s) {
        int len = s.length() ;
        if (s == null || len < 1){
            return "" ;
        }

        // 初始化最大回文子串的起点和终点
        int start = 0 ;
        int end = 0 ;

        // 遍历每个位置，当作中心位
        for (int i = 0 ; i < len ; i++){
            // 从自己一个拓展
            int len1 = calculate(s , i , i) ;
            // 从自己和后一个进行扩展
            int len2 = calculate(s , i , i + 1) ;
            int tmp = Math.max(len1 , len2) ;

            if (tmp > end - start){
                // 当前长度对应的位置i，向两侧扩展
                start = i - (tmp - 1) / 2 ;
                end = i + tmp / 2 ;
            }
        }
        return s.substring(start , end + 1) ;
    }

    /**
     *
     * @param s             输入的字符串
     * @param left          起始的左边界
     * @param right         起始的右边界
     * @return              回文串的长度
     */
    private int calculate(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left-- ;
            right++ ;
        }
        // 终止时 s.charAt(left) != s.charAt(right)
        // 回文串的长度是right - left + 1 - 2 = right - left - 1
        return right - left - 1 ;
    }

    public static void main(String[] args) {
        _5_LongestPalindrome obj = new _5_LongestPalindrome() ;
        String s = "babad" ;
        System.out.println(obj.longestPalindrome(s));
    }
}
