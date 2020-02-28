package basic;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public static void main(String[] args) {
        int[] arr = {5,4,3,7,8,44};
        for(int i=0;i<arr.length;i++){
            maxHeap.add(arr[i]);
        }
        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll()+" ");
        }
    }

}
