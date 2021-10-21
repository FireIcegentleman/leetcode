package All;

import sun.font.DelegatingShape;

/**
 * 2021/10/19
 *
 * 字符串转换整数(atoi)
 *
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 需要进行如下操作：
 *      1. 读入字符串并丢弃无用的前导空格
 *      2. 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
 *      确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 *      3. 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 *      4. 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
 *      如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 *      5.如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
 *      6. 返回整数作为最终结果。
 *
 * */
public class _8_MyAtoi {
    public int myAtoi(String s) {
        // 1. 去除字符串前后的空白字符
        s = s.trim() ;

        int len = s.length() ;
        if (len == 0){
            return 0 ;
        }

        // 是否为正数
        boolean flag = true ;
        int index = 0 ;

        if (s.charAt(index) != '+' && s.charAt(index) != '-' && !(s.charAt(index) >= '0' && s.charAt(index) <= '9')){
            return 0 ;
        }else if (s.charAt(index) == '+'){
            index++ ;
            // 正号的下一个字符不是数字
            if ((len == 1) || (!(s.charAt(index) >= '0' && s.charAt(index) <= '9'))){
                return 0 ;
            }
        }else if (s.charAt(index) == '-'){
            flag = false ;
            index++ ;
            if ((len == 1) || (!(s.charAt(index) >= '0' && s.charAt(index) <= '9'))){
                return 0 ;
            }
        }

        int res = 0 ;
        int boundary = Integer.MAX_VALUE / 10 ;
        // 如果第一个字符是+-，则index=1
        // 如果是非数字，则已经返回0
        for ( ; index < len ; index++){
            if (s.charAt(index) < '0' || s.charAt(index) > '9'){
                break;
            }else if ((res > boundary) || (res == boundary && s.charAt(index) > '7')){
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            }

            res = res * 10 + s.charAt(index) - '0' ;
        }
        return flag ? res : -res ;
    }
    public static void main(String[] args) {
        _8_MyAtoi obj = new _8_MyAtoi() ;
        String s = " -1010023630o4";
        System.out.println(obj.myAtoi(s));
    }
}
