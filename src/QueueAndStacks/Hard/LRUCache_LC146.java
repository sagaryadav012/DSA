package QueueAndStacks.Hard;

import java.util.HashMap;

public class LRUCache_LC146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
class LRUCache {
    int capacity;
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1,-2);
        tail = new ListNode(-3,-4);
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            delete(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        ListNode newNode = new ListNode(key, value);
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            delete(node);
        }
        else if(map.size() == capacity){
            ListNode node = map.get(head.next.key);
            delete(node);
            map.remove(node.key);
        }
        insert(newNode);
        map.put(key, newNode);
    }
    public void insert(ListNode node){
        ListNode prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
    public void delete(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
class ListNode{
    int key;
    int value;
    ListNode prev;
    ListNode next;
    ListNode(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}
/*
Explanation :
-> Get and Put operation can be done easily with map. map stores key(integer) and value(integer).
-> But here problem is, when cache is full, need to evict least recently used key, It can't be done using map.
   Since map doesn't store insertion order. We should insertion order then only we can detect least recently used key.
-> To detect LRU key, We have used doubly ended linked list, In this removal and adding is easy, and will
   be done at constant time.
-> So map stores integer, integer. DLL stores key. When we do get operation, we will get value from map at
   Constant time as well we need to remove key at present location and add it at end of DLL.
-> But the problem is here, we can't find key at constant time in DLL, in order find key, need to do linear search.
-> So in map store key and values is DLL node, so that it is easy to find node at constant time.
-> In order to get value, store value in DLL Node, DLL node stores key, value, prev pointer and next pointer.

 */