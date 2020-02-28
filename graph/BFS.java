package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        map.add(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.value);
            for(Node next: cur.nexts){
                if(!map.contains(next)){
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        Graph graph = new Graph();
        GraphGenerator generator = new GraphGenerator();
        graph = generator.createGraph(matrix);
        Node node = graph.nodes.get(6);
        BFS.bfs(node);
    }
}
