package All;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021/10/23
 *
 * 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * */
public class _22_GenerateParenthesis {
    public List<String> res ;
    // dfs
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>() ;
        // 深度优先遍历
        dfs(new StringBuilder() , n , 0 , 0) ;
        return res ;
    }

    // n为要求的括号长度，left目前有的左括号长度
    private void dfs(StringBuilder cur, int n , int left , int right) {
        if (left == n && right == n){
            res.add(cur.toString()) ;
        }

        if (left < n){
            dfs(cur.append("(") , n , left + 1 , right);
            cur.deleteCharAt(cur.length() - 1) ;
        }

        if (right < left){
            dfs(cur.append(")") , n , left , right + 1);
            cur.deleteCharAt(cur.length() - 1) ;
        }
    }

    public static void main(String[] args) {
        _22_GenerateParenthesis obj = new _22_GenerateParenthesis() ;
        int n = 8 ;
        List<String> res = obj.generateParenthesis(n) ;

        for (int i = 0 ; i < res.size() ; i++){
            System.out.println(res.get(i));
        }
    }
}
