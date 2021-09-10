/**
 * 2021/09/09
 * 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * */

public class _79_WordSearch {
    public boolean exist(char[][] board, String word) {

    }
    public static void main(String[] args) {
        _79_WordSearch obj = new _79_WordSearch() ;
        char[][] boarad = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}} ;
        String word = "ABCCDE" ;
        System.out.print(obj.exist(boarad , word));
    }
}
