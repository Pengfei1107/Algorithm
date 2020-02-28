package basic;

public class MinPath {
    public static int walk(int[][] matrix,int i,int j){
        if( i==matrix.length-1 && j==matrix[0].length-1){
            return matrix[i][j];
        }
        if(i == matrix.length-1){
            return matrix[i][j]+walk(matrix, i, j+1);
        }
        if(j == matrix[0].length-1){
            return matrix[i][j]+walk(matrix, i+1, j);
        }
        int right = walk(matrix, i, j+1);
        int down = walk(matrix, i+1, j);

        return matrix[i][j]+Math.min(right,down);
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        int res = walk(m, 0, 0);
        System.out.println(res);
    }
}
