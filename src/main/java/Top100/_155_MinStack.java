import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 2021/09/15
 * 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * */
public class _155_MinStack {
    /*public List<Integer> num ;
    public int size ;
    /** initialize your data structure here. */
    /*public _155_MinStack() {
        num = new ArrayList<>() ;
        size = 0 ;
    }

    public void push(int val) {
        num.add(val) ;
        size++ ;
    }

    public void pop() {
        num.remove(size - 1) ;
        size-- ;
    }

    public int top() {
        return num.get(size - 1) ;
    }

    public int getMin() {
        int res = Integer.MAX_VALUE ;
        for (int i = 0 ; i < size ; i++){
            res = Math.min(res , num.get(i)) ;
        }
        return res ;
    }*/
    public Deque<Integer> stack ;
    public Deque<Integer> minStack ;
    /** initialize your data structure here. */
    public _155_MinStack() {
        stack = new LinkedList<>() ;
        minStack = new LinkedList<>() ;
        minStack.push(Integer.MAX_VALUE) ;
    }

    public void push(int val) {
        stack.push(val) ;
        minStack.push(Math.min(minStack.peek() , val)) ;
    }

    public void pop() {
        stack.pop() ;
        minStack.pop() ;
    }

    public int top() {
        return stack.peek() ;
    }

    public int getMin() {
        return minStack.peek() ;
    }
    public static void main(String[] args) {
        _155_MinStack obj = new _155_MinStack() ;
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        int param_1 = obj.getMin() ;
        obj.pop();
        int param_2 = obj.top() ;
        int param_3 = obj.getMin() ;
        obj.push(1);
    }
}
