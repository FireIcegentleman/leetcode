package All;

import SwordOffer._20_NumberCheck;

import java.util.HashSet;
import java.util.Stack;

/**
 * 2021/10/22
 *
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * */
public class _20_IsValid {
    // 有效的括号
    public Stack<Character> stack ;
    public boolean isValid(String s) {
        stack = new Stack<>() ;
        char[] charArray = s.toCharArray() ;
        for (char c : charArray){
            if (c == '[' || c == '(' ||c == '{'){
                stack.push(c) ;
            }else if (c == ']'){
                if (stack.isEmpty()){
                    return false ;
                }
                if (stack.peek() == '['){
                    stack.pop() ;
                }else{
                    return false ;
                }
            }else if (c == ')'){
                if (stack.isEmpty()){
                    return false ;
                }
                if (stack.peek() == '('){
                    stack.pop() ;
                }else{
                    return false ;
                }

            }else if (c == '}'){
                if (stack.isEmpty()){
                    return false ;
                }
                if (stack.peek() == '{'){
                    stack.pop() ;
                }else{
                    return false ;
                }

            }
        }

        return stack.isEmpty() ;
    }
    public static void main(String[] args) {
        _20_IsValid obj = new _20_IsValid() ;
        String str = "(})" ;
        System.out.println(obj.isValid(str));
    }
}
