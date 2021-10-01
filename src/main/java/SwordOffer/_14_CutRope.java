package SwordOffer;
/**
 * 2021/10/01
 *
 * 剪绳子
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * */
public class _14_CutRope {
    // 剪绳子，数学公式
    // ① 当所有绳段长度相等时，乘积最大。② 最优的绳段长度为 33 。
    public int cuttingRope_math(int n) {
        if (n <= 3){
            return n - 1 ;
        }else{
            int a = n / 3 ;
            int mod = n % 3 ;

            if (mod == 0){
                return (int)Math.pow(3 , a) ;
            }else if(mod == 1){
                return (int)Math.pow(3 , a - 1) * 4 ;
            }else {
                return (int)Math.pow(3 , a) * 2 ;
            }
        }
    }

    // 剪绳子，动态规划
    public int cuttingRope_dp(int n) {
        int[] dp = new int[n + 1] ;
        dp[2] = 1 ;
        for (int i = 3 ; i < n + 1 ; i++){
            for (int j = 2 ; j < i ; j++){
                dp[i] = Math.max(dp[i] , Math.max(j * (i - j) , j * (dp[i - j]))) ;
            }
        }
        return dp[n] ;
    }

    // 剪绳子，贪心算法
    // 尽可能把绳子分成长度为3的小段，这样乘积最大
    public int cuttingRope_greedy(int n) {
        int res = 1 ;
        if (n <= 3){
            return n - 1 ;
        }
        if (n == 4){
            return 4 ;
        }

        while(n > 4){
            res *= 3 ;
            n -= 3 ;
        }

        return res * n ;
    }
    public static void main(String[] args) {
        _14_CutRope obj = new _14_CutRope() ;
        int n = 10 ;
        System.out.println(obj.cuttingRope_dp(n));
    }
}
