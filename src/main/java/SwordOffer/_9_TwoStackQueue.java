package SwordOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 2021/09/28
 *
 * 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * */
public class _9_TwoStackQueue {
    /*public Stack<Integer> s_front ;
    public Stack<Integer> s_back ;
    public _9_TwoStackQueue() {
        s_front = new Stack<>() ;
        s_back = new Stack<>() ;
    }

    public void appendTail(int value) {
        int tmp = 0 ;
        while (!s_back.isEmpty()){
            tmp = s_back.pop() ;
            s_front.push(tmp) ;
        }
        s_front.push(value) ;
    }

    public int deleteHead(){
        int tmp = 0 ;
        while (!s_front.isEmpty()){
            tmp = s_front.pop() ;
            s_back.push(tmp) ;
        }

        if (s_back.isEmpty()){
            return -1 ;
        }else{
            return s_back.pop() ;
        }
    }*/
    public Deque<Integer> s_front ;
    public Deque<Integer> s_back ;

    public _9_TwoStackQueue() {
        s_front = new LinkedList<>() ;
        s_back = new LinkedList<>() ;
    }

    public void appendTail(int value) {
        s_front.push(value);
    }

    public int deleteHead(){
        if (s_back.isEmpty()){
            while (!s_front.isEmpty()){
                s_back.push(s_front.pop());
            }
        }

        if (s_back.isEmpty()){
            return  -1 ;
        }else{
            return s_back.pop() ;
        }
    }
    public static void main(String[] args) {
        _9_TwoStackQueue obj = new _9_TwoStackQueue();
        obj.appendTail(3);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
        int param_3 = obj.deleteHead() ;
        System.out.println(param_3);
    }
}
