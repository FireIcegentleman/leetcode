import java.util.ArrayList;
import java.util.List;
/**
 * 2021/09/13
 * 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * */
public class _139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String str : wordDict){
            if (s.contains(str)){// s中包含str这个字符串

            }
        }

        return false ;
    }
    public static void main(String[] args) {
        _139_WordBreak obj = new _139_WordBreak() ;
        String s = "leetcode" ;
        List<String> wordDict = new ArrayList<>() ;
        System.out.print(obj.wordBreak(s , wordDict));
    }
}
