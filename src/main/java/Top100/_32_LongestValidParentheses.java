import java.util.Stack;

/**
 * 2021/6/8
 * 寻找最长的合法括号数
 *
 * 对每一个可能的长度的字符串进行计算。
 *
 * 合法括号数必须连续可用
 */
public class _32_LongestValidParentheses {
    // 题目好像不是这个意思。。。
    /*public int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0 ;
        }
        int res =0 ;
        // 使用栈的数据结构，遍历数组将左括号压栈，遇到右括号则弹栈，若为“（”则计数器加1
        Stack<Character> stack = new Stack<>() ;
        char top ;
        stack.push('#') ;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                stack.push('(') ;
            }else if(s.charAt(i) == ')'){
                top = stack.peek() ;
                if(top == '('){
                    res += 2 ;
                    stack.pop() ;
                }
            }
        }
        return res ;
    }*/
    // 蛮力法，时间爆了
    /*public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }*/
    // 栈
    public int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0 ;
        }
        int res = 0 ;

        Stack<Integer> stack = new Stack<>() ;
        stack.push(-1) ;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                stack.push(i) ;
            }else{// ')'
                stack.pop() ;
                if(stack.empty()){
                    stack.push(i) ;
                }else{
                    res = Math.max(res , i - stack.peek()) ;
                }
            }
        }
        return res ;
    }

    // 附上动态规划的解法
    /*public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
    * */
    public static void main(String[] args) {
        _32_LongestValidParentheses obj = new _32_LongestValidParentheses() ;
        String s =  ")()())" ;
        System.out.println(obj.longestValidParentheses(s));
    }
}
