package SwordOffer;
/**
 * 2021/10/13
 *
 * 把字符串转换成整数
 *
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 * 1. 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止
 *
 * 2. 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 *    假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 3. 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 4. 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 5. 非法作为返回0
 *
 * */
public class _67_StrToInt {
    public int strToInt_force(String str) {
        // 弃用空格
        str = str.trim() ;

        if (str.length() == 0){
            return 0 ;
        }

        if (str.charAt(0) != '-' && str.charAt(0) != '+' && !(str.charAt(0) >= '0' && str.charAt(0) <= '9')){
            return 0 ;
        }
        // 判断符号，false代表负号
        int index = 0 ;
        boolean flag = true ;
        if (str.charAt(index) == '-'){
            flag = false ;
            index++ ;
        }else if (str.charAt(index) == '+'){
            index++ ;
        }

        // 处理后续的数字
        long res = 0 ;

        for ( ; index < str.length() ; index++){
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9'){
                res = res * 10 + (str.charAt(index) - '0') ;
            }else{
                break;
            }

            if (res > Integer.MAX_VALUE){
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            }
        }

        return flag ? (int)res : (int)-res ;
    }

    // 空间复杂度为O(1)
    public int strToInt(String str) {
        int res = 0 , boundary = Integer.MAX_VALUE / 10 ;

        int i = 0 , sign = 1 , length = str.length() ;

        if (length == 0){
            return 0 ;
        }
        while(str.charAt(i) == ' '){
            if(++i == length){
                return 0;
            }
        }

        if (str.charAt(i) == '-'){
            sign = -1 ;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+'){
            i++ ;
        }

        for (int j = i ; j < str.length() ; j++){
            if (str.charAt(j) < '0' || str.charAt(j) > '9'){
                break ;
            }
            if (res > boundary || res == boundary && str.charAt(j) > '7'){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            }
            res = res * 10 + (str.charAt(j) - '0') ;
        }
        return sign * res ;
    }
    public static void main(String[] args) {
        _67_StrToInt obj = new _67_StrToInt() ;
        String str = " -1010023630o4" ; //2147483647
        System.out.println(obj.strToInt(str));
    }
}
