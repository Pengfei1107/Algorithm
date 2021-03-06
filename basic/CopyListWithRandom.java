package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node copyRandList1(Node head){
        if(head==null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyRandList2(Node head){
        if(head==null)
            return null;
        Node cur = head;
        Node next = null;
        Node curCopy = null;
        //copy list
        while(cur!=null){
            next = cur.next;
            curCopy= new Node(cur.value);
            cur.next= curCopy;
            curCopy.next = next;
            cur = next;
        }
        //copy rand
        cur = head;
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand==null?null:cur.rand.next;
            cur = next;
        }
        //split
        Node res = head.next;
        cur = head;
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next==null?null:next.next;
            cur = next;
        }
        return res;
    }
    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4
        printRandLinkedList(head);
        Node res = copyRandList2(head);
        printRandLinkedList(res);
    }

}
