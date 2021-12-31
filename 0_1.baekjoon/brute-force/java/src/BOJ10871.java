import java.io.*;
import java.util.*;

class BOJ10871 {
    static int N, result, limit;
    static int[][] board;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;
        limit = (int)Math.pow(2, N) - 1;
        board = new int[N][N];

        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int start=0;start<N;start++) {
            dfs(start, start, 0, 0);
        }
        System.out.println(result);
    }

    private static void dfs(int start, int node, int weight, int visited) {
        if (weight >= result)
            return;

        if (visited == limit - (1 << start)) {
            if (board[node][start] != 0) {
                result = Math.min(result, weight + board[node][start]);
            }
            return;
        }

        for (int next=0;next<N;next++) {
            if (next == start) continue;
            if (board[node][next] == 0) continue;
            if ((visited & (1 << next)) == 0) {
                dfs(start, next, weight + board[node][next], visited | (1 << next));
            }
        }
    } 
}