import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 2021/6/27
 * 给定一个无序数组，找到最小丢失的正整数
 * Runtime: 177 ms, faster than 5.02% of Java online submissions for First Missing Positive.
 * Memory Usage: 158.6 MB, less than 5.15% of Java online submissions for First Missing Positive.
 * */
public class _41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // 数组去重
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int m = 0 ;
        int[] num = new int[set.size()] ;
        for(Iterator iterator = set.iterator(); iterator.hasNext();){
            num[m] = (int)iterator.next();
            m++;
        }
        Arrays.sort(num);// 对数组进行排序
        if(num[0] > 1){
            return 1 ;
        }else{
            int[] positive = new int[num.length] ;
            int i = 0 , j = 0 ;
            while(num[i] <= 0 && i < num.length - 1){
                i++ ;
            }
            int pos_num = i ;
            // 将正整数部分拷贝过来
            while (i < num.length){
                positive[j++] = num[i++] ;
            }
            for(j = 0 ; j < num.length - pos_num ;  j++){
                if(positive[j] != j + 1){
                    return j + 1 ;
                }
            }
            return positive[num.length - pos_num - 1] + 1 ;
        }
    }

    public static void main(String[] args) {
        _41_FirstMissingPositive obj = new _41_FirstMissingPositive() ;
        int[] nums = {0,2,2,1,1};
        System.out.println(obj.firstMissingPositive(nums));
    }
}
