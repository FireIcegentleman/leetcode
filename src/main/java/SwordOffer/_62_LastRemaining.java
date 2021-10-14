package SwordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021/10/14
 *
 * 圆圈中最后剩下的数字
 *
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 北航夏令营机考题
 * */
public class _62_LastRemaining {
    public List<Integer> num ;
    // 删除到最后剩余的数字，超时
    public int lastRemaining_force(int n, int m) {
        num = new ArrayList<>();
        for (int i = 0 ; i < n ; i++){
            num.add(i) ;
        }

        int index = 0 ;
        int count = 0 ;
        while (num.size() > 1){
            if (count == m - 1){
                num.remove(index) ;
                count = 0 ;
                continue;
            }
            count++ ;
            index++ ;
            if (index >= num.size()){
                index %= num.size() ;
            }
        }
        // 返回最后剩下的那个数字
        return num.get(0) ;
    }

    // 约瑟夫环，模拟执行会超时，但是可以直接确定位置
    public int lastRemaining_less(int n, int m) {
        num = new ArrayList<>() ;
        for (int i = 0 ; i < n ; i++){
            num.add(i) ;
        }

        int idx = 0 ;
        while (n > 1){
            idx = (idx + m - 1) % n ;
            num.remove(idx) ;
            n-- ;
        }

        return num.get(0) ;
    }

    // 动态规划，最佳算法
    public int lastRemaining_dp(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

        public int lastRemaining(int n, int m) {
        return f(n , m) ;
    }

    private int f(int n, int m) {
        if (n == 1){
            return 0 ;
        }
        int x = f(n - 1 , m) ;
        return (m + x) % n ;
    }

    public static void main(String[] args) {
        _62_LastRemaining obj = new _62_LastRemaining() ;
        int n = 10 , m = 17 ;
        System.out.print(obj.lastRemaining(n , m));
    }
}
