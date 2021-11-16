package All;
/**
 * 2021/11/14
 *
 * Pow(x,n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * */
public class _50_MyPow {
    // pow(x,n)
    // 299/305 超时
    public double myPow_force(double x, int n) {
        boolean flag = n > 0 ;

        double res = 1 ;
        n = Math.abs(n) ;

        while (n > 0){
            res = res * x ;
            n-- ;
        }

        return flag ? res : 1 / res ;
    }

    // 快速幂计算
    public double myPow(double x, int n) {
        long N = n ;
        return N >= 0 ? quickPow(x , N) : 1.0 / quickPow(x , -N) ;
    }

    private double quickPow(double x, long N) {
        if (N == 0){
            return 1.0 ;
        }

        double y = quickPow(x , N / 2) ;
        // 区分奇偶性
        return N % 2 == 0 ? y * y : y * y * x ;
    }

    public static void main(String[] args) {
        _50_MyPow obj = new _50_MyPow() ;
        double x = 2.00000 ;
        int n = 10 ;
        System.out.println(obj.myPow(x , n));
    }


}
