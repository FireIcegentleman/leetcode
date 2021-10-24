package All;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import javafx.scene.control.SplitPane;

import java.util.Map;

/**
 * 2021/10/24
 *
 * 两数相除
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * */
public class _29_Divide {
    // 被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
    // 超时
    public int divide_force(int dividend, int divisor) {
        long count = 0 ;

        if (divisor == 0){
            return Integer.MAX_VALUE ;
        }

        boolean flag = true ;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
            flag = true;
        }else{
            flag = false ;
        }
        if (dividend == Integer.MIN_VALUE){
            dividend = Integer.MAX_VALUE ;
        }else{
            dividend = Math.abs(dividend) ;
        }

        if (divisor == Integer.MIN_VALUE){
            divisor = Integer.MAX_VALUE;
        }else{
            divisor = Math.abs(divisor) ;
        }

        while (dividend >= divisor){
            dividend -= divisor ;
            count++ ;
            if (count >= Integer.MAX_VALUE){
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return flag ? (int)count : (int)-count ;
    }

    // 题目的隐含条件为不能使用long，让所有数映射到负数进行处理，因为负数所能表示的范围更大
    /**
     * 起始先对边界情况进行特判
     * 记录最终结果的符号，并将两数都映射成为负数
     * 采取逐步增大dividend来逼近divisor的方式
     * */
    public int divide(int dividend, int divisor){
        int boundary = Integer.MIN_VALUE / 2 ;

        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE ;
        }

        boolean flag = false ;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor> 0)){
            flag = true ;
        }
        if (dividend > 0){
            dividend = -dividend ;
        }
        if (divisor > 0){
            divisor = -divisor ;
        }

        int res = 0 ;

        while (dividend <= divisor){
            // c为逼近参数，d为累加结果
            int c = divisor , d = -1 ;
            // 自倍增，指数型的
            while (c >= boundary && d >= boundary && c >= dividend - c){
                c += c ;
                d += d ;
            }
            dividend -= c ;
            res += d ;
        }
        return flag ? res : -res ;
    }
    public static void main(String[] args) {
        _29_Divide obj = new _29_Divide() ;
        int dividend = -2147483648 , divisor = -1 ;
        System.out.println(obj.divide(dividend , divisor));
    }
}
