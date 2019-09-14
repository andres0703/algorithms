package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node() {}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (map.size() == capacity) {
                evictLast();
            }
            addToFirst(node);
            map.put(key, node);
        } else {
            node.value = value;
            moveToFirst(node);
        }
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToFirst(node);
        //printList();
        return node.value;
    }

    private void moveToFirst(Node node) {
        removeFromList(node);
        addToFirst(node);
    }

    private void evictLast() {
        Node last = tail.prev;
        if (last == head) return;
        removeFromList(last);
        map.remove(last.key);
    }

    private void addToFirst(Node node) {
        Node oldFirst = head.next;
        head.next = node;
        node.prev = head;
        node.next = oldFirst;
        oldFirst.prev = node;
    }

    private void removeFromList(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        next.prev = prev;
        prev.next = next;
    }

}
