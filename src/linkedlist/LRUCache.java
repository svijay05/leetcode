package linkedlist;

import java.util.HashMap;

public class LRUCache {

    HashMap<Integer, Node> cache = new HashMap();
    int capacity;


    Node head;
    Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = this.tail;
        this.tail.prev = this.head;

    }

    public int get(int key) {

        Node entry = cache.get(key);
        if(entry==null) return -1;

        deleteNode(entry);
        insertNodeTail(entry);
        return entry.value;
    }

    private void deleteNode(Node node) {

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

    }

    private void insertNodeTail(Node node) {

        Node temp = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = temp;
        temp.next = node;


     /*   tail.next = node;
        node.prev = tail;
        tail = node;*/
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (cache.get(key) != null) {
            deleteNode(cache.get(key));
        }
        cache.put(key, node);
        insertNodeTail(node);
        if (cache.size() > capacity) {
            //remove head
          /*  Node delNode = head.next;
            deleteNode(delNode);
            cache.remove(delNode.key);

            */


            deleteNode(head.next);
            cache.remove(head.next.key);


        }

    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(2,1);
        obj.put(1,1);
        obj.put(2,3);
        obj.put(4,1);
        obj.get(1);
        obj.get(2);

        System.out.println("end");
    }


    private static class Node {

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int key;
        int value;

        Node prev;
        Node next;
    }



}
