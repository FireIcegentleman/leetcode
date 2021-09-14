import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2021/09/14
 * 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * */
public class _139_WordBreak {
    // 定义dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i-1]是否能被空格拆分成若干个字典中出现的单词
    // 则可以得到如下状态转移方程
    // dp[i]=dp[j] && check(s[j..i−1])
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict) ;

        boolean[] dp = new boolean[s.length() + 1] ;
        for(int i = 0 ; i < dp.length ; i++){
            dp[i] = false ;
        }
        // 这看似荒谬，但这只是为了让边界情况也能套用状态转移方程，而已
        dp[0] = true ;

        for (int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < i ; j++){// j去划分两部分
                if(dp[j] && wordSet.contains(s.substring(j , i))){// 左侧已经被处理过的子串为真，同时右侧也被包含在set中
                    dp[i] = true ;
                    break;// dp[i]为true，表示i长度的子串已经可以拆成单词了，不需要j继续划分子串了
                }
            }
        }
        return dp[dp.length - 1] ;
    }
    public static void main(String[] args) {
        _139_WordBreak obj = new _139_WordBreak() ;
        String s = "leetcode" ;
        List<String> wordDict = new ArrayList<>() ;
        wordDict.add("leet") ;
        wordDict.add("code") ;
        System.out.print(obj.wordBreak(s , wordDict));
    }
}
