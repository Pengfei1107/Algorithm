package basic;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    public static class Node{

    }
    public static class UnionFindSet{
        public HashMap<Node,Node> fatherMap;
        public HashMap<Node,Integer> sizeMap;

        public UnionFindSet(List<Node> nodes){
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes){
            fatherMap = new HashMap<Node,Node>();
            sizeMap = new HashMap<Node,Integer>();
            for(Node node : nodes){
                fatherMap.put(node,node);
                sizeMap.put(node, 1);
            }
        }
        private Node findNode(Node node){
            Stack<Node> stack = new Stack<Node>();
            Node cur = node;
            Node parent = fatherMap.get(node);
            while(cur!=parent){
                stack.push(node);
                cur = parent;
            }
            while(stack.isEmpty()){
                fatherMap.put(stack.pop(),parent);
            }
            return parent;
        }

        public boolean isSameSet(Node a, Node b){
            return findNode(a) == findNode(b);
        }

        public void union(Node a,Node b){
            if(a == null|| b==null)
                return;
            Node aHead = findNode(a);
            Node bHead = findNode(b);
            if(!isSameSet(a, b)){
                int aSetSize = sizeMap.get(a);
                int bSetSize = sizeMap.get(b);
                if(aSetSize <= bSetSize){
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize+bSetSize);
                }else{
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize+bSetSize);
                }
            }
        }
    }
}
