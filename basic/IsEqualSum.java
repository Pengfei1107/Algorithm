package basic;

public class IsEqualSum {
    public static boolean getSum(int[] arr,int i,int sum, int aim){
        if(sum == aim)
            return true;
        if( i == arr.length)
            return false;
        return getSum(arr, i+1, sum+arr[i],aim)||
                getSum(arr, i+1, sum,aim);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7};
        boolean flag = getSum(arr,0,0,2);
        System.out.println(flag);
    }
}
