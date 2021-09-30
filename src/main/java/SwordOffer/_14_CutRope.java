package SwordOffer;
/**
 * 2021/09/30
 *
 * 剪绳子
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * */
public class _14_CutRope {
    // 剪绳子，数学共识
    public int cuttingRope_math(int n) {
        return 0 ;
    }

    // 剪绳子，动态规划
    public int cuttingRope_dp(int n) {
        return 0 ;
    }

    // 剪绳子，贪心算法
    public int cuttingRope_greedy(int n) {
        return 0 ;
    }
    public static void main(String[] args) {
        _14_CutRope obj = new _14_CutRope() ;
        int n = 10 ;
        System.out.println(obj.cuttingRope_math(n));
    }
}
