/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.io.*;
import java.util.*;

public class BOJ16973 {
    private static int N, M, H, W;
    private static int[][] board;
    private static int[][] ps;
    private static int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        ps = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] + board[i][j] - ps[i - 1][j - 1];
            }
        }

        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int fr = Integer.parseInt(st.nextToken());
        int fc = Integer.parseInt(st.nextToken());

        System.out.println(solve(sr, sc, fr, fc));
    }

    private static int solve(int sr, int sc, int fr, int fc) {
        return bfs(sr, sc, fr, fc);
    }

    private static int bfs(int sr, int sc, int fr, int fc) {
        boolean[][] visited = new boolean[N + 1][M + 1];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int row = q.peek()[0];
            int col = q.peek()[1];
            int count = q.poll()[2];

            if (row == fr && col == fc) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + d[i][0], nc = col + d[i][1];
                int endRow = nr + H - 1, endCol = nc + W - 1;
                if (!checkRange(nr, nc) || !checkRange(endRow, endCol)) {
                    continue;
                }
                if (!checkWall(nr, nc, endRow, endCol)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, count + 1});

            }
        }

        return -1;
    }

    private static boolean checkWall(int sr, int sc, int er, int ec) {

        int sum = ps[er][ec] - ps[sr - 1][ec] - ps[er][sc - 1] + ps[sr - 1][sc - 1];

        return sum == 0;
    }

    private static boolean checkRange(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > M) {
            return false;
        }

        return true;
    }
}



