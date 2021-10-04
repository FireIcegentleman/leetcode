package SwordOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2021/10/04
 *
 * 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * */
public class _30_MinStack {
    Deque<Integer> s ;
    Deque<Integer> min_s ;

    /** initialize your data structure here. */
    public _30_MinStack() {
        s = new ArrayDeque<>() ;
        min_s = new ArrayDeque<>() ;
        min_s.addFirst(Integer.MAX_VALUE);
    }

    public void push(int x) {
        s.addFirst(x);
        min_s.addFirst(Math.min(min_s.peekFirst() , x));
    }

    public void pop() {
        s.pollFirst() ;
        min_s.pollFirst() ;
    }

    public int top() {
        return s.peekFirst() ;
    }

    public int min() {
        return min_s.peekFirst() ;
    }

    public static void main(String[] args) {
        _30_MinStack obj = new _30_MinStack() ;
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int param_1 = obj.min() ;
        obj.pop();
        int param_2 = obj.top() ;
        int param_3 = obj.min() ;
    }
}
