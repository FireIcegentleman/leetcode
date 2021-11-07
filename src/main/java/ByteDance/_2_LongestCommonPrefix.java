package ByteDance;

import java.util.StringJoiner;

/**
 * 2021/10/28
 *
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 **/
public class _2_LongestCommonPrefix {
    // 求解字符数组的最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder() ;
        // 最短单词
        int min_len = Integer.MAX_VALUE ;
        int length = strs.length ;

        for (String s : strs){
            min_len = Math.min(min_len , s.length());
        }

        // 对于最短单词中的每一个位置上的字符，进行搜索
        for (int i = 0 ; i < min_len ; i++){
            int tmp = 0 ;
            for (int j = 0 ; j < length ; j++){
                if (strs[j].charAt(i) == strs[0].charAt(i)){
                    tmp++ ;
                }else{
                    break;
                }
            }
            if (tmp == length){
                res.append(strs[0].charAt(i)) ;
            }else{
                break;
            }
        }
        return res.toString() ;
    }

    public static void main(String[] args) {
        _2_LongestCommonPrefix obj = new _2_LongestCommonPrefix() ;
        String[] strs = {"dog","racecar","car"} ;
        String res = obj.longestCommonPrefix(strs) ;
        System.out.println(res);
    }
}
