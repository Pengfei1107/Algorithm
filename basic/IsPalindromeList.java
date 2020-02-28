package basic;

import java.util.Stack;

public class IsPalindromeList {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public static boolean isPalindrome(Node head){
        Node cur = head;
        Stack<Node> s = new Stack<Node>();
        while(cur !=null){
            s.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if(head.value != s.pop().value)
                return false;
            head = head.next;
        }
        return true;
    }
    // need n/2 extra space
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node quick = head;
        Stack<Node> s = new Stack<Node>();
        while(quick.next!=null&&quick.next.next!=null){
            slow = slow.next;
            quick = quick.next.next;
        }
        while(slow.next!=null){
            slow = slow.next;
            s.push(slow);
        }
        while(!s.isEmpty()){
            if(head.value != s.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    // need 1 extra space
    public static boolean isPalindrome3(Node head) {
        Node n1 = head;
        Node n2 = head;
        while(n2.next!=null&&n2.next.next!=null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while(n2!=null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        while(n1 != null && n2!=null){
            if(n1.value != n2.value)
                return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        boolean flag = isPalindrome3(head);
        System.out.println(flag);
    }
}
