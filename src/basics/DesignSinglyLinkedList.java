package basics;

import java.util.ArrayList;

public class DesignSinglyLinkedList {

    Node head;

    class Node {
        int val;
        Node next;
    }

     public DesignSinglyLinkedList() {
        head = new Node();
        head.val=0;
        head.next = null ;

    }

    public int get(int index) {
        int i= 0;
        Node cur = head;
        while(cur!=null){
            if(i==index) return cur.val;
            i++;
            cur = cur.next; // f this is mutating if use head
        }
        return 0;
    }

    public void insertHead(int val) {

      Node n = new Node();
      n.val = val;
      
        
    }

    public void insertTail(int val) {

    }

    public boolean remove(int index) {
        
    }

    public ArrayList<Integer> getValues() {

    }
    
}
