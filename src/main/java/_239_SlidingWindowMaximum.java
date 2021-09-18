import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 2021/09/18
 * 滑动窗口的最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * */
public class _239_SlidingWindowMaximum {
    // 返回Nums数组从i位置开始，长度为k的的序列中的最大值
    private int getMax(int[] nums, int k, int i) {
        int max = Integer.MIN_VALUE ;

        for (int j = i ; j < i + k ; j++){
            max = Math.max(max , nums[j]) ;
        }
        return max ;
    }
    // 暴力解法，通过52/61样例
    // 返回每一步窗口内的最大值
    public int[] maxSlidingWindow_force(int[] nums, int k) {
        int n = nums.length ;
        // 窗口可以走几步？N-窗口长度，可以理解为左边界的移动距离
        int[] res = new int[n - k + 1] ;
        for (int i = 0 ; i < res.length ; i++){
            res[i] = getMax(nums , k , i) ;
        }
        return res ;
    }


    private int checkMax(int[] nums, int i, int k , int[] res) {
        if (res[i - 1] == nums[i - 1]){//之前的最大值被移除，重新判断
            return getMax(nums , k , i) ;
        }else{//否则直接比较
            return Math.max(res[i - 1] , nums[i + k - 1]) ;
        }
    }
    // 需要有一个记忆化的过程，每走一步看之前的最大值是否被移除，若没有返回原来最大值与当前新加入元素之间的最大值
    // 61/61，卡在最后一个样例
    public int[] maxSlidingWindow_memo(int[] nums, int k) {
        int n = nums.length ;

        if (k == 0 || n == 0){
            return new int[0] ;
        }
        // 窗口可以走几步？N-窗口长度，可以理解为左边界的移动距离
        int[] res = new int[n - k + 1] ;
        // 初始最大值
        res[0] = getMax(nums , k , 0) ;

        for (int i = 1 ; i < n - k + 1 ; i++){
            res[i] = checkMax(nums , i , k , res) ;
        }

        return res ;
    }

    // 双向队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ;

        if (n == 0 || n < 2){
            return nums ;
        }

        // 双向队列，保存当前窗口最大值的数组位置，保证队列中数组位置的数值按照从大到小排列
        LinkedList<Integer> queue = new LinkedList<>();

        // 结果数组
        int[] res = new int[n - k + 1] ;

        // 遍历nums数组
        for(int i = 0 ; i < n ; i++){
            // 保证从大到小排列，如果前面的更小，则弹出直到满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast() ;
            }
            // 保存当前值对应的数组下标
            queue.addLast(i);

            // 队首元素满足要求，判断队首的值的数组下标是否在 [L,R] 中，如果不在则需要弹出队首的值，当前窗口的最大值即为队首的数。
            if (queue.peek() <= i - k){// 不在则弹出
                queue.poll() ;
            }

            // 当窗口长度为k时，保存当前窗口中的最大值
            if (i + 1 >= k){
                res[i + 1 - k] = nums[queue.peek()];
            }
        }

        return res ;
    }

    public static void main(String[] args) {
        _239_SlidingWindowMaximum obj = new _239_SlidingWindowMaximum() ;
        int[] nums = {1,3,-1,-3,5,3,6,7} ;
        int k = 3 ;
        System.out.print(Arrays.toString(obj.maxSlidingWindow(nums, k)));
    }
}
