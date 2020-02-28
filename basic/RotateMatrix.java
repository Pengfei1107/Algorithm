package basic;

public class RotateMatrix {
    public static void rotate(int[][] matrix){
        if(matrix.length != matrix[0].length)
            return;
        int left = 0, right = matrix[0].length-1;
        int top = 0, bottom = matrix.length-1;
        while(left<=right && top<=bottom){
            rotateEdge(matrix, left++, right--,
                    top++, bottom--);
        }
    }
    public static void rotateEdge(int[][] matrix,int left,int right,
                                  int top, int bottom){
        int len = right-left;
        for(int i=0; i < len;i++){
            int temp = matrix[top][left+i];
            matrix[top][left+i] = matrix[bottom-i][left];
            matrix[bottom-i][left] = matrix[bottom][right-i];
            matrix[bottom][right-i] = matrix[top+i][right];
            matrix[top+i][right] = temp;
        }
    }

    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                    { 13, 14, 15, 16 } };
        printMatrix(matrix);
        System.out.println("---------");
        rotate(matrix);
        printMatrix(matrix);
    }
}
