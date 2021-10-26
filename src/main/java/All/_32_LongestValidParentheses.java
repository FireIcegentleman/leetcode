package All;

import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * 2021/10/25
 *
 * 最长有效括号
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * */
public class _32_LongestValidParentheses {
    // 找出最长有效括号字串的长度
    // 需要连续
    // 始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
    public int longestValidParentheses_stack(String s) {
        char[] charArray = s.toCharArray() ;

        if (charArray.length == 0){
            return 0 ;
        }

        int res = 0 ;

        // 保存待处理的'('
        Stack<Integer> stack = new Stack<>() ;
        stack.push(-1) ;

        for (int i = 0 ; i < charArray.length ; i++){
            if (charArray[i] == '('){
                stack.push(i) ;
            }else{
                stack.pop() ;
                if (stack.empty()){
                    // 最后一个未被处理的右括号索引
                    stack.push(i) ;
                }else{
                    res = Math.max(res , i - stack.peek()) ;
                }
            }
        }

        return res ;
    }

    // 动态规划
    // 最值型动态规划问题
    public int longestValidParentheses(String s) {
        int res = 0 ;
        int len = s.length() ;
        int[] dp = new int[len] ;

        for (int i = 1 ; i < len ; i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] = 2 ;
                    if (i - 2 >= 0){
                        dp[i] = dp[i] + dp[i - 2] ;
                    }
                }else if (dp[i - 1] > 0){
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        dp[i] = dp[i - 1] + 2 ;
                        if (i - dp[i - 1] - 2 >= 0){
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2] ;
                        }
                    }
                }
            }
            res = Math.max(res , dp[i]) ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _32_LongestValidParentheses obj = new _32_LongestValidParentheses() ;
        String s = "()(()" ;
        System.out.println(obj.longestValidParentheses(s));
    }
}
