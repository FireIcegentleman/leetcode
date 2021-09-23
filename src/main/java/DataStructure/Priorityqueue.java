package DataStructure;

import java.util.PriorityQueue;

/**
 * Java中PriorityQueue通过二叉小顶堆实现，可以用一棵完全二叉树表示。
 *
 * 优先队列的作用是能保证每次去除的元素都是队列中权值最小的，元素的大小评判可以通过元素本身的自然顺序，也可以通过构造时传入的比较器
 * */
public class Priorityqueue {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue() ;
        // add() offer()方法作用相同，都是向优先队列中插入元素
        // 只是Queue接口规定二者对插入失败时的处理不同，前者在插入失败时抛出异常，后则则会返回false。对于PriorityQueue这两个方法其实没什么差别。
        queue.offer(1) ;
        queue.add(1) ;

        // element() peek()方法作用相同，都是获取但不删除队首元素，即最小元素
        // 也就是队列中权值最小的那个元素，二者唯一的区别是当方法失败时前者抛出异常，后者返回null
        queue.element() ;
        queue.peek() ;

        // remove() poll()方法作用相同，都是获取并删除队首元素
        queue.remove() ;
        queue.poll() ;
    }
}
