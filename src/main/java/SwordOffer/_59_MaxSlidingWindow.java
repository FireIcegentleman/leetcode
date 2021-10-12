package SwordOffer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 2021/10/11
 *
 * 滑动窗口的最大值
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * */
public class _59_MaxSlidingWindow {
    // 滑动窗口的最大值
    public int[] maxSlidingWindow_simple(int[] nums, int k) {
        int len = nums.length ;

        if (len < k || len == 0 || k == 0){
            return new int[0] ;
        }

        int[] res = new int[len - k + 1] ;
        // 在res中的索引
        int index = 0 ;
        // 每一轮窗口中的最大值
        int tmp = 0 ;
        boolean flag = false ; // 是否需要重选

        int left = 0 , right = 0 ;
        // 先找到第一个窗口中的最大值
        for ( ; right < k ; right++){
            if (nums[right] > nums[tmp]){
                tmp = right ;
            }
        }

        res[index++] = nums[tmp] ;
        if (tmp == left){
            flag = true ;
        }
        left++ ;
        right = left + k - 1 ;
        while (left < len - k + 1 && right < len){
            if (!flag){
                if (nums[tmp] < nums[right]){
                    tmp = right ;
                    res[index++] = nums[tmp] ;
                }else{
                    res[index++] = nums[tmp] ;
                }
            }else{// 需要重新选
                tmp = left ;
                for (int i = left + 1 ; i < left + k ; i++){
                    if (nums[i] > nums[tmp]){
                        tmp = i ;
                    }
                }
                res[index++] = nums[tmp] ;
            }
            if (tmp == left){// 需要重选
                flag = true ;
            }
            left++ ;
            right = left + k - 1 ;
        }
        return res ;
    }

    // 单调栈
    public int[] maxSlidingWindow(int[] nums, int k){
        int len = nums.length ;

        if (len < k || len == 0 || k == 0){
            return new int[0] ;
        }

        Deque<Integer> queue = new LinkedList<>() ;
        int[] res = new int[len - k + 1] ;

        for (int i = 0 ; i < k ; i++){
            while (!queue.isEmpty() && queue.peekLast() < nums[i]){
                queue.removeLast() ;
            }
            queue.addLast(nums[i]);
        }
        res[0] = queue.peekFirst() ;

        for (int i = k ; i < nums.length ; i++){
            if (queue.peekFirst() == nums[i - k]){// 被删除的这个数
                queue.removeFirst() ;
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[i]){
                queue.removeLast() ;
            }
            queue.addLast(nums[i]);
            res[i - k + 1] = queue.peekFirst() ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _59_MaxSlidingWindow obj = new _59_MaxSlidingWindow() ;
        int[] nums = {7,2,4} ;
        int k = 2 ;
        System.out.print(Arrays.toString(obj.maxSlidingWindow(nums, k)));
    }
}
