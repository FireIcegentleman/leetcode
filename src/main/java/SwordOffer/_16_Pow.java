package SwordOffer;
/**
 * 2021/10/02
 *
 * 数值的整数次方
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * */
public class _16_Pow {
    // 301/304
    public double myPow_force(double x, int n) {
        double res = 1 ;
        if (x == 1.0000 || n == 0){
            return res ;
        }
        if (n > 0){
            while (n > 0){
                res *= x ;
                n-- ;
            }
        }else{
            x = 1/ x ;
            while (n < 0){
                res *= x ;
                n++ ;
            }
        }
        return res ;
    }
    // 快速幂法
    public double myPow(double x, int n) {
        if (x == 0){
            return 0 ;
        }

        long b = n ;
        double res = 1.0 ;
        if (b < 0){
            x = 1/x ;
            b = -b ;
        }

        while (b > 0){
            if ((b & 1) == 1){
                res *= x ;
            }
            x *= x ;
            b >>= 1 ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _16_Pow obj = new _16_Pow() ;
        double x = 1.0000 ;
        int n = 2147483647 ;
        System.out.println(obj.myPow(x , n));
    }
}
