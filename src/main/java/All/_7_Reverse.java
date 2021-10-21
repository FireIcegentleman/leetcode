package All;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 2021/10/18
 *
 * 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * */
public class _7_Reverse {
    Deque<Integer> queue ;
    public int reverse(int x) {
        // flag表示是否大于0
        boolean flag = x > 0;
        x = Math.abs(x) ;
        queue = new ArrayDeque<>();

        int mod = 0 ;
        while (x >= 1){
            mod = x % 10 ;
            x /= 10 ;
            queue.addFirst(mod);
        }

        int res = 0 ;
        int tmp = 0 ;

        while (!queue.isEmpty()){
            if (res > Integer.MAX_VALUE / 10){
                return 0 ;
            }
            tmp = queue.pollLast() ;
            res = res * 10 + tmp ;
        }
        return flag ? res : -res ;
    }
    public static void main(String[] args) {
        _7_Reverse obj = new _7_Reverse() ;
        int x = 1534236469 ;
        System.out.println(obj.reverse(x));
    }
}
