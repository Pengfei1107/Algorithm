package basic;

public class ArrayStack {
    private Integer[] arr;
    private Integer index;
    private Integer minNum;
    public ArrayStack(int initSize) throws IllegalAccessException {
        if(initSize<0)
            throw new IllegalAccessException("The index is less than 0");
        arr = new Integer[initSize];
        index = 0;
    }

    public Integer peek(){
        if (arr.length==0){
          return null;
        }
        return arr[index-1];
    }
    public void push(Integer num){
        if(index == arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        arr[index++] = num;
    }

    public Integer pop(){
        if(index == 0)
            throw new ArrayIndexOutOfBoundsException();
        return arr[--index];
    }

}
