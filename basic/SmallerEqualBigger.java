package basic;

public class SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node listPartition1(Node head,int num){
        if(head ==null)
            return null;
        int i=0;
        Node cur = head;
        while(cur!=null){
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        cur = head;
        for(i=0;i< nodeArr.length;i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,num);
        for(i=1;i<nodeArr.length;i++){
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null;
        return nodeArr[0];
    }
    public static void arrPartition(Node[] nodeArr,int num){
        int low = -1;
        int high = nodeArr.length;
        int cur = 0;
        while(cur!=high){
            if(nodeArr[cur].value<num){
                swap(nodeArr, ++low, cur++);
            }else if(nodeArr[cur].value==num){
                cur++;
            }else{
                swap(nodeArr, cur, --high);
            }
        }
    }
    public static Node listPartition2(Node head,int num){
        Node sh = null;
        Node st = null;
        Node eh = null;
        Node et = null;
        Node bh = null;
        Node bt = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = null;
            if(head.value<num){
                if(sh==null){
                    sh = head;
                    st = head;
                }else{
                    st.next = head;
                    st = head;
                }
            }else if(head.value==num){
                if(eh==null){
                    eh = head;
                    et = head;
                }else{
                    et.next = head;
                    et = head;
                }
            }else{
                if(bh == null){
                    bh = head;
                    bt = head;
                }else{
                    bt.next = head;
                    bt = head;
                }
            }
            head = next;
        }
        //connect
        if(st!=null){
            st.next = eh;
            et = et==null?st:et;
        }
        if(et!=null){
            et.next = bh;
        }
        return sh != null ? sh : eh != null?eh:bh;
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
         head1 = listPartition2(head1, 5);
         printLinkedList(head1);
//        head1 = listPartition1(head1, 5);
//        printLinkedList(head1);
    }
}
