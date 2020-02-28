package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBSTAndCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static boolean isBST(Node head){
        if(head == null)
            return false;
        int pre = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<Node>();
        while(!stack.isEmpty() || head!=null){
            if(head!=null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                if(pre < head.value){
                    pre = head.value;
                }else{
                    return false;
                }
                head = head.right;
            }
        }
        return true;
    }

    public static boolean isCBT(Node head){
        if(head == null)
            return true;
        Queue<Node> queue = new LinkedList<Node>();
        //当前结点是否为叶子结点
        boolean leaf = false;
        Node left = null;
        Node right = null;
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            left = head.left;
            right = head.right;
            //1. 左子树为空，右子树不空，返回false
            //2. 一个结点有左没右，或者两个孩子都没有，
            // 从这个结点开始以后的所有结点都必须为叶子结点
            if(leaf &&(left !=null||right!=null)
                    ||left==null && right!=null){
                return false;
            }
            if(left !=null){
                queue.offer(left);
            }
            if(right !=null){
                queue.offer(right);
            }else{
                leaf = true;
            }
        }
        return true;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
//        System.out.println(isBST(head));
        System.out.println(isCBT(head));
    }
}
