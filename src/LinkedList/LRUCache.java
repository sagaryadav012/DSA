package LinkedList;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    HashMap<Integer, DListNode> map;
    DListNode head;
    DListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DListNode(-1,-2);
        tail = new DListNode(-3,-4);
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            DListNode node = map.get(key);
            delete(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DListNode newNode = new DListNode(key, value);
        if(map.containsKey(key)){
            DListNode node = map.get(key);
            delete(node);
        }
        else if(map.size() == capacity){
            DListNode node = map.get(head.next.key);
            delete(node);
            map.remove(node.key);
        }
        insert(newNode);
        map.put(key, newNode);
    }
    public void insert(DListNode node){
        DListNode prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
    public void delete(DListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
class DListNode{
    int key;
    int value;
    DListNode prev;
    DListNode next;
    DListNode(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}