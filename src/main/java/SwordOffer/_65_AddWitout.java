package SwordOffer;
/**
 * 2021/10/11
 *
 * 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 位运算
 * */
public class _65_AddWitout {
    // 位运算
    // 传统意义上的加法可以分为三步：计算每一位的和、计算进位结果、和+进位结果
    // 位运算中，和通过^实现，carry通过 & << 1实现（2）
    public int add(int a, int b) {
        int carry = 0 , sum = 0 ;
        do {
            sum = a ^ b ;
            carry = (a & b) << 1 ;
            a = sum ;
            b = carry ;
        }while (b != 0);

        return sum ;
    }
    public static void main(String[] args) {
        _65_AddWitout obj = new _65_AddWitout() ;
        int a = 33 ;
        int b = 1 ;
        System.out.print(obj.add(a , b));
    }
}
