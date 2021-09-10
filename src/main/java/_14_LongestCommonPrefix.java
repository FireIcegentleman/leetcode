/**
 * 2021/2/3
 * leetcode 14
 * Runtime: 9 ms, faster than 12.69% of Java online submissions for Longest Common Prefix.
 * Memory Usage: 39.4 MB, less than 6.40% of Java online submissions for Longest Common Prefix.
 * */
public class _14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res = "" ;
        if(strs.length == 0){
            return "" ;
        }else if(strs.length == 1){
            return strs[0] ;
        }
        int index = 0 ;
        boolean flag ;
        for(int i = 0 ; i < strs[0].length() ; i++){
            flag = true ;
            char tmp = strs[0].charAt(index) ;
            for(int j = 0 ; j < strs.length ; j++){
                if(index == strs[j].length()){
                    return res ;
                }
                if(strs[j].charAt(index) != tmp){
                    flag = false ;
                }
            }
            if(flag == true){
                res += strs[0].charAt(index) ;
                index ++ ;
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        String[] s = {"ab", "a"} ;
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix() ;
        System.out.println(obj.longestCommonPrefix(s));
    }
}
/**
 * 使用暴力解法，技术含量不高
 * 下述例子使用了二分查找的方法
 * class Solution {
 *     public String longestCommonPrefix(String[] strs) {
 *         if (strs == null || strs.length == 0) {
 *             return "";
 *         }
 *         int minLength = Integer.MAX_VALUE;
 *         for (String str : strs) {
 *             minLength = Math.min(minLength, str.length());
 *         }
 *         int low = 0, high = minLength;
 *         while (low < high) {
 *             int mid = (high - low + 1) / 2 + low;
 *             if (isCommonPrefix(strs, mid)) {
 *                 low = mid;
 *             } else {
 *                 high = mid - 1;
 *             }
 *         }
 *         return strs[0].substring(0, low);
 *     }
 *
 *     public boolean isCommonPrefix(String[] strs, int length) {
 *         String str0 = strs[0].substring(0, length);
 *         int count = strs.length;
 *         for (int i = 1; i < count; i++) {
 *             String str = strs[i];
 *             for (int j = 0; j < length; j++) {
 *                 if (str0.charAt(j) != str.charAt(j)) {
 *                     return false;
 *                 }
 *             }
 *         }
 *         return true;
 *     }
 * }
 * Runtime: 3 ms, faster than 27.87% of Java online submissions for Longest Common Prefix.
 * Memory Usage: 38.5 MB, less than 35.20% of Java online submissions for Longest Common Prefix.
 * */