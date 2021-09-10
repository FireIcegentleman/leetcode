import java.util.*;

/**
 * 2021/5/15
 * hard
 *
 * 笑死，根本做不出来
 * 全排列数组内容然后求字串，一定复杂度爆炸
 * 仅供参考
 *
 * https://leetcode.wang/leetCode-30-Substring-with-Concatenation-of-All-Words.html
 * */
public class _30_SubstringwithConcatenationofAllWords {
    public int UnitfindSubstring(String s , String sub){
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == sub.charAt(0)){
                if(s.substring(i , i + sub.length()).equals(sub)){
                    return i ;
                }
            }
        }
        return -1 ;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();

        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return indices;
        }

        int wordLen = words[0].length(), wordsCount = words.length;

        Map<String, Integer> wordToCount = new HashMap<>();
        for (String word : words)
            wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);

        for (int start = 0; start < wordLen; start++) {
            Queue<String> queue = new LinkedList<>();
            Map<String, Integer> substrWordToCount = new HashMap<>();
            for (int lo = start, hi = start; hi <= s.length() - wordLen; hi += wordLen) {
                String word = s.substring(hi, hi + wordLen);
                if (!wordToCount.containsKey(word)) {
                    queue = new LinkedList<>();
                    lo = hi + wordLen;
                    substrWordToCount = new HashMap<>();
                } else {
                    int substrWordCount = substrWordToCount.getOrDefault(word, 0);
                    if (substrWordCount >= wordToCount.get(word)) {
                        while (!queue.peek().equals(word)) {
                            String wordToRemove = queue.poll();
                            int count = substrWordToCount.get(wordToRemove);
                            if (count == 1) substrWordToCount.remove(wordToRemove);
                            else substrWordToCount.put(wordToRemove, count - 1);
                            lo += wordLen;
                        }
                        lo += wordLen;
                        queue.poll();
                    } else {
                        substrWordToCount.put(word, substrWordCount + 1);
                    }
                    queue.offer(word);
                    if (queue.size() == wordsCount) {
                        indices.add(lo);
                    }
                }
            }
        }
        return indices;
    }
    public static void main(String[] args) {
        _30_SubstringwithConcatenationofAllWords obj = new _30_SubstringwithConcatenationofAllWords() ;

        String s = "barfoothefoobarman" ;
        String[] words = new String[]{"foo","bar"} ;
        List<Integer> res = obj.findSubstring(s , words) ;

        System.out.println(res);
    }
}
