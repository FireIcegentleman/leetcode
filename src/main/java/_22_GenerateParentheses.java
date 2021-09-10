import java.util.LinkedList;
import java.util.List;

/**
 * 2021/2/10
 * leetcode 22
 * 回溯法 , 有参考
 *
 * Runtime: 1 ms, faster than 84.54% of Java online submissions for Generate Parentheses.
 * Memory Usage: 39.3 MB, less than 41.07% of Java online submissions for Generate Parentheses.
 * */
public class _22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>() ;
        String out = "" ;
        dfs(n, n , out , res) ;
        return res ;
    }

    private void dfs(int right , int left , String out, List<String> res) {
        if(left < right){
            return ;
        }
        if(right == 0 && left == 0){
            res.add(out) ;
        }else{
            if(left > 0){
                dfs(right , left - 1 , out + ")" , res) ;
            }
            if(right > 0){
                dfs(right - 1 , left , out + "(" , res) ;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3 ;
        _22_GenerateParentheses obj = new _22_GenerateParentheses() ;
        System.out.println(obj.generateParenthesis(n));
    }
}