import java.io.*;
import java.util.*;

public class BOJ2580 {
    static final int LEN = 9;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] board = new int[LEN][LEN];
        result = new int[LEN][LEN];

        for (int i=0;i<LEN;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0;j<LEN;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board, 0);
        for (int[] res : result) {
            for (int num : res) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    private static void dfs(int[][] board, int current) {

        if (current == 81) {
            for (int i=0;i<LEN;i++) {
                for (int j=0;j<LEN;j++) {
                    result[i][j] = board[i][j];
                }
            }
            return;
        }

        int row = current / LEN;
        int col = current % LEN;

        if (board[row][col] != 0) {
            dfs(board, current + 1);
            return;
        }

        for (int num=1;num<=LEN;num++) {
            if (check(board, row, col, num)) {
                board[row][col] = num;
                dfs(board, current + 1);
                board[row][col] = 0;
            }
        }
    }
    private static boolean check(int[][] board, int row, int col, int num) {
        // 행
        for(int c=0;c<LEN;c++) {
            if (board[row][c] == num)
                return false;
        }
        // 열
        for(int r=0;r<LEN;r++) {
            if (board[r][col] == num)
                return false;
        }
        // 작은 사각형
        int startRow = 0;
        if (row >= 6) {
            startRow = 6;
        } else if (row >= 3) {
            startRow = 3;
        }

        int startCol = 0;
        if (col >= 6) {
            startCol = 6;
        } else if (col >= 3) {
            startCol = 3;
        }

         for (int r=startRow;r<startRow+3;r++) {
             for (int c=startCol;c<startCol+3;c++) {
                 if (board[r][c] == num)
                    return false;
             }
         }

        return true;
    }
}
