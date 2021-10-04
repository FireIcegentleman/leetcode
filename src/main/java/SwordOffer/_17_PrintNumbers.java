package SwordOffer;

import java.util.Arrays;

/**
 * 2021/10/03
 *
 * 打印从1到最大的n位数
 * */
public class _17_PrintNumbers {
    // 打印从1到最大的n位数
    public int[] printNumbers(int n) {
        int board = (int)Math.pow(10, (n)) ;
        int[] res = new int[board - 1] ;
        for (int i = 0 ; i < board - 1 ; i++){
            res[i] = i + 1 ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _17_PrintNumbers obj = new _17_PrintNumbers() ;
        int n = 3 ;
        System.out.println(Arrays.toString(obj.printNumbers(n)));
    }
}
