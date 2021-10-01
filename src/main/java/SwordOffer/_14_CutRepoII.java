package SwordOffer;
/**
 * 2021/10/01
 *
 * 剪绳子 II
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模
 * */
public class _14_CutRepoII {
    // 答案要取模，取模1000000007
    // 贪心
    public int cuttingRope(int n) {
        if (n <= 3){
            return n - 1 ;
        }

        if (n == 4){
            return 4 ;
        }

        long res = 1L;
        int p = (int)1e9 + 7 ;
        while (n > 4){
            res = res * 3 % p ;
            n -= 3 ;
        }
        return (int)(res * n % p) ;
    }
    public static void main(String[] args) {
        _14_CutRepoII obj = new _14_CutRepoII() ;
        int n = 120 ;
        System.out.println(obj.cuttingRope(n));
    }
}
