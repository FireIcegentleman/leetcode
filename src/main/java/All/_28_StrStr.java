package All;

/**
 * 2021/10/24
 *
 * 实现strStr()
 *
 * 实现stStr()函数，给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * */
public class _28_StrStr {
    public int strStr_force(String haystack, String needle) {
        int hayLen = haystack.length() ;
        int needLen = needle.length() ;

        if (needLen == 0){
            return 0 ;
        }

        for (int i = 0 ; i < hayLen - needLen + 1 ; i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                if (haystack.substring(i , i + needLen).equals(needle)){
                    return i ;
                }
            }
        }
        return -1 ;
    }

    /**
     * KMP算法
     * 快速查找匹配串的算法，作用是如何快速在 原字符串 中找到匹配字符串
     * 时间复杂度为O(m + n)
     *
     * 关键在于next数组
     * */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0 ;
        }

        // 分别读取原串和匹配串的长度
        int n = haystack.length() ;
        int m = needle.length() ;

        // 原串和匹配串前面都加空格，使其下标从1开始
        haystack = " " + haystack ;
        needle = " " + needle ;

        char[] s = haystack.toCharArray() ;
        char[] p = needle.toCharArray() ;

        // 构建next数组，数组长度为匹配串长度(next数组是和匹配串相关的)
        int[] next = new int[m + 1] ;
        // 构造过程i=2，j=0开始，i小于等于匹配串的长度【构造i从2开始】
        for (int i = 2 , j = 0 ; i <= m ; i++){
            // 匹配不成功的话，j = next[j]
            while (j > 0 && p[i] != p[j + 1]){// 前后缀不相同
                j = next[j] ;// 向前回溯，直到相等或者到头
            }
            // 匹配成功的话，先让j++
            if(p[i] == p[j + 1]){// 找到相同的前后缀
                j++ ;
            }
            // 更新next[i]，结束本次循环，i++
            next[i] = j ;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1 , j = 0 ; i <= n; i++){
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]){
                j = next[j] ;
            }
            // 匹配成功的话，先让j++，结束本次循环后i++
            if (s[i] == p[j + 1]){
                j++ ;
            }
            if (j == m){
                return i - m ;
            }
        }
        return -1 ;
    }
    public static void main(String[] args) {
        _28_StrStr obj = new _28_StrStr() ;
        String haystack = "hello" ;
        String needle = "ll" ;
        System.out.println(obj.strStr(haystack , needle));
    }
}

/**
 * KMP主要应用在字符串匹配上。主要思想是当出现字符串不匹配时，可以知道一部分之前已经匹配的文本内容，可以利用这些信息避免从头再去做匹配了。
 *
 * next数组就是一个前缀表（prefix table）。
 * 前缀表是用来回退的，它记录了模式串与主串不匹配的时候，模式串应该从哪里开始重新匹配
 * 前缀表的任务是当前位置匹配失败，找到之前已经匹配上的位置，在重新匹配，此也意味着在某个字符失配时，前缀表会告诉你下一步匹配中，模式串应该跳到哪个位置。
 *
 * 前缀表的作用是：记录下标i之前包括（i）的字符串中，有多大长度的相同前缀后缀
 *
 * 计算前缀表的方法
 * 可以看出模式串与前缀表对应位置的数字表示的就是：下标i之前（包括i）的字符串中，有多大长度的相同前缀后缀。
 *
 * next数组用来做回退操作。
 *
 * */
