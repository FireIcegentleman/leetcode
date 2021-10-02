package SwordOffer;

/**
 * 2021/10/02
 *
 * 二进制中1的个数
 *
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * */
public class _15_HammingWeight {
    // 计算N在二进制表示下的1的个数
    public int hammingWeight(int n) {
        int count = 0 ;

        while (n != 0){
            count += n & 1 ;
            n >>>= 1 ;
        }
        return count ;
    }

    public int hammingWeight_n(int n) {
        int count = 0 ;

        while (n != 0){
            count++ ;
            n = n & (n - 1) ;
        }
        return count ;
    }
    public static void main(String[] args) {
        _15_HammingWeight obj = new _15_HammingWeight() ;
        int n = 11 ;
        System.out.println(obj.hammingWeight(n));
    }
}
