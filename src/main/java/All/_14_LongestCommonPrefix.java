package All;

/**
 * 2021/10/21
 *
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * */
public class _14_LongestCommonPrefix {
    // 返回最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length ;
        int[] map = new int[26] ;

        StringBuilder res = new StringBuilder() ;

        int min_len = Integer.MAX_VALUE ;
        for (int i = 0 ; i < strs.length ; i++){
            min_len = Math.min(min_len , strs[i].length()) ;
        }

        for (int i = 0 ; i < min_len ; i++){
            for (int j = 0 ; j < size ; j++){
                map[strs[j].charAt(i) - 'a'] ++ ;
            }
            if (map[strs[0].charAt(i) - 'a'] % size == 0){
                res.append(strs[0].charAt(i)) ;
            }else{
                break;
            }
        }

        return res.toString() ;
    }
    public static void main(String[] args) {
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix() ;
        String[] strs = {"cir","car"} ;
        System.out.println(obj.longestCommonPrefix(strs));
    }
}
