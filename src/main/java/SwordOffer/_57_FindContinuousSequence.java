package SwordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2021/10/10
 *
 * 和为s的连续正数序列
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 双指针 small、big，之间的和大于target则small++ ， 小于则big++
 * 等于则记录
 * */
public class _57_FindContinuousSequence {
    // 和为s的连续整数序列
    public int[][] findContinuousSequence(int target) {
        if (target <= 2){
            return new int[0][2] ;
        }
        List<List<Integer>> res = new ArrayList<>() ;
        List<Integer> tmp = new ArrayList<>() ;

        int small = 1 ;
        int big = 2 ;

        int sum = 3 ;

        while (small < (1 + target) / 2 && big <= target){
            if (sum < target){
                big++ ;
                sum += (big) ;
            }else if(sum > target){
                sum -= (small) ;
                small++ ;
            }else{
                for (int i = small ; i <= big ; i++){
                    tmp.add(i) ;
                }
                res.add(new ArrayList<>(tmp));
                sum -= small ;
                small++ ;
                tmp.clear();
            }
        }
        int[][] res_arr = new int[res.size()][] ;

        for (int i = 0 ; i < res.size() ; i++){
            int[] tmp_arr = new int[res.get(i).size()] ;
            for (int j = 0 ; j < res.get(i).size() ; j++){
                tmp_arr[j] = res.get(i).get(j) ;
            }
            res_arr[i] = tmp_arr ;
        }
        return res_arr ;
    }
    public static void main(String[] args) {
        _57_FindContinuousSequence obj = new _57_FindContinuousSequence() ;
        int target = 15 ;
        int[][] res = obj.findContinuousSequence(target);
        for (int i = 0 ; i < res.length ; i++){
            System.out.print("[");
            for (int j = 0 ; j < res[i].length ; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
