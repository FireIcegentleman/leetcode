package ByteDance;

import java.util.Map;

/**
 * 2021/11/10
 *
 * Sqrt(x)
 *
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * */
public class _36_MySqrt {
    // 二分法枚举
    public int mySqrt_Binary(int x) {
        if (x <= 1){
            return x ;
        }

        int left = 1 ;
        int right = x / 2 ;

        while (left < right){
            // 取中间数的时候需要+1，在区间只有 2 个数的时候，根据 if、else 的逻辑区间的划分方式是：[left..mid - 1] 与 [mid..right]。
            // 如果 mid 下取整，在区间只有 2 个数的时候有 mid = left，一旦进入分支 [mid..right] 区间不会再缩小，发生死循环。
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid){
                right = mid - 1 ;
            }else{
                left = mid ;
            }
        }
        return left ;
    }

    // 牛顿法
    private int mySqrt(int x) {
        if (x <= 1){
            return x ;
        }
        double C = x , x0 = x ;

        while (true){
            double x1 = 0.5 * (x0 + C / x0) ;
            if (Math.abs(x1 - x0) < 1e-7){
                break;
            }
            x0 = x1 ;
        }
        return (int) x0 ;
    }
    public static void main(String[] args) {
        _36_MySqrt obj = new _36_MySqrt() ;
        int x = 16 ;
        System.out.println(obj.mySqrt(x));
    }


}
/**
 * 1. 为什么用 while(left < right) 这种写法？
 * 采用 while(left < right) 这种写法，在退出循环的时候有 left == right 成立，因此返回 left 或者 right 都可以。不用思考返回 left 还是 right。
 *
 * 2. 如何想到判断条件是 mid > x / mid？
 * while(left < right) 这种写法把区间分成两个区间：一个区间一定不存在目标元素，另一个区间有可能存在目标元素。
 * 因此 先思考满足什么条件的 mid 一定不是目标元素，进而思考下一轮搜索区间不容易出错，它的反面就是另一个区间。
 * 根据本题解最开始分析「例 2」。我们分析出：如果一个数 mid 的平方大于 x ，那么 mid 一定不是 x 的平方根，这种情况下，
 * 搜索区间是 [0..mid - 1]，此时我们将右边界设置为 right = mid - 1 的原因。剩下的情况不用思考，搜索区间一定是 [a..right]，此时设置 left = mid。
 *
 *
 * */
