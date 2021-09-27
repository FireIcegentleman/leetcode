import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * 2021/09/27
 *
 * 每日温度
 *
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * */
public class _739_DailyTemperatures {
    public int[] dailyTemperatures_force(int[] temperatures) {
        int n = temperatures.length ;
        int[] res = new int[n] ;
        res[n - 1] = 0 ;

        for (int i = 0 ; i < n ; i++){
            for (int j = i + 1 ; j < n ; j++){
                if (temperatures[j] > temperatures[i]){
                    res[i] = (j - i) ;
                    break;
                }
            }
        }

        return res ;
    }


    // 递减栈，栈里只有递减元素
    public int[] dailyTemperatures_stack(int[] temperatures) {
        int n = temperatures.length ;
        int[] res = new int[n] ;

        Stack<Integer> s = new Stack<>();
        for (int i = 0 ; i < n ; i++){
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int t = s.pop() ;
                res[t] = i - t ;
            }
            s.add(i) ;
        }
        return res ;
    }

    // 倒序遍历
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length ;
        int[] res = new int[n] ;

        for (int i = n - 2 ; i >= 0 ; i--){
            for (int j = i + 1 ; j < n ; j += res[j]){
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }else if(res[j] == 0){
                    res[j] = 0 ;
                    break ;
                }
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        _739_DailyTemperatures obj = new _739_DailyTemperatures() ;
        int[] temperatures = {73,74,75,71,69,72,76,73} ;
        System.out.println(Arrays.toString(obj.dailyTemperatures(temperatures)));
    }
}
