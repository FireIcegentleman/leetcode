package All;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 2021/10/16
 *
 * 无重复的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * */
public class _3_LengthOfLongestSubstring {
    // 无重复的最长字串
    // 滑动窗口
    public int lengthOfLongestSubstring_window(String s) {
        int len = s.length() ;
        if (len == 0){
            return 0 ;
        }

        int res = 1 ;
        int left = 0 , right = 0 ;
        HashSet<Character> set = new HashSet<>() ;

        while (left < len && right < len){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right++)) ;
                res = Math.max(set.size() , res) ;
            }else{
                set.remove(s.charAt(left++)) ;
            }
        }
        return res ;
    }

    // 动态规划
    // dp[i]表示到i为止最长不重复字符串的长度
    public int lengthOfLongestSubstring(String s) {
        int len = s.length() ;
        if (len == 0){
            return 0 ;
        }

        HashMap<Character , Integer> map = new HashMap<>() ;
        int res = 0 , tmp = 0 ;
        for (int j = 0 ; j < len ; j++){
            int i = map.getOrDefault(s.charAt(j) , -1) ;
            map.put(s.charAt(j) , j) ;
            tmp = tmp < j - i ? tmp + 1 : j - i ;// tmp即dp[i - 1]
            res = Math.max(tmp , res) ;
        }
        return res ;
    }

    public static void main(String[] args) {
        _3_LengthOfLongestSubstring obj = new _3_LengthOfLongestSubstring() ;
        String s = "pwwkew" ;
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}
