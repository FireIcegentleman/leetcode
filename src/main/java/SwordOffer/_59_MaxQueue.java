package SwordOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 2021/10/11
 *
 * 队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * */
public class _59_MaxQueue {
    // 均摊时间复杂度为O(1)，以空间换取时间
    public Deque<Integer> queue ;
    public Deque<Integer> maxValue ;
    public int max ;

    public _59_MaxQueue() {
        queue = new ArrayDeque<>() ;
        maxValue= new LinkedList<>() ;
    }

    public int max_value() {
        if (maxValue.isEmpty()){
            return -1 ;
        }
        return maxValue.peekFirst() ;
    }

    public void push_back(int value) {
        queue.addLast(value);
        while (!maxValue.isEmpty() && maxValue.peekLast() < value){
            maxValue.removeLast() ;
        }
        maxValue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1 ;
        }
        int value = queue.pollFirst() ;

        if (!maxValue.isEmpty() && value == maxValue.peekFirst()){
            maxValue.removeFirst() ;
        }
        return value ;
    }

    public static void main(String[] args) {
        _59_MaxQueue obj = new _59_MaxQueue() ;
        obj.push_back(1);
        obj.push_back(2);
        int param1 = obj.max_value() ;
        System.out.println(param1);

        int param2 = obj.pop_front() ;
        System.out.println(param2);

        int param3 = obj.max_value() ;
        System.out.println(param3);
    }
}
