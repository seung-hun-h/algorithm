/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    private static int n, m;
    private static int[][] board;
    private static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        int[][] dist = new int[n][m];

        for (int[] d : dist) {
            Arrays.fill(d, -1);
        }

        int row = 0, col = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    row = i;
                    col = j;
                } else if (board[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }

        int[][] answer = bfs(row, col, dist);
        StringBuilder sb = new StringBuilder();

        for (int[] array : answer) {
            for (int num : array) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int[][] bfs(int row, int col, int[][] dist) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{row, col, 0});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            row = q.peek()[0];
            col = q.peek()[1];
            int length = q.poll()[2];

            dist[row][col] = length;

            for (int i = 0; i < 4; i++) {
                int nr = row + d[i][0], nc = col + d[i][1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (board[nr][nc] == 0) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                q.add(new int[]{nr, nc, length + 1});
                visited[nr][nc] = true;
            }
        }

        return dist;
    }
}
