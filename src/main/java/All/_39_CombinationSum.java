package All;

import io.ipfs.multibase.BinaryDecoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/11/12
 *
 * 组合总数
 *
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 * */
public class _39_CombinationSum {
    // 递归
    private List<List<Integer>> res ;
    private List<Integer> tmp ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>() ;
        // 记录每轮的结果
        tmp = new ArrayList<>() ;
        // 数组排序
        Arrays.sort(candidates);

        findTarget(candidates , 0 , target) ;

        return res ;
    }

    private void findTarget(int[] candidates, int index , int target) {
        // 如果当前递归到target为0，则
        if (target < 0){
            return;
        }else if (target == 0){
            res.add(new ArrayList<>(tmp)) ;
        }else{
            for (int i = index ; i < candidates.length ; i++){
                // 在这里做一个剪枝
                if (target - candidates[i] < 0){
                    break;
                }
                tmp.add(candidates[i]) ;
                findTarget(candidates , i , target - candidates[i]);
                tmp.remove(tmp.get(tmp.size() - 1)) ;
            }
        }
    }

    public static void main(String[] args) {
        _39_CombinationSum obj = new _39_CombinationSum() ;
        int[] candidates = {2,3,6,7} ;
        int target = 7 ;

        List<List<Integer>> res = obj.combinationSum(candidates , target) ;

        for (int i = 0 ; i < res.size() ; i++){
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println();
        }

    }
}
/**
 * 什么时候使用 used 数组，什么时候使用 begin 变量
 * 有些朋友可能会疑惑什么时候使用 used 数组，什么时候使用 begin 变量。这里为大家简单总结一下：
 *
 * 排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
 * 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
 * */
