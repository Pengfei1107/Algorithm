package basic;

public class ZigZagPrintMatrix {
    public static void printMatrix(int[][] matrix){
        if(matrix.length==0)
            return;
        int aR = 0, aC = 0;
        int bR = 0, bC = 0;
        int endR = matrix.length-1;
        int endC = matrix[0].length-1;
        boolean flag = false;
        while(aR <= endR){
            printLevel(matrix, aR, aC, bR, bC, flag);
            aR = aC == endC? aR+1:aR;
            aC = aC == endC? aC:aC+1;
            bC = bR == endR? bC+1:bC;
            bR = bR == endR? bR:bR+1;
            flag = !flag;
        }
    }
    public static void printLevel(int[][] matrix,int aR,int aC,
                                  int bR,int bC,boolean flag){
        if(flag){
            while(aR <= bR){
                System.out.print(matrix[aR++][aC--]+" ");
            }
        }else{
            while(bR>= aR){
                System.out.print(matrix[bR--][bC++]+" ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrix(matrix);
    }
}
