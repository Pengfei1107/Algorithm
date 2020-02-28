package basic;

import org.omg.CORBA.IRObject;

public class PrintMatrix {
    public static void printOrder(int[][] matrix){
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        while(left<=right&&top<=bottom){
            printEdge(matrix, left++
            , top++, right--, bottom-- );
        }
    }
    public static void printEdge(int[][] matrix,int left,int top,int right,int bottom){
        if(top == bottom){
            for (int i = left;i<=right;i++){
                System.out.print(matrix[top][i]+" ");
            }
        }
        else if(left == right){
            for (int j = top;j<=bottom;j++){
                System.out.print(matrix[left][j]+" ");
            }
        }
        else{
            int curR = top;
            int curC = left;
            while(curC!=right){
                System.out.print(matrix[top][curC]+" ");
                curC++;
            }
            while (curR !=bottom){
                System.out.print(matrix[curR][right]+" ");
                curR++;
            }
            while(curC!=left){
                System.out.print(matrix[bottom][curC]+" ");
                curC--;
            }
            while (curR !=top){
                System.out.print(matrix[curR][right]+" ");
                curR--;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printOrder(matrix);
    }
}
