package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianQuick {
    public static class MedianHolder{
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
        private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new MinHeapComparator());

        public void modifyTwoHeap(){
            if(this.maxHeap.size() == this.minHeap.size()+2){
                this.minHeap.add(this.maxHeap.poll());
            }
            if(this.minHeap.size() == this.maxHeap.size()+2){
                this.maxHeap.add(this.minHeap.poll());
            }
        }
        public void add(int num){
            if(maxHeap.isEmpty()){
                maxHeap.add(num);
                return;
            }
            if(maxHeap.peek() >= num){
                maxHeap.add(num);
            }else{
                if (this.minHeap.isEmpty()) {
                    this.minHeap.add(num);
                    return;
                }
                if (this.minHeap.peek() > num) {
                    this.maxHeap.add(num);
                } else {
                    this.minHeap.add(num);
                }
            }
            modifyTwoHeap();
        }

        public Integer getMedian() {
            int maxHeapSize = this.maxHeap.size();
            int minHeapSize = this.minHeap.size();
            System.out.println("maxSize "+maxHeapSize+" minSize "+minHeapSize);
            if (maxHeapSize + minHeapSize == 0) {
                return null;
            }
            Integer maxHeapHead = this.maxHeap.peek();
            Integer minHeapHead = this.minHeap.peek();
            if (((maxHeapSize + minHeapSize) %2 ) == 0) {
                return (maxHeapHead + minHeapHead)>>1;
            }
            return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
        }
    }
    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }

    //随机生成一个数组
    public static int[] getRandomArray(int maxLen,int maxValue){
        int[] res = new int[(int)(Math.random()*maxLen+1)];
        for(int i=0;i<res.length;i++){
            res[i] = (int)(Math.random()*maxValue+1);
        }
        return res;
    }
    //print
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int getMedianOfArray(int[] arr){
        if(arr == null|| arr.length ==0)
            return -1;
        Arrays.sort(arr);
        int mid = (arr.length-1)/2;
        if(arr.length % 2 == 0){
            return (arr[mid]+arr[mid+1])>>1;
        }else{
            return arr[mid];
        }
    }
    public static void main(String[] args) {
//        int[] arr = getRandomArray(10, 10);
//        printArray(arr);
        MedianHolder holder = new MedianHolder();
        int[] arr = {10,2};
        for(int i =0;i<arr.length;i++){
            holder.add(arr[i]);
        }
        int cor = getMedianOfArray(arr);
        System.out.println(cor);

        System.out.println(holder.getMedian());
        System.out.println(cor == holder.getMedian());
    }
}
