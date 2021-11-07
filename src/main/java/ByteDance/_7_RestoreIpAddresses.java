package ByteDance;

import sun.security.timestamp.TSRequest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 2021/10/30
 *
 * 复原IP地址
 *
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * */
public class _7_RestoreIpAddresses {
    // DFS
    // 从头开始遍历每一位，对于每一位有两种情况：
    //   1. 当前临时变量大于0且小于255，加点后递归下一位，或者不加点递归下一位
    //   2. 当前临时变量大于255，必须加点，然后递归下一位
    // 回溯剪枝
    public List<String> restoreIpAddresses(String s) {
        int len = s.length() ;
        if (len < 4 || len > 12){
            return new ArrayList<>() ;
        }

        List<String> res = new ArrayList<>() ;
        Deque<String> path = new ArrayDeque<>() ;
        dfs(s , len , 0 , 4 , path , res) ;
        return res ;
    }

    /**
     * 回溯算法
     * @param s 原字符串
     * @param len 原字符串长度
     * @param begin 当前段起始索引
     * @param residue 剩余Ip地址段
     * @param path 路径
     * */
    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len){
            if (residue == 0){
                // 注意这里的写法
                res.add(String.join("." , path)) ;
            }
            return;
        }

        for (int i = begin ; i < begin + 3 ; i++){
            if (i >= len){
                break;
            }
            if (3 * residue < len - i){
                continue;
            }

            // 当前框住的部分是否是一个合法的IP地址段？
            if (judgeSegment(s , begin , i)){
                String Segment = s.substring(begin , i + 1) ;
                path.addLast(Segment);
                dfs(s , len , i + 1 , residue - 1 , path , res);
                path.removeLast() ;
            }

        }
    }

    private boolean judgeSegment(String s, int begin, int end) {
        int res = 0 ;

        int len = end - begin + 1 ;
        if (s.charAt(begin) == '0' && len > 1){
            return false ;
        }

        while (begin <= end){
            res = res * 10 + s.charAt(begin) - '0' ;
            begin++ ;
        }
        return res >= 0 && res <= 255 ;
    }


    public static void main(String[] args) {
        _7_RestoreIpAddresses obj = new _7_RestoreIpAddresses() ;
        String s = "22522511135" ;
        List<String> res = obj.restoreIpAddresses(s) ;

        for (int i = 0 ; i < res.size() ; i++){
            System.out.print(res.get(i) + " ");
        }

    }
}
