package SwordOffer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 2021/10/11
 *
 * 最长不含重复字符的字符串
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * */
public class _48_LengthOfLongestSubstring {
    // 最长不包含重复字符的子字符串
    public int lengthOfLongestSubstring_double_pointer(String s) {
        int len = s.length() ;

        HashSet<Character> set = new HashSet<>() ;
        int res = 0 , i = 0 , j = 0 ;
        // 滑动窗口
        while (i < len && j < len){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++)) ;
                res = Math.max(res , j - i) ;
            }else{
                set.remove(s.charAt(i++)) ;
            }
        }
        return res ;
    }

    // 动态规划
    public int lengthOfLongestSubstring(String s) {
        int len = s.length() ;

        HashMap<Character , Integer> map = new HashMap<>() ;
        int res = 0 , tmp = 0 ;
        for (int j = 0 ; j < len ; j++){
            // 获取索引 i
            int i = map.getOrDefault(s.charAt(j) , -1) ;
            map.put(s.charAt(j) , j) ;
            tmp = tmp < j - i ? tmp + 1 : j - i ; // dp[j - 1] ->dp[j]
            res = Math.max(res , tmp) ;
        }
        return res ;
    }

    public static void main(String[] args) {
        _48_LengthOfLongestSubstring obj = new _48_LengthOfLongestSubstring() ;
        String s = " " ;
        System.out.print(obj.lengthOfLongestSubstring(s));
    }
}
