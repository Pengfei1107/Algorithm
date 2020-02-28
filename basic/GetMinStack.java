package basic;

import java.util.Stack;

public class GetMinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public GetMinStack(){
        this.dataStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    //得到栈顶
    public Integer peek(){

        return null;
    }
    public void push(Integer num){
        if(!dataStack.isEmpty()){
            if(num<=minStack.peek()){
                minStack.push(num);
            }
            dataStack.push(num);
        }else{
            dataStack.push(num);
            minStack.push(num);
        }
    }
    public Integer pop(){
        if(dataStack.isEmpty())
            return null;
        Integer num = dataStack.pop();
        if(num == minStack.peek()){
            minStack.pop();
        }
        return num;
    }
    public Integer getMin(){
        if(minStack.isEmpty())
           return null;
        else
            return minStack.peek();
    }

}

