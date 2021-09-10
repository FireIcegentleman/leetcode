import java.util.*;

/**
 * 2021/1/19
 * leetcode 3
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Runtime: 628 ms, faster than 5.02% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 39.7 MB, less than 29.47% of Java online submissions for Longest Substring Without Repeating Characters.
 */
public class _3_LongestSubstringWithoutRepeatingCharacters{
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0 ;
        }
        int max_length ;
        int tmp_length = 1 ;
        max_length = tmp_length ;

        // 以每个字母开头计算最长不包含非重复字符的字串数目，知道最后一个字符，找到最长的
        for(int i = 0 ; i < s.length() ; i++){
            tmp_length = 1 ;
            // 1.如何创建可增减的数组
            ArrayList<Character> store = new ArrayList<Character>() ;
            store.add(s.charAt(i)) ;
            for(int j = i + 1 ; j < s.length() ; j++){
                // 查询是否已被包含
                if(!store.contains(s.charAt(j))){
                    store.add(s.charAt(j)) ;
                    tmp_length ++ ;
                    if(tmp_length > max_length){
                        max_length = tmp_length ;
                    }
                }else{
                    break ;
                }
            }
        }

        return max_length ;
    }

    public static void main(String[] args) {
        String s ;
        s = "" ;
        _3_LongestSubstringWithoutRepeatingCharacters longest = new _3_LongestSubstringWithoutRepeatingCharacters() ;
        System.out.println(longest.lengthOfLongestSubstring(s)) ;

    }
}
/**
 * 示例程序 : Sliding Window
 * public class Solution {
 *     public int lengthOfLongestSubstring(String s) {
 *         int n = s.length();
 *         Set<Character> set = new HashSet<>();
 *         int ans = 0, i = 0, j = 0;
 *         while (i < n && j < n) {
 *             // try to extend the range [i, j]
 *             if (!set.contains(s.charAt(j))){
 *                 set.add(s.charAt(j++));
 *                 ans = Math.max(ans, j - i);
 *             }
 *             else {
 *                 set.remove(s.charAt(i++));
 *             }
 *         }
 *         return ans;
 *     }
 * }
 * */