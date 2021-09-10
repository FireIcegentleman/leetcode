/**
 * 2021/09/09
 *
 * 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 *    对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *    如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * */
/**
 * 滑动窗口的思想
 * */

public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return "" ;
        }
        // 初始化need数组
        int[] need = new int[128] ;
        // 记录所需要的
        for(int i = 0 ; i < t.length() ; i++){
            need[t.charAt(i)] ++ ;
        }

        int l = 0 , r = 0 , size = Integer.MAX_VALUE , count = t.length() , start = 0 ;
        // 遍历所有字符
        while(r < s.length()){
            char c = s.charAt(r) ;
            if(need[c] > 0){// 需要这个字符
                count -- ;
            }
            need[c] -- ;//将相对右边的字符加入窗口
            if(count == 0){// 窗口中已包含所有的字符，进行左边字符的移出
                while(l < r && need[s.charAt(l)] < 0){
                    need[s.charAt(l)] ++ ;// need数组中不需要这个数
                    l++ ; //左指针右移
                }
                if(r - l + 1 < size){
                    size = r - l + 1 ;
                    start = l ;//记录最小值开始时的左指针索引
                }
                //l向右移动，寻找下一个满足条件的字符串，右移后窗口不能满足，重新开始循环
                need[s.charAt(l)] ++ ;
                l++ ;
                count ++ ;
            }
            r++ ;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start , start + size) ;
    }

    public static void main(String[] args) {
        _76_MinimumWindowSubstring obj = new _76_MinimumWindowSubstring() ;
        String s = "ADOBECODEBANC" ;
        String t = "ABC" ;
        System.out.print(obj.minWindow(s , t));
    }
}
/**
 * 注意事项1：混合大小写，用128ASCII记录
 * */
/**
 * 滑动窗口的思想：
 * 用i,j表示滑动窗口的左边界和右边界，通过改变i,j来扩展和收缩滑动窗口，可以想象成一个窗口在字符串上游走，当这个窗口包含的元素满足条件，即包含字符串T的所有元素，记录下这个滑动窗口的长度j-i+1，这些长度中的最小值就是要求的结果。
 *
 * 步骤一
 * 不断增加j使滑动窗口增大，直到窗口包含了T的所有元素
 *
 * 步骤二
 * 不断增加i使滑动窗口缩小，因为是要求最小字串，所以将不必要的元素排除在外，使长度减小，直到碰到一个必须包含的元素，这个时候不能再扔了，再扔就不满足条件了，记录此时滑动窗口的长度，并保存最小值
 *
 * 步骤三
 * 让i再增加一个位置，这个时候滑动窗口肯定不满足条件了，那么继续从步骤一开始执行，寻找新的满足条件的滑动窗口，如此反复，直到j超出了字符串S范围。
 * */
