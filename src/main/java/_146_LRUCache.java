import java.util.*;

/**
 * 2021/09/14
 * LRU缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *      LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存，
 *      int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *      void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  进阶：在O(1)时间复杂度内完成这两种操作
 * */
/**
 * 需要用到一个哈希表和一个双向链表。
 * LRU缓存机制可以通过哈希表辅以双向链表实现，用一个哈希表和一个双向链表维护所有在缓存中的键值对：
 *      双向链表按照被使用的顺序存储这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
 *      哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
 * tips：在双向链表的实现中，使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
 * */
public class _146_LRUCache /*extends LinkedHashMap<Integer , Integer>*/ {
    /*public int[][] memory ;// 模拟磁盘空间
    public int[] hot ; // 热度数组，记录每个位置的数据被访问的热度
    public _146_LRUCache(int capacity) {
        memory = new int[4000][2] ;
        hot = new int[4000] ;
        // [-2,-2]表示为非法数组
        for(int i = 0 ; i < 4000 ; i++){
            memory[i][0] = -2 ;
            memory[i][1] = -2 ;
            // 没有热度值可以为1，仅起占位作用
            hot[i] = 1 ;
        }
        // 可用的空间
        // [-1,-1]表示为可用位置
        for(int i = 0 ; i < capacity ; i++){
            memory[i][0] = -1 ;
            memory[i][1] = -1 ;
            // 初始每个位置的热度均为1
            hot[i] = 0 ;
        }
    }

    public int get(int key) {
        int res = -1 ;
        for (int i = 0 ; i < 4000 ; i ++){
            // 访问到非法的位置，说明没有找到元素
            if(memory[i][0] == -2){
                return res ;
            }

            // 找到了
            if(memory[i][0] == key){
                hot[i] = 0 ;
                res = memory[i][1] ;
            }else{
                // 没有被访问到的，但有数据存储，对应热度--
                if(memory[i][0] != -1){
                    hot[i]-- ;
                }
            }
        }
        return res ;
    }

    // 如果关键词已经存在，则变更其数据值，若不存在，则插入该k-v，如果缓存已达上限，则在写入新数据之前删除最久未使用的数据值
    public void put(int key, int value) {
        int i = 0 ;
        boolean flag = false ;
        for( ; i < 4000 ; i ++){
            // 访问到非法的位置，说明没有找到元素
            if(memory[i][0] == -2){
                break ;
            }
            // 说明现在还有可以用的位置，直接放入就行
            if (memory[i][0] == -1){
                memory[i][0] = key ;
                memory[i][1] = value ;
                // 热度数组重新置零
                hot[i] = 0 ;
                return ;
            }else if(memory[i][0] == key){
                memory[i][1] = value ;
                hot[i] = 0 ;
                flag = true ;
            }else{
                hot[i] -- ;
            }

        }

        if(flag == false){
            // 如果没有空值，说明位置已被占用尽，那么就需要在当前的内存中寻找hot值最低的，将该位置上的值替换掉
            int min_hot = Integer.MAX_VALUE ;
            for(int j = 0 ; j < 4000 ; j++){
                if(hot[j] == 1){
                    break;
                }
                min_hot = Math.min(min_hot , hot[j]) ;
            }
            for(int j = 0 ; j < 4000 ; j++){
                if(hot[j] == min_hot){// 说明对应的数值热度最低
                    memory[j][0] = key ;
                    memory[j][1] = value ;
                    hot[j] = 0 ;
                    return;
                }
            }
        }
    }*/
    // 定义双向链表里的节点
    class DLinkedNode {
        int key ;
        int value ;
        DLinkedNode prev ;
        DLinkedNode next ;
        public DLinkedNode(){}
        public DLinkedNode(int _key , int _value){
            key = _key ;
            value = _value ;
        }
    }

    private Map<Integer , DLinkedNode> cache = new HashMap<>() ;
    // 双向链表节点个数
    private int size ;
    // 双向链表容量
    private int capacity ;
    // 伪起点 与 伪终点
    private DLinkedNode head , tail ;

    public _146_LRUCache(int capacity) {
        /*super(capacity , 0.75F , true);
        this.capacity = capacity ;*/
        this.size = 0 ;
        this.capacity = capacity ;
        // 伪头部 和 伪尾部
        this.head = new DLinkedNode() ;
        this.tail = new DLinkedNode() ;
        head.next = tail ;
        tail.prev = head ;
    }

    public int get(int key) {
        //return super.getOrDefault(key ,  -1) ;
        DLinkedNode node = cache.get(key) ;
        if(node == null){
            return -1 ;
        }
        moveTohead(node) ;
        return node.value ;
    }

    public void put(int key, int value) {
        //super.put(key , value) ;
        DLinkedNode node = cache.get(key) ;

        if (node == null){
            // 如果key不存在则创建一个新的节点放在头部
            DLinkedNode newNode = new DLinkedNode(key , value) ;
            // 添加进哈希表
            cache.put(key , newNode) ;
            addTohead(newNode);
            size++ ;
            if(size > capacity){
                // 如果超出容量，则删除尾部节点
                DLinkedNode tail = removeTail() ;
                // 删除哈希表对应的项
                cache.remove(tail.key) ;
                --size ;
            }
        }else{
            node.value = value ;
            moveTohead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev ;
        removeNode(res);
        return res ;
    }

    private void addTohead(DLinkedNode node) {
        node.prev = head ;
        node.next = head.next ;
        head.next.prev = node ;
        head.next = node ;

    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next ;
        node.next.prev = node.prev ;
    }
    private void moveTohead(DLinkedNode node) {
        removeNode(node) ;
        addTohead(node) ;
    }



    public static void main(String[] args) {
        String[] ope = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"} ;
        int[][] num = {{2} , {1,1} , {2,2} , {1} , {3,3} , {2} , {4,4} , {1} , {3} , {4}} ;

        _146_LRUCache obj = new _146_LRUCache(num[0][0]) ;
        obj.put(1,1);
        obj.put(2,2);
        int param_1 = obj.get(1);
        obj.put(3,3);
        int param_2 = obj.get(2);
        obj.put(4,4);
        int param_new_1 = obj.get(1);
        int param_3 = obj.get(3);
        int param_4 = obj.get(4);
        return ;
    }
}

/**
 * LinkedHashMap知识点的考察
 *
 * HashMap底层：数组 + 红黑树 + 链表，是无序的。
 * LinkedHashMap刚好多提供了一个有序的功能。
 * LinkedHashMap的有序可以按两种顺序排列，一种是按照插入的顺序，一种是按照读取的顺序
 * （这个题目的示例就是告诉我们要按照读取的顺序进行排序），
 * 而其内部是靠 建立一个双向链表 来维护这个顺序的，在每次插入、删除后，都会调用一个函数来进行 双向链表的维护 ，
 *
 * */
