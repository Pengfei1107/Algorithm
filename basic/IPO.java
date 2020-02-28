package basic;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static class Node{
        int cost;
        int profit;
        public Node(int cost,int profit){
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost-o2.cost;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit-o2.profit;
        }
    }

    public static int getMaxProfit(int[] cost,int[] profit,int W,int k) {
        Node[] nodes = new Node[profit.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(cost[i], profit[i]);
        }
        PriorityQueue<Node> minCost = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfit = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCost.offer(nodes[i]);
        }
        for(int i=0;i<k;i++){
            while (!minCost.isEmpty() && minCost.peek().cost<=W){
                maxProfit.add(minCost.poll());
            }
            if(maxProfit.isEmpty()){
                return W;
            }
            W+= maxProfit.poll().profit;
        }
        return W;
    }

    public static void main(String[] args) {
        int[] cost = {5,10,5,8,9,11};
        int[] profit = {5,10,5,8,9,11};
        int k=5;
        int W = 1;
        int res =getMaxProfit(cost, profit, W, k);
        System.out.println(res);
    }
}
