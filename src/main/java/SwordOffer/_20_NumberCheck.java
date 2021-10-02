package SwordOffer;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.HashMap;
import java.util.Map;

/**
 * 2021/10/02
 *
 * 表示数值的字符串
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * */
public class _20_NumberCheck {
    // 判断一个数字是否表示数值
    public boolean isNumber_force(String s) {
        // s为空对象或 s长度为0(空字符串)时, 不能表示数值
        if (s == null || s.length() == 0){
            return false ;
        }
        // 标记是否遇到数位、小数点、‘e’或'E'
        boolean isNum = false , isDot = false , ise_or_E = false ;
        // 删除字符串头尾的空格，转为字符数组，方便遍历判断每个字符
        char[] str = s.trim().toCharArray() ;

        for (int i = 0 ; i < str.length ; i++){
            // 判断当前字符是否为数字位
            if (str[i] >= '0' && str[i] <= '9'){
                isNum = true ;
            }else if(str[i] == '.'){// 遇到小数点
                if (isDot || ise_or_E){// 小数点之前可以没有整数，但是不能重复出现小数点、或出现‘e’、'E'
                    return false ;
                }
                isDot = true ;
            }else if (str[i] == 'e' || str[i] == 'E'){// 遇到e E
                if (!isNum || ise_or_E){// ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
                    return false ;
                }
                ise_or_E = true ;
                isNum = false ; // 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
            }else if(str[i] == '+' || str[i] == '-'){
                // 正负号只可能出现在第一个位置或者e E后面第一个位置
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false ;
            }else{
                return false ;
            }
        }
        return isNum ;
    }

    // 有限状态机
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap() {{put(' ' , 0) ; put('s' , 1) ; put('d' , 2) ; put('.' , 4); }} , // 0
                new HashMap() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap() {{ put('d', 3); }},                                        // 4.
                new HashMap() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap() {{ put('d', 7); }},                                        // 6.
                new HashMap() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap() {{ put(' ', 8); }}
        } ;
        int p = 0 ;
        char t ;

        for (char c : s.toCharArray()){
            if (c >= '0' && c <= '9'){
                t = 'd' ;
            }else if(c == '+' || c == '-'){
                t =  's' ;
            }else if(c == 'e' || c == 'E'){
                t =  'e' ;
            }else if(c == '.' || c == ' '){
                t =  c ;
            }else{
                t = '?' ;
            }

            if (!states[p].containsKey(t)){
                return false ;
            }
            p = (int)states[p].get(t) ;
        }

        return p == 2 || p == 3 || p == 7 || p == 8 ;
    }
    public static void main(String[] args) {
        _20_NumberCheck obj = new _20_NumberCheck() ;
        String s = "  -123E-16  " ;
        System.out.println(obj.isNumber(s));
    }
}
