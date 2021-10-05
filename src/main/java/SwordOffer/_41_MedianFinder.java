package SwordOffer;

import java.awt.*;
import java.util.*;

/**
 * 2021/10/05
 *
 * 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * */
public class _41_MedianFinder {
//    List<Integer> list ;
//    /** initialize your data structure here. */
//    public _41_MedianFinder() {
//        list = new ArrayList<>() ;
//    }
//
//    // 从数据流中添加一个整数到数据结构中
//    // 一定是在每个数字插入的时候保证有序
//    public void addNum(int num) {
//        list.add(num) ;
//        Collections.sort(list);
//    }
//
//    // 返回目前所有元素的中位数
//    public double findMedian() {
//        int len = list.size() ;
//        if (len % 2 != 0){// 奇数个数
//            return 1.0 * list.get((len - 1) / 2) ;
//        }else{// 偶数个数
//            return 1.0 * (list.get((len - 2) / 2) + list.get(len / 2)) / 2 ;
//        }
//    }
    // 建立一个小顶堆A和大顶堆B，各保存列表一般的元素
    Queue<Integer> A , B ;
    /** initialize your data structure here. */
    public _41_MedianFinder() {
        A = new PriorityQueue<>() ; // 小顶堆，保存较大的一般数字
        B = new PriorityQueue<>((x , y) -> (y - x));// 大顶堆，保存较小的一般数字
    }

    public void addNum(int num) {
        if (A.size() != B.size()){// 奇数
            A.add(num) ;
            B.add(A.poll()) ;
        }else{// 偶数
            B.add(num) ;
            A.add(B.poll()) ;
        }

    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0 ;
    }
    public static void main(String[] args) {
        _41_MedianFinder obj = new _41_MedianFinder() ;
        obj.addNum(1);
        obj.addNum(2);
        double param1 = obj.findMedian() ;
        obj.addNum(3);
        double param2 = obj.findMedian() ;
        System.out.println(param1 + "," +  param2);
    }
}
