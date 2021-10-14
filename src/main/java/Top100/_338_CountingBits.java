import java.util.Arrays;

/**
 * 2021/09/22
 *
 * 比特位计数
 *
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * */
public class _338_CountingBits {
    // 不断除以2，计算余数和商里有几个1
    private int count(int n) {
        int count = 0 ;
        int mod = 0 ;
        while(n > 0){
            mod = n % 2 ;
            n = n / 2 ;
            if (mod == 1){
                count++ ;
            }
        }
        return count ;
    }
    public int[] countBits_cal(int n) {
        int[] res = new int[n + 1] ;
        for (int i = 0 ; i < n + 1 ; i++){
            res[i] = count(i) ;
        }
        return res ;
    }

    // 对于奇数：一定比前面的偶数多一个末尾的1
    // 对于偶数，偶数中1的个数一定和除以2之后的那个数一样多，因为最低为是0，所以除以2就是后移一位
    public int[] countBits(int n) {
        int[] res = new int[n + 1] ;
        res[0] = 0 ;

        for (int i = 1 ; i < n + 1 ; i++){
            if (i % 2 == 1){// 奇数
                res[i] = res[i - 1] + 1 ;
            }else{
                res[i] = res[i / 2] ;
            }
        }

        return res ;
    }
    public static void main(String[] args) {
        _338_CountingBits obj = new _338_CountingBits() ;
        int n = 5 ;
        System.out.println(Arrays.toString(obj.countBits(n)));
    }
}
