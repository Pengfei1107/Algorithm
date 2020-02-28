package basic;

import java.io.FileReader;

public class IsBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnData{
        boolean isB;
        int level;
        public ReturnData(boolean isB,int level){
            this.isB = isB;
            this.level = level;
        }
    }

    public static boolean isBalance(Node head){
        return process(head).isB;
    }
    public static ReturnData process(Node head){
        if(head == null){
            return new ReturnData(true, 0);
        }
        ReturnData leftData = process(head.left);
        if(!leftData.isB){
            return new ReturnData(false, 0);
        }
        ReturnData rightData = process(head.right);
        if(!rightData.isB){
            return new ReturnData(false, 0);
        }
        if(Math.abs(leftData.level - rightData.level)>1 ){
            return new ReturnData(false, 0);
        }
        return new ReturnData(true,Math.max(leftData.level,rightData.level)+1);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }


}
