package basic;

public class PrintCommonPart {
    public static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public static void printCommonList(Node node1, Node node2){
        while(node1 !=null && node2!=null){
            if(node1.value<node2.value){
                node1 = node1.next;
            }else if(node1.value>node2.value){
                node2 = node2.next;
            }else{
                System.out.print(node1.value+" ");
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }
    public static void printList(Node node){
        if(node ==null)
            return;
        while(node!=null){
            System.out.print(node.value+" ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        Node node3 = new Node(10);

        printList(node1);
        printList(node2);

        System.out.println("---------");

        printCommonList(node1, node3);
    }
}
