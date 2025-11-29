package linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import model.ListNode;
import model.Node;

public class LLDeepCopy {


    public static Node copyRandomList(Node head) {
        Node temp = new Node(0);
        Node result = temp;

        //in the order
        List<Node> randomList = new LinkedList<>();
        //old vs new
        HashMap<Node, Node> nodeMap = new LinkedHashMap<>();

        while (head != null) {

            Node newnode = new Node(head.val);
            temp.next = newnode;
            randomList.add(head.random);
            nodeMap.put(head, newnode);
            temp = temp.next;
            head = head.next;

        }
        Node i = result.next;
        int j = 0;
        while (i != null) {

            i.random = nodeMap.get(randomList.get(j));
            i = i.next;
            j++;

        }

        return result.next;

    }

    public static void printLL(Node head) {
        System.out.println("");
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(7);
        Node l2 = new Node(13);
        Node l3 = new Node(11);
        Node l4 = new Node(10);
        Node l5 = new Node(1);

        l1.setNext(l2);
        l1.setRandom(null);

        l2.setNext(l3);
        l2.setRandom(l1);

        l3.setNext(l4);
        l3.setRandom(l5);

        l4.setNext(l5);
        l4.setRandom(l3);

        l5.setNext(null);

        printLL(l1);
        Node res = copyRandomList(l1);
        printLL(res);

    }

}
