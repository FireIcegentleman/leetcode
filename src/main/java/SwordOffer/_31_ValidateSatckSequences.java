package SwordOffer;

import java.util.Stack;

/**
 * 2021/10/06
 *
 * 栈的压入、弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * */
public class _31_ValidateSatckSequences {
    public Stack<Integer> s ;
    // 先压入栈的一定后弹出来
    // 模拟栈操作
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        s = new Stack<>() ;
        int i = 0 ;
        for (int num : pushed){
            s.push(num) ;
            while (!s.isEmpty() && s.peek() == popped[i]){
                s.pop() ;
                i++ ;
            }
        }
        return s.isEmpty() ;
    }
    public static void main(String[] args) {
        _31_ValidateSatckSequences obj = new _31_ValidateSatckSequences() ;
        int[] pushed = {1,2,3,4,5} ;
        int[] poped = {4,5,3,2,1} ;

        System.out.println(obj.validateStackSequences(pushed , poped));
    }
}
