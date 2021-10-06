package SwordOffer;

import java.util.*;

/**
 * 2021/10/06
 *
 * 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * DFS
 * */
public class _38_Permutation {
    // 输入一个字符串，打印出该字符串中字符的所有排列。
    // 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//    public String[] permutation_(String s) {
//        List<String> res = new ArrayList<>() ;
//        boolean[] visited = new boolean[s.length()] ;
//        for (int i = 0 ; i < s.length() ; i++){
//            dfs_(i , "" , s , visited , res) ;
//            Arrays.fill(visited , false);
//        }
//        int len = res.size() ;
//        String[] result = new String[len] ;
//        for (int i = 0 ; i < len ; i++){
//            result[i] = res.get(i) ;
//        }
//        return result ;
//    }
//
//    private void dfs_(int i, String cur, String s , boolean[] visited, List<String> res) {
//        if (i < 0 || i >= s.length()){
//            return;
//        }
//
//        if (cur.length() == s.length()){
//            res.add(cur) ;
//        }
//        // 无法做到后半部分的前序
//        // 需要交换
//        if (!visited[i]){
//            visited[i] = true ;
//            cur += s.charAt(i) ;
//
//            dfs(i - 1 , cur , s , visited , res);
//            dfs(i + 1 , cur , s , visited , res);
//            visited[i] = false ;
//        }
//
//    }

    List<String> list ;
    char[] c ;
    public String[] permutation(String s) {
        list = new ArrayList<>() ;
        c = s.toCharArray() ;
        dfs(0) ;
        return list.toArray(new String[list.size()]) ;
    }

    private void dfs(int cur) {
        if (cur == c.length - 1){
            // 添加排列方案
            list.add(String.valueOf(c)) ;
            return;
        }

        HashSet<Character> set = new HashSet<>() ;
        for (int i = cur ; i < c.length ; i++){
            // 避免重复字符
            if (set.contains(c[i])){
                continue;
            }
            // 以便之后的剪枝
            set.add(c[i]) ;
            // 通过不断交换来实现
            // 固定c[i]为当前位置的字符
            swap(c , i , cur) ;
            // 开始固定第 cur + 1个位置的字符
            dfs(cur + 1) ;
            // 还原之前的交换
            swap(c , i , cur) ;
        }
    }

    private void swap(char[] c, int i, int cur) {
        char tmp = c[i] ;
        c[i] = c[cur] ;
        c[cur] = tmp ;
    }

    public static void main(String[] args) {
        _38_Permutation obj = new _38_Permutation() ;
        String s = "abc" ;
        System.out.println(Arrays.toString(obj.permutation(s)));
    }
}
