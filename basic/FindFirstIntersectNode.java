package basic;

import java.util.HashSet;

public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    //得到第一个相交的结点
    public static Node getIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //两个链表都无环
        if(loop1 == null && loop2 ==null){
            return noLoop(head1, head2);
        }
        //都有环
        if(loop1 != null && loop2 !=null){
            return bothLoop(head1, loop1,head2,loop2);
        }
        //一个链表有环 一个无环， 不可能相交，直接返回空
        return null;
    }
    //有环返回第一个入环结点，无环返回空
    public static Node getLoopNode(Node head){
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while(n1!=n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
    //两个链表都无环时，长的链表走出差值，两个链表一起走，相遇时为第一个结点
    public static Node noLoop(Node head1,Node head2){
        if(head1 == null || head2 == null)
            return null;
        Node cur1 = head1;
        Node cur2 = head2;
        int len1 = 0;
        while(cur1 != null){
            len1++;
            cur1 = cur1.next;
        }
        int len2 = 0;
        while(cur2 != null){
            len2++;
            cur2 = cur2.next;
        }
        //尾结点不相同
        if(cur1 != cur2)
            return null;
        cur1 = head1;
        cur2 = head2;
        int len = len1-len2;
        while(len!=0){
            if(len>0){
                cur1 = cur1.next;
                len--;
            }else{
                cur2 = cur2.next;
                len++;
            }
        }
        while(cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        //如果两个链表的入环结点相同。
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int len1 = 0;
            while(cur1 != loop1){
                len1++;
                cur1 = cur1.next;
            }
            int len2 = 0;
            while(cur2 != loop2){
                len2++;
                cur2 = cur2.next;
            }
            cur1 = head1;
            cur2 = head2;
            int len = len1-len2;
            while(len!=0){
                if(len>0){
                    cur1 = cur1.next;
                    len--;
                }else{
                    cur2 = cur2.next;
                    len++;
                }
            }
            while(cur1!=cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while(cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
