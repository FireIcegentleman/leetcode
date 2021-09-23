import java.util.*;

/**
 * 2021/09/22
 *
 * 前K个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * */
public class _347_TopKFrequentElements {
    // 返回前k高频的数字
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length ;
        int[] res = new int[k] ;

        Map<Integer , Integer> map = new HashMap<>() ;
        for (int num : nums){
            if (map.containsKey(num)){// 有则个数+1
                map.put(num , map.get(num) + 1) ;
            }else{
                map.put(num , 1) ;
            }
        }

        // 优先队列，内部使用了堆排序的思想
        PriorityQueue<int []> queue = new PriorityQueue<int []>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1] ;
            }
        }) ;

        // int[]的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            int num = entry.getKey() , count = entry.getValue() ;
            if (queue.size() == k){
                if (queue.peek()[1] < count){
                    queue.poll() ;
                    queue.offer(new int[]{num , count}) ;
                }
            }else{
                queue.offer(new int[]{num , count}) ;
            }
        }

        for (int i = 0 ; i < k ; i++){
            res[i] = queue.poll()[0] ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _347_TopKFrequentElements obj = new _347_TopKFrequentElements() ;
        int[] nums = {1 ,1  , 1 , 2 , 2 , 3} ;
        int k = 2 ;
        System.out.println(Arrays.toString(obj.topKFrequent(nums, k)));
    }
}
