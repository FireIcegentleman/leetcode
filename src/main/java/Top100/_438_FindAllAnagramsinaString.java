import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 2021/09/25
 * 找到字符串中所有字母异位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指字母相同，但排列不同的字符串。
 *
 * */
public class _438_FindAllAnagramsinaString {
    // 找到s中所有p的异位词的子串，返回这些子串的起始索引
    public List<Integer> findAnagrams_memory(String s, String p) {
        List<Integer> res = new ArrayList<>() ;

        int m = s.length() ;
        int n = p.length() ;

        if (m < n){
            return res ;
        }
        char[] s_char = s.toCharArray() ;
        char[] p_char = p.toCharArray() ;

        int[] p_hash = new int[26] ;
        Arrays.fill(p_hash , 0);

        // p字符串对应的哈希表
        for (int i = 0 ; i < p.length() ; i++){
            p_hash[p_char[i] - 'a'] ++ ;
        }

        int len = s.length() - p.length() + 1;
        int[][] s_hash = new int[len][26] ;
        for (int i = 0 ; i < len ; i++){
            for (int j = i ; j < i + p.length() ; j++){
                s_hash[i][s_char[j] - 'a'] ++ ;
            }
        }

        for (int i = 0 ; i < s_hash.length ; i++){
            if (Arrays.equals(s_hash[i] , p_hash)){
                res.add(i) ;
            }
        }
        return res ;
    }

    // 滑动窗口解法
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>() ;
        int[] p_hash = new int[26] ;
        char[] s_char = s.toCharArray() ;
        char[] p_char = p.toCharArray() ;
        int m = s.length() ;
        int n = p.length() ;

        if (m < n){
            return res ;
        }

        // p字符串对应的哈希表
        for (int i = 0 ; i < p.length() ; i++){
            p_hash[p_char[i] - 'a'] ++ ;
        }

        int l = 0 , r = 0 ;

        while (l <= m - n){
            // 此处右移，如果r没有超过l+p的长度，并且在数组p_hash里这个值不为空
            while(r < l + n && p_hash[s_char[r] - 'a'] > 0){
                p_hash[s_char[r] - 'a'] -- ;
                r++ ;
            }
            if (r == l + n){
                res.add(l) ;
            }

            p_hash[s_char[l] - 'a'] ++ ;
            l++ ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _438_FindAllAnagramsinaString obj = new _438_FindAllAnagramsinaString() ;
        String s = "abab" ;
        String p = "ab" ;

        List<Integer> res = obj.findAnagrams(s , p) ;
        for (int i = 0 ; i < res.size() ; i++){
            System.out.println(res.get(i) + ",");
        }
    }
}
