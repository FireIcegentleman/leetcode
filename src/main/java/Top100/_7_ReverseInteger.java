/**
 * 2021/1/20
 * leetcode 7
 * 正常过1027/1035样例 ， 原因go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */
public class _7_ReverseInteger {
    public int reverse(int x) {
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

    public static void main(String[] args) {
        int x = 1056389759 ;
        _7_ReverseInteger obj = new _7_ReverseInteger() ;
        System.out.println(obj.reverse(x));
    }
}
/**
 * 示例代码
 * class Solution {
 *     public int reverse(int x) {
 *         int rev = 0;
 *         while (x != 0) {
 *             int pop = x % 10;
 *             x /= 10;
 *             if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
 *                 return 0;
 *             }
 *             if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
 *                 return 0;
 *             }
 *             rev = rev * 10 + pop;
 *         }
 *         return rev;
 *     }
 * }
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
 * Memory Usage: 36.4 MB, less than 34.38% of Java online submissions for Reverse Integer.
 */
