package SwordOffer;

import java.util.StringJoiner;

/**
 * 2021/09/29
 *
 * 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * */
public class _5_ReplaceBlank {

    public String replaceSpace(String s) {
        char[] s_char = s.toCharArray() ;
        StringBuilder res = new StringBuilder() ;

        for (char c : s_char){
            if (c == ' '){
                res.append("%20") ;
            }else{
                res.append(c) ;
            }
        }
        return res.toString() ;
    }
    public static void main(String[] args) {
        _5_ReplaceBlank obj = new _5_ReplaceBlank() ;
        String s = "We are happy." ;
        System.out.println(obj.replaceSpace(s));

    }
}
