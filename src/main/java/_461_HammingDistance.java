/**
 * 2021/09/23
 *
 * 汉明距离
 *
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 * 求异或
 * */
public class _461_HammingDistance {

    // 计算x对应的二级制字符串
    private String calculate(int x) {
        String res = "" ;
        int mod = 0 ;
        while(x > 0){
            mod = x % 2 ;
            x /= 2 ;
            res = mod + res ;
        }
        return res ;
    }
    // 两个数字对应的二进制位不同位置的数目
    // 分别计算，然后比较
    public int hammingDistance_force(int x, int y) {
        String s_x = calculate(x) ;
        String s_y = calculate(y) ;

        int m = s_x.length() ;
        int n = s_y.length() ;

        if (m > n){
            while(n < m){
                s_y = "0" + s_y ;
                n++ ;
            }
        }else{
            while(m < n){
                s_x = "0" + s_x ;
                m++ ;
            }
        }

        int res = 0 ;

        for (int i = 0 ; i < s_x.length() ; i++){
            if (s_x.charAt(i) != s_y.charAt(i)){
                res++ ;
            }
        }


        return res ;
    }

    // 汉明距离广泛应用于多个领域，在编码理论中用于错误检测，在信息论中量化字符串之间的差异。
    // 计算x y之间的汉明距离，将x,y做异或，然后统计其中1的个数
    public int hammingDistance(int x, int y) {
        //return Integer.bitCount(x ^ y);
        int s = x^y ;
        int res = 0 ;

        // 普通移位法
        /*while (s > 0){
            res += s & 1 ;
            s >>= 1 ;
        }*/

        // Brian Kernighan 算法
        // 记 f(x) 表示 x 和 x−1 进行与运算所得的结果（即 f(x)=x&(x-1)，那么 f(x) 恰为 x 删去其二进制表示中最右侧的 1 的结果。
        while (s > 0){
            s &= s - 1 ;
            res ++ ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _461_HammingDistance obj = new _461_HammingDistance() ;
        int x = 3 ;
        int y = 1 ;
        System.out.println(obj.hammingDistance(x , y));
    }
}
