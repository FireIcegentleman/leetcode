/**
 * 2021/1/21
 * leetcode 8
 * Runtime: 2 ms, faster than 61.91% of Java online submissions for String to Integer (atoi).
 * Memory Usage: 39 MB, less than 54.68% of Java online submissions for String to Integer (atoi).
 */

public class _8_StringToInteger {
    public int myAtoi(String s) {
        if(s.length() == 0){
            return 0 ;
        }
        long res = 0;
        // 1.Read in and ignore any leading whitespace.
        String s_no_space = s.trim() ;
        if (s_no_space.length() == 0){
            return 0 ;
        }
        // 2.Check if the next character (if not already at the end of the string) is '-' or '+'.
        int flag = 1 ;
        if(s_no_space.charAt(0) != '+' && s_no_space.charAt(0) != '-' && !(s_no_space.charAt(0) >= '0' && s_no_space.charAt(0) <= '9')){
            return 0 ;
        }else {
            int i = 0 ;
            if(s_no_space.charAt(0) == '-'){
                flag = -1 ;
                i++ ;
            } else if(s_no_space.charAt(0) == '+'){
                flag = 1 ;
                i++ ;
            }
            if(i == s_no_space.length()){
                return 0 ;
            }
            if(s_no_space.charAt(i) >= '0' &&  s_no_space.charAt(i) <= '9'){
                while(s_no_space.charAt(i) >= '0' &&  s_no_space.charAt(i) <= '9'){
                    res = res * 10 + s_no_space.charAt(i) - '0' ;
                    if(res * flag < -Math.pow(2,31)){
                        return -2147483648 ;
                    }
                    if(res * flag > Math.pow(2,31) - 1){
                        return  2147483647 ;
                    }
                    i++ ;
                    if(i == s_no_space.length()){
                        break ;
                    }
                }
            }
        }
        return (int) (flag * res);
    }

    public static void main(String[] args) {
        //System.out.println(Math.pow(2,31));
        String s = "9223372036854775808" ;
        _8_StringToInteger obj = new _8_StringToInteger() ;
        System.out.println(obj.myAtoi(s));
    }
}
