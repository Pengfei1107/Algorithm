package basic;

public class ReverseLinkList {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int value){
            this.value = value;
        }
    }
    public static Node reverseList(Node head){
        if(head == null || head.next==null)
            return head;
        Node pre = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static DoubleNode reverseDoubleList(DoubleNode head){
        if(head == null)
            return head;
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static void printReverList(Node head){
        if(head == null)
            System.out.println(head);
        while(head!=null){
            System.out.print(head.value);
            head = head.next;
        }
    }
    public static void printDoubleReverList(DoubleNode head){
        DoubleNode end = null;
        while(head!=null){
            System.out.print(head.value+" ");
            head = head.next;
            end = head;
        }
        System.out.print("||");
        while(end !=null){
            System.out.print(end.value + " ");
                           end = end.last;
        }
    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1 = reverseList(head1);
        printReverList(head1);
        System.out.println("----------------");

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2;
        printDoubleReverList(head2);
        printDoubleReverList(reverseDoubleList(head2));
    }
}
