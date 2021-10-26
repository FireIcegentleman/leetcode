package All;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 2021/10/25
 *
 * 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 * */
public class _30_FindSubstring {
    // 两个HashMap
    // 第一个Map记录words中出现的所有字符串
    // 第二个Map记录从s开头开始长度等于word中单词长度的子串，并与第一个map进行比较
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>() ;

        int len = s.length() ;
        int count = words.length ;
        int unitLength = words[0].length() ;

        HashMap<String , Integer> map1 = new HashMap<>() ;

        // 将所有的words中的单词存入map1中
        for (String word : words){
            if (!map1.containsKey(word)){
                map1.put(word , 1) ;
            }else{
                map1.put(word , map1.get(word) + 1) ;
            }
        }

        // 遍历s,将长度相等的单元存放如map2中，并于map1进行对比
        for (int i = 0 ; i < s.length() - unitLength * count + 1 ; i++){
            HashMap<String , Integer> map2 = new HashMap<>() ;
            int num = 0 ;
            while (num < count){
                String substr = s.substring(i + num * unitLength , i + (num + 1) * unitLength) ;
                // 该字串在map1中
                if (map1.containsKey(substr)){
                    int value = map2.getOrDefault(substr , 0) ;
                    map2.put(substr , value + 1) ;
                    if (map1.get(substr) < map2.get(substr)){
                        break;
                    }
                }else{
                    break;
                }
                num++;
            }

            if (num == count){
                res.add(i) ;
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        _30_FindSubstring obj = new _30_FindSubstring() ;
        String s = "barfoothefoobarman" ;
        String[] words = {"foo","bar"} ;
        List<Integer> res = obj.findSubstring(s , words) ;

        for (int i = 0 ; i < res.size() ; i++){
            System.out.println(res.get(i));
        }
    }
}
