package SwordOffer;

import java.util.LinkedList;

/**
 * 2021/10/07
 *
 * 数字序列中某一位的数字
 *
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 * */
public class _44_FindNthDigit {
    // 输出第n位的数字
    // 34 / 70 超时
    public int findNthDigit_force(int n) {
        String str = "" ;
        for (int i = 0 ; i < Math.pow(2 , 31) ; i++){
            if (str.length() > n){
                return str.charAt(n) - '0' ;
            }
            str += String.valueOf(i) ;
        }
        return 0 ;
    }

    /**
     * 1. 确定n所在数字的位数，记为digit
     * 2. 确定n所在的数字，记为Num
     * 3. 确定n是num中的那一数位，并返回结果
     * */
    public int findNthDigit(int n) {
        int digit = 1 ;
        long start = 1 ;
        long count = 9 ;

        // 确定N所在的位数
        while (n > count){
            n -= count ;
            digit += 1 ;
            start *= 10 ;
            count = 9 * start * digit ;
        }
        // 确定n所在的数字
        long num = start + (n - 1) / digit ;
        return Long.toString(num).charAt((n - 1) % digit) - '0' ;
    }

    public static void main(String[] args) {
        _44_FindNthDigit obj = new _44_FindNthDigit() ;
        int n = 1000000000 ;
        System.out.println(obj.findNthDigit(n));
    }
}
