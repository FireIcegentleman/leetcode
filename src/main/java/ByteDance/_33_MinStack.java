package ByteDance;

import java.util.Stack;

/**
 * 2021/11/9
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * */
public class _33_MinStack {
    public Stack<Integer> stack ;
    public Stack<Integer> minstack ;
    public _33_MinStack() {
        stack = new Stack<>() ;
        minstack = new Stack<>() ;
    }

    public void push(int val) {
        stack.push(val) ;

        if (minstack.isEmpty()){
            minstack.push(val) ;
        }else{
            if (val < minstack.peek()){
                minstack.push(val) ;
            }else{
                minstack.push(minstack.peek()) ;
            }
        }
    }

    public void pop() {
        stack.pop() ;
        minstack.pop() ;
    }

    public int top() {
        return stack.peek() ;
    }

    public int getMin() {
        return minstack.peek() ;
    }

    public static void main(String[] args) {
        _33_MinStack obj = new _33_MinStack() ;
        obj.push(-2); ;
        obj.push(0) ;
        obj.push(-3) ;
        int param1 = obj.getMin() ;
        obj.pop();
        int param2 = obj.top() ;
        int param3 = obj.getMin() ;

        System.out.println(param1 + " " + param2 + " " + param3);
    }
}
