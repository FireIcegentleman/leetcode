package SwordOffer;

import org.jetbrains.annotations.NotNull;
/**
 * 2021/10/10
 *
 * 把数字翻译成字符串
 *
 *  给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 *  一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * */

public class _46_TranslateNum {
    public int res = 0 ;
    // 返回有几种转换方法
    // 递归
    public int translateNum(int num) {
        String asStr = String.valueOf(num) ;
        int len = asStr.length() ;
        calculate(asStr , 0 , len) ;
        return res ;
    }

    private void calculate(String asStr, int cur , int len) {
        if (cur == len){
            res++ ;
            return;
        }

        if (isvalid(asStr.substring(cur , cur + 1))){
            calculate(asStr , cur + 1 , len);
        }

        if (cur < len - 1){
            if (isvalid(asStr.substring(cur , cur + 2))){
                calculate(asStr , cur + 2 , len);
            }
        }
    }

    private boolean isvalid(String num) {
        if (num.length() == 1){
            return true ;
        }

        if (num.length() == 2){
            int c1 = num.charAt(0) ;
            int c2 = num.charAt(1) ;

            if (c1 == '0'){
                return false ;
            }else if (c1 == '1'){
                return true ;
            }else if (c1 == '2'){
                if (c2 >= '0' && c2 <= '5'){
                    return true ;
                }
            }else{
                return false ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {
        _46_TranslateNum obj = new _46_TranslateNum() ;
        int num = 506 ;
        System.out.print(obj.translateNum(num));
    }
}
