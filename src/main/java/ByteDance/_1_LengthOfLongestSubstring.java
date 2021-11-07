package ByteDance;

import java.util.HashMap;

/**
 * 2021/10/28
 *
 * 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 要求连续
 **/
public class _1_LengthOfLongestSubstring {
    // 找出最长子串的长度
    public HashMap<Character , Integer> map ;
    public int res ;
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.equals("")){
            return 0 ;
        }
        map = new HashMap<>();
        res = 1 ;

        char[] stoArray = s.toCharArray() ;

        // i , j分别表示当子串的左右索引
        int  i = 0 , j = 1 ;
        map.put(stoArray[0] , 1) ;
        while (j < s.length()){
            if (!map.containsKey(stoArray[j])){
                map.put(stoArray[j] , 1) ;
                res = Math.max(res , j - i + 1) ;
                j++ ;
            }else{
                map.remove(stoArray[i]) ;
                i++ ;
            }
        }

        return res ;
    }
    public static void main(String[] args) {
        _1_LengthOfLongestSubstring obj = new _1_LengthOfLongestSubstring() ;
        String s = "bbbbb" ;
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}
