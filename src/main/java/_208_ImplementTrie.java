import org.w3c.dom.ls.LSException;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * 2021/09/16
 * 实现前缀树
 *
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * */
public class _208_ImplementTrie {
    /*class TreeNode{
        char value ;
        List<TreeNode> child ;
        public TreeNode(){}
        public TreeNode(char value){
            this.value = value ;
        }
    }
    // 整个Trie树的根节点
    TreeNode head ;
    boolean valid = false ;
    /** Initialize your data structure here. */
    /*public _208_ImplementTrie() {
        head = new TreeNode() ;
        head.child = new ArrayList<>() ;
    }

    /** Inserts a word into the trie. */
   /* public void insert(String word) {
        // 变为字符数组
        char[] word_to_array = word.toCharArray() ;
        // 将字符数组按序插入head中
        TreeNode p = head ;
        for (int i = 0 ; i < word_to_array.length ; i++){
            TreeNode tmp = new TreeNode(word_to_array[i]) ;
            p.child.add(tmp) ;
            p = tmp ;
            if(p.child == null){
                p.child = new ArrayList<>() ;
            }
        }
        // 表示一个word的终结
        p.child.add(new TreeNode('/')) ;
    }

    private boolean isexist(TreeNode p, char[] word_to_array, int i) {
        if (i == word_to_array.length){
            for (int j = 0 ; j < p.child.size() ; j++){
                if (p.child.get(j).value == '/'){
                    valid = false ;
                    return true ;
                }
            }
            valid = false ;
            return false ;
        }
        // 判断下一个字符是否在child中
        for (int j = 0 ; j < p.child.size() ; j++){
            if (p.child.get(j).value == word_to_array[i]){
                valid = isexist(p.child.get(j) , word_to_array , i + 1) ;
            }
        }
        return valid ;
    }

    /** Returns if the word is in the trie. */
    /*public boolean search(String word) {
        // 变为字符数组
        char[] word_to_array = word.toCharArray() ;
        TreeNode p = head ;

        return isexist(p , word_to_array , 0) ;


    }


    private boolean isexist_pre(TreeNode p, char[] prefix_to_array, int i) {
        if (i == prefix_to_array.length){
            valid = false ;
            return true ;
        }
        // 判断下一个字符是否在child中
        for (int j = 0 ; j < p.child.size() ; j++){
            if (p.child.get(j).value == prefix_to_array[i]){
                valid = isexist_pre(p.child.get(j) , prefix_to_array , i + 1) ;
            }
        }
        return valid ;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    /*public boolean startsWith(String prefix) {
        // 变为字符数组
        char[] prefix_to_array = prefix.toCharArray() ;
        TreeNode p = head ;

        return isexist_pre(p , prefix_to_array , 0) ;
    }*/
    private _208_ImplementTrie[] children;
    private boolean isEnd;

    public _208_ImplementTrie() {
        children = new _208_ImplementTrie[26];
        isEnd = false;
    }

    public void insert(String word) {
        _208_ImplementTrie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new _208_ImplementTrie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    private _208_ImplementTrie searchPrefix(String prefix) {
        _208_ImplementTrie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
    public boolean search(String word) {
        _208_ImplementTrie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    public static void main(String[] args) {
        _208_ImplementTrie obj = new _208_ImplementTrie() ;
        /*obj.insert("apple");
        System.out.println(obj.search("a"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));*/
        obj.insert("hello");
        System.out.println(obj.search("hell"));
        System.out.println(obj.search("helloa"));
        System.out.println(obj.startsWith("hell"));
        System.out.println(obj.startsWith("helloa"));
        System.out.println(obj.startsWith("hello"));
    }
}
