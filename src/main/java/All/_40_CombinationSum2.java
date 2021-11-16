package All;

import java.util.*;

/**
 * 2021/11/12
 *
 * 组合总数II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。 
 * */
public class _40_CombinationSum2 {
    // 递归
    private List<List<Integer>> res ;
    private List<Integer> tmp ;
    // 找出所有可能使数字和为target的组合
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>() ;
        tmp = new ArrayList<>() ;

        if (candidates.length == 0){
            return res ;
        }

        Arrays.sort(candidates);

        findTarget(candidates , 0 , target) ;

        return res;
    }

    private void findTarget(int[] candidates, int index, int target) {
        if (target < 0){
            return;
        }else if(target == 0){
            res.add(new ArrayList<>(tmp)) ;
        }else{
            for (int i = index ; i < candidates.length ; i++){
                // 大剪枝
                if (target - candidates[i] < 0){
                    break;
                }

                if (i > index && candidates[i] == candidates[i - 1] ){
                    continue;
                }
                tmp.add(candidates[i]) ;
                findTarget(candidates , i + 1  , target - candidates[i]);
                tmp.remove(tmp.get(tmp.size() - 1)) ;
            }
        }
    }

    public static void main(String[] args) {
        _40_CombinationSum2 obj = new _40_CombinationSum2() ;
        int[] candidates = {3,1,3,5,1,1} ;
        int target = 8 ;

        List<List<Integer>> res = obj.combinationSum2(candidates , target) ;

        for (int i = 0 ; i < res.size() ; i++){
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }
}
