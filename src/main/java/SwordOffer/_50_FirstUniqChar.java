package SwordOffer;

import java.util.HashMap;

/**
 * 2021/10/07
 *
 * 第一个只出现一次的字符
 * */
public class _50_FirstUniqChar {
    public char firstUniqChar(String s) {
        if (s.length() == 0){
            return ' ' ;
        }
        HashMap<Character , Boolean> map = new HashMap<>() ;
        char[] s_c = s.toCharArray() ;
        for (char c : s_c){
            map.put(c , !map.containsKey(c)) ;
        }
        for (char c : s_c){
            if (map.get(c)){
                return c ;
            }
        }
        return ' ';
    }
    public static void main(String[] args) {
        _50_FirstUniqChar obj = new _50_FirstUniqChar() ;
        String s = "leetcode" ;
        System.out.print(obj.firstUniqChar(s));
    }
}
