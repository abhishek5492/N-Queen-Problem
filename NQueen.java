import java.sql.SQLOutput;
import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer[][] matrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        FindSolution(matrix,0, n);
    }

    public static boolean FindSolution (Integer[][] matrix, int row, int n){
        if(row == n){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");
            return false;
        }

        for (int j = 0; j < n; j++) {
            if(IsSafe(matrix, j, row, n)){
                matrix[row][j] = 1;
                if(!FindSolution(matrix, row+1, n)){
                    matrix[row][j] = 0;
                }
            }
        }
        return false;
    }

    public static boolean IsSafe(Integer [][] matrix,int col, int row, int n){
        //column check
        for (int j = 0; j < n; j++) {
            if(matrix[j][col] == 1)
                return false;            
        }
        //left diagonal check
        for (int i = row, j = col ; i >=0 && j >= 0 ; i--, j--) {
            if(matrix[i][j]==1)
                return false;
        }
        //right diagonal check
        for (int i = row, j =  col; i >=0 && j < n ; i--, j++) {
            if(matrix[i][j] == 1)
                return false;
        }
        return  true;
    }
}
