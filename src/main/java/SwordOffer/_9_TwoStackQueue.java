package SwordOffer;


/**
 * 2021/09/27
 *
 * 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * */
public class _9_TwoStackQueue {

    public _9_TwoStackQueue() {

    }

    public void appendTail(int value) {

    }

    public int deleteHead() {
        return 0 ;
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
