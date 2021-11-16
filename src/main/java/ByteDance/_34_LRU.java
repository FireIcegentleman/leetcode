package ByteDance;

import javax.naming.NoInitialContextException;
import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
/**
 * 2021/11/9
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
// 双向链表
public class _34_LRU {
    // 最大容量
    public int capacity ;
    // 当前链表中的节点个数
    public int size ;
    public class Node{
        int key ;
        int value ;
        // 前一个节点
        Node prev ;
        // 后一个节点
        Node next ;
        public Node(){}
        public Node(int key , int value){
            this.key = key ;
            this.value = value ;
        }
    }

    // 存储当前的k-v值
    public HashMap<Integer , Node> map ;
    // 双向列表的头节点
    public Node head  , tail ;

    public _34_LRU(int capacity) {
        this.capacity = capacity ;
        this.size = 0 ;

        map = new HashMap<>() ;

        head = new Node() ;
        tail = new Node() ;

        head.next = tail ;
        tail.prev = head ;
    }

    // 查询如果在里面，则当前不考虑容量超出的问题
    public int get(int key) {
        // 是否在哈希表中，是否命中
        Node res = map.get(key) ;
        // 将这个节点移动到整个列表的最前面
        if (res == null){
            return -1 ;
        }

        moveToHead(res) ;
        return res.value ;
    }

    // 将当前的K-V写入
    public void put(int key, int value) {
        Node node = map.get(key) ;

        if (node == null){
            // 当前没有这个节点，则创建并放在头部
            Node newNode = new Node(key , value) ;

            map.put(key , newNode) ;
            addToHead(newNode);
            size++ ;

            if (size > capacity){
                // 如果当前节点个数大于容量，则需要找到末尾元素并将其移除
                Node tail = removeTail();
                map.remove(tail.key) ;
                size-- ;
            }
        }else{
            node.value = value ;
            moveToHead(node);
        }
    }

    // 删除末尾的节点
    private Node removeTail() {
        Node res = tail.prev ;
        removeNode(res);
        return res ;
    }


    private void moveToHead(Node res) {
        removeNode(res) ;
        addToHead(res) ;
    }

    private void addToHead(Node res) {
        Node old_first = head.next ;

        head.next = res ;

        res.prev = head ;
        res.next = old_first ;

        old_first.prev = res ;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next ;
        node.next.prev = node.prev ;
    }

    public static void main(String[] args) {
        _34_LRU lRUCache  = new _34_LRU(2) ;
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1)) ;    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2)) ;    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1)) ;    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3)) ;    // 返回 3
        System.out.println(lRUCache.get(4)) ;    // 返回 4
    }

}
