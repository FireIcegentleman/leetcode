import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/09/23
 *
 * 除法求值
 *
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。
 * 每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * */
public class _399_EvaluateDivision {
    // 并查集
    // equations是除法式子，value是对应的值。前两个是条件，根据条件求解queries中的答案
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int m = equations.size() ;
        int n = queries.size() ;

        double[] res = new double[n] ;

        return res ;
    }
    public static void main(String[] args) {
        _399_EvaluateDivision obj = new _399_EvaluateDivision() ;
        List<List<String>> equations = new ArrayList<>() ;
        List<String> e1 = new ArrayList<>() ;
        e1.add("a") ;
        e1.add("b") ;
        equations.add(e1) ;

        List<String> e2 = new ArrayList<>() ;
        e2.add("b") ;
        e2.add("c") ;
        equations.add(e2) ;

        List<String> e3 = new ArrayList<>() ;
        e1.add("bc") ;
        e1.add("cd") ;
        equations.add(e1) ;

        double[] values = {1.5,2.5,5.0} ;

        List<List<String>> queries = new ArrayList<>() ;
        List<String> q1 = new ArrayList<>() ;
        q1.add("a") ;
        q1.add("c") ;
        queries.add(q1) ;

        List<String> q2 = new ArrayList<>() ;
        q2.add("c") ;
        q2.add("b") ;
        queries.add(q2) ;

        List<String> q3 = new ArrayList<>() ;
        q3.add("bc") ;
        q3.add("cd") ;
        queries.add(q3) ;

        List<String> q4 = new ArrayList<>() ;
        q4.add("cd") ;
        q4.add("bc") ;
        queries.add(q4) ;

        System.out.println(Arrays.toString(obj.calcEquation(equations, values, queries)));
    }
}
