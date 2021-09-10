/**
 * 2021/09/08
 * 字母异位词分组
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 * 遇到了java语法的问题，map判断一致性
 *
 * 遇到字符串转换的时候，首选String.valueof（）
 * */
import java.lang.reflect.Array;
import java.util.*;

public class _49_GroupAnagrams {
    // 本质上是把所有由相同字符组成的字符串放在一起返回
    // 这个方法失败了，是因为ContainKey没有对两个key均为 aet 的进行有效的合并
    public List<List<String>> groupAnagrams_cant_find_by_containKeys(String[] strs) {
        List<List<String>> res = new ArrayList<>() ;
        List<String> out = new ArrayList<>() ;

        // K-V，K是排序后的字符序列，V是对应的字符串
        Map<char[],List<String>> map = new HashMap<>() ;

        // 字符数组排序后比较一致的放在一起
        for(int i = 0 ; i < strs.length ; i++){
            char[] tmp = strs[i].toCharArray() ;
            Arrays.sort(tmp);
            // 将新的字符串加入原来的List中
            if(map.containsKey(tmp)){// 判断原来的map中是否有tmp的key，但是似乎并不是只通过字面值判别是否相同
                out = map.get(tmp) ;
            }else{
                out = new ArrayList<>() ;
            }
            out.add(strs[i]) ;
            map.put(tmp , out) ;
        }

        for(List<String> value : map.values()){
            res.add(value) ;
        }

        return res ;
    }
    private  List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>() ;

        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            // String.valueof()和toString()之间的区别
            String tmp = String.valueOf(c) ;
            map.putIfAbsent(tmp , new ArrayList<>()) ;
            map.get(tmp).add(s) ;
        }

        return new ArrayList<>(map.values()) ;
    }

    public static void main(String[] args) {
        _49_GroupAnagrams obj = new _49_GroupAnagrams() ;
        String[] strs = {"eat","ate","tea","tan","nat","bat"} ;
        System.out.println(obj.groupAnagrams(strs));
    }


}
