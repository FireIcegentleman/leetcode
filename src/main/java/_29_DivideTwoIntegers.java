/**
 * 2021/05/13
 * 未完成，溢出
 *
 * 标准答案需要使用位运算
 * https://kingsfish.github.io/2017/10/11/Leetcode-29-Divide-Two-Integers/
 *
 * 如果使用加法的话：我们知道，乘法是可以由加法来代替计算的，将除数一直累加直至超过被除数。但是仔细考虑之后发现，
 * 如果使用加法，那么时长可能会过长。假设给定1和10000000，由1加到10000000，最后的结果肯定是超时。
 *
 * 举个例子，假设除数为3，被除数为16，那么商应该是5。我们从2的0次幂与除数的乘积也即20x3=3开始，
 * 幂次逐渐增加，直至超过被除数。可以看出，当幂次达到2时刚好超过16（3x20+3x21+3x22=21>16）。
 * 那么从3x22开始往下累加，3x22=12>16，那么记录下22=4。再看3x21，发现3x22+3x21=18>16，因此略过21=2。
 * 再看3x20，发现发现3x22+3x20=15<16，那么将20=1记录下。
 * 次幂累加结束，计算一下商，分别记录了4和1，因此结果4+1=5，此答案也即为最终的商。
 * */
public class _29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // 下面这版本的代码会造成溢出
        /*int num = 0 ;
        int flag ;
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
            flag = 1 ;
        }else{
            flag = -1 ;
        }

        int a_dividend = Math.abs(dividend) ;
        int a_divisor = Math.abs(divisor) ;

        while(a_dividend >= a_divisor){
            num ++ ;
            a_dividend -= a_divisor ;
        }

        return  flag * num ;*/
        if(dividend == -2147483648 && divisor == -1){
            return 2147483647 ;
        }

        // 下面使用位运算的方式进行求解
        int ans = 0 ;
        int sign = dividend > 0 == divisor > 0 ? 1 : -1 ;

        if(dividend < 0){
            dividend = -dividend ;
        }
        if(divisor < 0){
            divisor = -divisor ;
        }

        if(dividend == divisor){
            return sign ;
        }

        // 位运算
        /*for(int i = 0 , val = divisor ; dividend - divisor >= 0 ; i = 0 , val = divisor){
            while(val > 0 && dividend - val >=0){
                val = divisor << ++i ;
            }
            dividend -= divisor << (i - 1);
            ans += 1 << (i - 1) ;

        }*/
        for(int i = 0 , val = divisor ; dividend - divisor >= 0 ; i = 0 , val = divisor){
            while(val > 0 && dividend - val >= 0){
                val = divisor << (++i) ;
            }

            dividend -= divisor << (i - 1) ;
            ans += 1 << (i - 1) ;
        }
        return sign > 0 ? ans : -ans ;
    }

    public static void main(String[] args) {
        _29_DivideTwoIntegers obj = new _29_DivideTwoIntegers() ;
        int dividend = 10 ;
        int divisor = 3 ;

        int res = obj.divide(dividend , divisor) ;
        System.out.println(res);
    }
}
