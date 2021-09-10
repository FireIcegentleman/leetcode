import java.util.ArrayList;
import java.util.List;

/**
 * 2021/2/4
 * leetcode 17
 * 回溯法，我认为核心的地方在于对每一个添加进的字符需要在补充所有相关结果后弹出
 * 本质是宽度优先遍历
 * Runtime: 4 ms, faster than 45.88% of Java online submissions for Letter Combinations of a Phone Number.
 * Memory Usage: 39.2 MB, less than 38.43% of Java online submissions for Letter Combinations of a Phone Number.
 * */
public class _17_LetterCombinationsOfAPhoneNumber {
    public String[] nums ;
    public void init(){
        nums = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
    public List<String> letterCombinations(String digits) {
        init() ;
        if(digits.length() == 0){
            return new ArrayList<>() ;
        }
        List<String> res = new ArrayList<>();
        dfs(digits , nums , 0 , "" , res) ;
        return res ;
    }

    private void dfs(String digits, String[] nums, int level , String out, List<String> res) {
        if(level == digits.length()){
            res.add(out) ;
        }else{
            String str = nums[(digits.charAt(level)-'2')];

            for(int i = 0 ; i < str.length() ; i++){
                out += str.charAt(i) ;
                dfs(digits , nums , level + 1 , out , res) ;
                // remove the last character
                out = out.substring(0 , out.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23" ;
        _17_LetterCombinationsOfAPhoneNumber obj = new _17_LetterCombinationsOfAPhoneNumber() ;
        System.out.println(obj.letterCombinations(digits));
    }
}
/**
 * 示例代码，有数据结构上的不同，时间复杂度有所改进
 * class Solution {
 *     public List<String> letterCombinations(String digits) {
 *         List<String> list = new LinkedList<>();
 *         if(digits == null || digits.length() == 0) return list;
 *         char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
 *         backtrack(digits,list,map,new StringBuilder(),0);
 *         return list;
 *     }
 *     private void backtrack(String digits, List<String> list,char[][] map, StringBuilder sb, int start){
 *         if(start == digits.length()) {
 *             list.add(new String(sb));
 *             return;
 *         }
 *         int num = digits.charAt(start) - '0';
 *         for(int i = 0;i< map[num].length;i++){
 *             sb.append(map[num][i]);
 *             backtrack(digits,list,map,sb,start+1);
 *             sb.deleteCharAt(sb.length() - 1);
 *         }
 *     }
 * }
 * */