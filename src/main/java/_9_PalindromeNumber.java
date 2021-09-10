/**
 * 2021/1/21
 * leetcode 9
 * Runtime: 6 ms, faster than 99.97% of Java online submissions for Palindrome Number.
 * Memory Usage: 38.3 MB, less than 66.91% of Java online submissions for Palindrome Number.
 */
public class _9_PalindromeNumber {
    public int NumReverse(int x) {
        int res = 0 ;
        int flag = x > 0 ? 1 : -1 ;
        int abs_num = Math.abs(x) ;
        int mod = 0;
        while(abs_num >= 10){
            mod = abs_num % 10 ;
            res = res * 10 + mod ;
            abs_num = abs_num / 10 ;
        }
        res = res * 10 + abs_num ;
        return flag * res ;
    }

    public boolean isPalindrome(int x) {
        int x_reverse = NumReverse(x) ;
        if(x < 0){
            return false ;
        }
        return x == x_reverse ;
    }

    public static void main(String[] args) {
        int x = -121 ;
        _9_PalindromeNumber obj = new _9_PalindromeNumber() ;
        System.out.println(obj.isPalindrome(x)) ;
    }
}
