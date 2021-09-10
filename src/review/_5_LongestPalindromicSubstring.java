/**
 * 2021/1/20
 * leetcode 5
 * Longest Palindromic Substring 最长回文字串
 * longestPalindrome_origin暴力方法时间爆了 ， 通过样例 139/176
 * longestPalindrome_expandCenter中心扩散方法作为参考可以被想到，枚举回文中心并进行扩展判断。但是为什么要len1和len2。考虑奇偶
 * 但这个题目我认为比较优雅的解法除了离谱的马拉车，需要重点掌握的是动态规划
 * longestPalindrome 动态规划，但是效率上比中心扩散差太多
 */
public class _5_LongestPalindromicSubstring {
    /**
     * 以每个字母开头的回文子串，求其中长度最大的*/
    private boolean Palindrome(String substring) {
        // 这里不能用==判断是否相等，
        if(substring.equals(new StringBuffer(substring).reverse().toString())){
            return true;
        }else{
            return false ;
        }
    }
    public String longestPalindrome_origin(String s) {
        String res = "" + s.charAt(0) ;
        if(s.length() == 0){
            return res ;
        }else if(s.length() == 1){
            return s ;
        }else{
            for(int i = 0 ; i < s.length() ; i++){
                for(int j = s.length() - 1 ; j > i ; j--){
                    if(s.charAt(i) == s.charAt(j)){
                        if(Palindrome(s.substring(i , j + 1)) == true){
                            if(res.length() < s.substring(i , j + 1).length()){
                                res = s.substring(i , j + 1) ;
                            }
                        }
                    }
                }
            }
            return res ;
        }
    }

    public int expandAroundCenter(String s , int left , int right){
        int L = left , R  =right ;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L-- ;
            R++ ;
        }
        return R - L - 1;
    }
    public String longestPalindrome_expandCenter(String s) {
        if(s == null || s.length() < 1){
            return "" ;
        }
        int start = 0 , end = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            int len1 = expandAroundCenter(s , i , i) ;
            int len2 = expandAroundCenter(s , i , i + 1) ;
            int len = Math.max(len1 , len2) ;
            if(len > end - start){
                start = i - (len - 1) / 2 ;
                end = i + len / 2 ;
            }
        }
        return s.substring(start , end + 1) ;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "qkajbumzdzkiplmbcpnhbzweoevrvbptpozhtrfntszvnwbdahvkykmezrwruhvvslngruvwqebudtfxgpbmwefczwrecpqjegxkqknpobzkemmtruidulnxgntjxcmxtwmlxhzmbqfqylwvzjyojhfawwuupiipvxjiyxkqvsxbhgzzegfkdihizvjoxzrmeorikzsdyphbujaqmykrfblneqmwwxsoonzsgvligqxrrumspylfvquklbanjhkudlprwoycpxdsueokruoofyubirbhbyfuvgllijywuqmkcsfjttbnmelrylivkefllepgxnoeummujbaoyvryukyoumvuxezegpwgmwsupjuaarvbtbfmisrifjadqjypmzipvjysgakvjhfeaqwpsqijvqibshctuabwqqsjwotjopahoaptmxkwerkjkmwiodgblhtnhykzjuaoluoyokroxuvqtkpggfanzabgjejdfsgybhxbscubdpufywbxgutheskuhixasnksoayjngvhfoxxclykfobrwxjwgefarzczvptlfrgrtrjcemaeihpukhbeoezgvrwxgyhpkkfvmfvquwtswkdwqqgrgasopladdnteulqofmjhewpghkibbrewnhdllfppctgkfkoedoiwqocnpvfviochrokrgrzthrvyhqfsrzyyvqwkhuzsrkfaympcdodkwaojnghzytkhf" ;
        _5_LongestPalindromicSubstring obj = new _5_LongestPalindromicSubstring() ;
        /*System.out.println(s);
        String r = new StringBuffer(s).reverse().toString() ;
        System.out.println(s.equals(r));*/
        System.out.println(obj.longestPalindrome_expandCenter(s)) ;
    }
}