import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/6/24
 *
 * 试着用回溯法处理一下，分支限界，剪枝
 *
 * 需要注意的有两点：
 *  1. java ArrayList是浅拷贝，需要用res.add(new ArrayList<>(tmp)) ;的形式创建深拷贝
 *  2. 注意起始位置的设定
 **/
public class _39_CombinationSum {
    public void findtarget(int[] candidates ,int target, int start , List<Integer> tmp, List<List<Integer>> res){
        if(target < 0){
            return;
        }else if(target == 0){
            res.add(new ArrayList<>(tmp)) ;
        }else{
            for(int i = start ; i < candidates.length ; i++){
                tmp.add(candidates[i]) ;
                findtarget(candidates , target - candidates[i] , i , tmp , res);
                tmp.remove(tmp.get(tmp.size() - 1)) ;
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList();
        Arrays.sort(candidates);
        findtarget(candidates ,target, 0, tmp, res) ;

        return res ;
    }
    public static void main(String[] args) {
        _39_CombinationSum obj = new _39_CombinationSum() ;
        int[] candidates = {2,3,6,7} ;
        int target = 7 ;
        List<List<Integer>> res = obj.combinationSum(candidates, target) ;
        System.out.println(res);
    }
}
