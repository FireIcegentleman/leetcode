import java.util.*;

/**
 * 2021/6/27
 *
 * 还是回溯法，不过每个数字只能被使用一次
 *
 * 只需要调整起始索引就好了
 * */
public class _40_CombinationSumII {
    private void dfs(int[] candidates, List<List<Integer>> res, int start, List<Integer> out, int target) {
        if(target < 0){
            return ;
        }
        else if(target == 0){
            res.add(new ArrayList<Integer>(out)) ;
        }else{
            for(int j = start ; j < candidates.length ; j++){
                out.add(candidates[j]) ;
                dfs(candidates , res , j + 1, out , target-candidates[j]);
                out.remove(out.get(out.size() - 1)) ;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>() ;
        dfs(candidates , res , 0 , out , target) ;
        Set<List<Integer>> tmp = new HashSet<>() ;
        for(List<Integer> l : res){
            tmp.add(l) ;
        }
        List<List<Integer>> result = new ArrayList<>();
        Iterator it = tmp.iterator();
        while(it.hasNext()){
            result.add((List<Integer>) it.next()) ;
        }
        return result ;
    }


    public static void main(String[] args) {
        _40_CombinationSumII obj = new _40_CombinationSumII() ;
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8 ;
        System.out.println(obj.combinationSum2(candidates,target));
    }
}
