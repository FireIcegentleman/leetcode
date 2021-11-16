package All;

import javax.annotation.processing.AbstractProcessor;
import java.util.*;

/**
 * 2021/11/14
 *
 * 字母异位词分组
 * */
public class _49_GroupAnagrams {
    // 字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>() ;

        for (String str : strs){
            char[] c = str.toCharArray() ;
            // 还原原来的顺序
            Arrays.sort(c);

            String tmp = String.valueOf(c) ;

            map.putIfAbsent(tmp , new ArrayList<>()) ;
            map.get(tmp).add(str) ;
        }

        return new ArrayList<>(map.values()) ;
    }
    public static void main(String[] args) {
        _49_GroupAnagrams obj = new _49_GroupAnagrams() ;
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"} ;

        List<List<String>> res = obj.groupAnagrams(strs) ;

        for (int i = 0 ; i < res.size() ; i++){
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }
}
