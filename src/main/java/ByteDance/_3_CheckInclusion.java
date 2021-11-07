package ByteDance;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 2021/10/28
 *
 * 字符串的排列
 *
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 **/
public class _3_CheckInclusion {
    /**
     * 题目本质上有两种解法：
     *      1. 求出s1的所有排列，然后s2搜索，但是递归需要的栈深度太高
     *      2. HashMap
     * */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length() ;
        int len2 = s2.length() ;

        if (len1 > len2){
            return false ;
        }

        int[] directory = new int[26] ;
        int[] cnt = new int[26] ;
        Arrays.fill(directory , 0);
        Arrays.fill(cnt , 0);

        for (int i = 0 ; i < len1 ; i++){
            directory[s1.charAt(i) - 'a']++ ;
            cnt[s2.charAt(i) - 'a']++ ;
        }

        // 数组之间可以直接比较
        if (Arrays.equals(directory , cnt)){
            return true ;
        }
        // 在s2中，对每一个长度为len1的字符串进行建表的对比
        // 滑动窗口的思路，每个窗口对应一个状态map
        for (int i = 1 ; i <= len2 - len1 ; i++){
            cnt[s2.charAt(len1 + i - 1) - 'a'] ++ ;
            cnt[s2.charAt(i - 1) - 'a']-- ;
            if (Arrays.equals(directory , cnt)){
                return true ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {
        _3_CheckInclusion obj = new _3_CheckInclusion() ;
        String s1 = "ab" ;
        String s2 = "eidboaoo" ;
        System.out.println(obj.checkInclusion(s1 , s2));
    }
}
