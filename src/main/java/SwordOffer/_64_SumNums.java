package SwordOffer;
/**
 * 2021/10/14
 *
 * 求1+2+3+4+...+n
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * */
public class _64_SumNums {
    // 能用的有：位运算、+-、逻辑运算
    // 不能 乘除 和 循环 的话，使用迭代似乎是唯一的途径
    public int sumNums(int n) {
        // 传统的迭代法写出来的代码如下：
//        if (n == 1){
//            return 1 ;
//        }
//        return n + sumNums(n - 1) ;
        // 上面这样的写法使用到了if，所以想办法把if消掉
        // 这时候考虑逻辑运算的方法，短路效应
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0 ;
        return n ;

    }

    public static void main(String[] args) {
        _64_SumNums obj = new _64_SumNums() ;
        int n = 9 ;
        System.out.print(obj.sumNums(n));
    }
}
