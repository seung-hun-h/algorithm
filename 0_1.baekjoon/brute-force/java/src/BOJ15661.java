import java.io.*;
import java.util.*;

public class BOJ15661 {
    static int N, ans = Integer.MAX_VALUE;
    static int[][] board;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int visited, int start) {
        if (visited != 0 && visited != (1 << N) - 1) {
            ans = Math.min(ans, getDiff(visited));
        }

        for (int i = start; i < N; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            dfs(visited | (1 << i), i + 1);
        }

    }

    private static int getDiff(int visited) {
        return Math.abs(getScore(visited) - getScore(~visited));
    }

    private static int getScore(int visited) {
        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            if ((visited & (1 << i)) == 0)
                continue;
            for (int j = i + 1; j < N; j++) {
                if ((visited & (1 << j)) == 0) 
                    continue;

                result += board[i][j] + board[j][i];
            }    
        }

        return result;
    }
}
