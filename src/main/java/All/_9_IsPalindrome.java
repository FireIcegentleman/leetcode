package All;

/**
 * 2021/10/19
 *
 * 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * */
public class _9_IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false ;
        }
        if (x == 0){
            return true ;
        }

        int prev = x ;
        int res = 0 ;
        int mod = 0 ;
        while (x >= 1){
            mod = x % 10 ;
            x /= 10 ;
            res = res * 10 + mod ;
        }

        return res == prev ;
    }
    public static void main(String[] args) {
        _9_IsPalindrome obj = new _9_IsPalindrome() ;
        int x = 12321 ;
        System.out.println(obj.isPalindrome(x));
    }
}
