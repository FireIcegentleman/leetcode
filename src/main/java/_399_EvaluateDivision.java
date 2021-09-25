import java.util.*;

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
    // 在并查集的 合并 与 查询 操作中维护变量之间的倍数关系
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size() ;

        // 创建并查集
        UnionFind unionFind = new UnionFind(2 * equationsSize) ;

        // 第一步：预处理，将变量的值与id进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String , Integer> hashMap = new HashMap<>(2 * equationsSize) ;
        int id = 0 ;
        for (int i = 0 ; i < equationsSize ; i++){
            List<String> equation = equations.get(i) ;
            String var1 = equation.get(0) ;
            String var2 = equation.get(1) ;

            if (!hashMap.containsKey(var1)){
                hashMap.put(var1 , id) ;
                id++ ;
            }

            if (!hashMap.containsKey(var2)){
                hashMap.put(var2 , id) ;
                id++ ;
            }
            unionFind.union(hashMap.get(var1) , hashMap.get(var2) , values[i]);
        }

        // 第二步：做查询
        int queriesSize = queries.size() ;
        double[] res = new double[queriesSize] ;

        for (int i = 0 ; i < queriesSize ; i++){
            String var1 = queries.get(i).get(0) ;
            String var2 = queries.get(i).get(1) ;

            Integer id1 = hashMap.get(var1) ;
            Integer id2 = hashMap.get(var2) ;

            if (id1 == null || id2 == null){
                res[i] = -1.0d ;
            }else{
                res[i] = unionFind.isConnected(id1 , id2) ;
            }
        }
        return res ;

    }
    // 并查集类
    private class UnionFind{
        private int[] parent ;

        /**
         * 指向父节点的权重值
         * */
        private double[] weight ;

        public UnionFind(int n){
            this.parent = new int[n] ;
            this.weight = new double[n] ;

            for (int i = 0 ; i < n ; i++){
                parent[i] = i ;
                weight[i] = 1.0d ;
            }
        }

        public void union(int x , int y , double value){
            int rootX = find(x) ;
            int rootY = find(y) ;
            if (rootX == rootY){
                return;
            }

            parent[rootX] = rootY ;

            // 关系式的推导见示意图
            weight[rootX] = weight[y] * value / weight[x] ;
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return 根节点id
         * */
        private int find(int x) {
            if (x != parent[x]){
                int origin = parent[x] ;
                parent[x] = find(parent[x]) ;
                weight[x] *= weight[origin] ;
            }
            return parent[x] ;
        }

        public double isConnected(int x , int y){
            int rootX = find(x) ;
            int rootY = find(y) ;
            if (rootX == rootY){
                return weight[x] / weight[y] ;
            }else{
                return -1.0d ;
            }
        }
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
