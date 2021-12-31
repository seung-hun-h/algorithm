import java.util.*;
import java.io.*;

public class BOJ1025 {
    static int N, M;
    static int[][] board;
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(line[j]);

                if (checkSqrt(board[i][j])) {
                    ans = Math.max(ans, board[i][j]);
                }
            }
        }

        for (int i = -(N - 1); i < N; i++) {
            for (int j = -(M - 1); j < M; j++) {
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < M; c++) {
                        dfs(r, c, i, j, board[r][c]);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int row, int col, int i, int j, int number) {
        if (checkSqrt(number)) {
            ans = Math.max(ans, number);
        }

        if (i == 0 && j == 0)
            return;

        if (row + i < N && row + i >= 0 && col + j < M && col + j >= 0)
            dfs(row + i, col + j, i, j, number * 10 + board[row + i][col + j]);
    }

    private static boolean checkSqrt(int num) {
        return Math.sqrt(num) % 1 == 0;
    }
}
