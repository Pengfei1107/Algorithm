package basic;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {
    public class Queue2Stack{
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public Queue2Stack(){
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        public Integer peek(){
            if(queue.size()==0)
                return null;
            while(queue.size()>1){
                help.add(queue.poll());
            }
            Integer res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public void push(Integer num){
            queue.add(num);
        }
        public Integer pop(){
            if(queue.size()==0)
                return null;
            while(queue.size()>1){
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }
        public void swap(){
            Queue temp = help;
            help = queue;
            queue = temp;
        }
    }
    public class Stack2Queue{
        private Stack<Integer> data;
        private Stack<Integer> help;
        public Stack2Queue(){
            data = new Stack<Integer>();
            help = new Stack<Integer>();
        }
        //获得队顶
        public Integer peek(){
            if(!help.isEmpty())
                return help.pop();
            else{
                while(!data.isEmpty()){
                    help.push(data.pop());
                }
            }
            return help.peek();
        }
        //入队操作
        public void push(Integer num){
            data.push(num);
        }
        //出队操作
        public Integer poll(){
            if(data.isEmpty()&&help.isEmpty())
                throw new EmptyStackException();
            if(!help.isEmpty())
                return help.pop();
            else{
                while(!data.isEmpty()){
                    help.push(data.pop());
                }
                return help.pop();
            }
        }
    }
}
