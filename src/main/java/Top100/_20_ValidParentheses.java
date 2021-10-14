import java.util.Stack;

/**
 * 2021/2/8
 * leetcode 20
 * Runtime: 1 ms, faster than 98.66% of Java online submissions for Valid Parentheses.
 * Memory Usage: 37.2 MB, less than 61.80% of Java online submissions for Valid Parentheses.
 * */
public class _20_ValidParentheses {
    public boolean isValid(String s) {
        boolean res = false ;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if(stack.empty()){
                    return false ;
                }
                char tmp = stack.peek();
                if (tmp == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if(stack.empty()){
                    return false ;
                }
                char tmp = stack.peek();
                if (tmp == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if(stack.empty()){
                    return false ;
                }
                char tmp = stack.peek();
                if (tmp == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "()[]{}" ;
        _20_ValidParentheses obj = new _20_ValidParentheses() ;
        System.out.println(obj.isValid(s));
    }
}
