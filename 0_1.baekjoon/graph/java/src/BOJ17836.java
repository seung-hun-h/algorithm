import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17836 {
    private static final int PATH = 0;
    private static final int WALL = 1;
    private static final int GRAM = 2;

    private static int N, M, T;
    private static int[][] board;
    private static int[][] d = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer =  bfs();
        System.out.println(answer == -1 ? "Fail" : answer);
    }

    private static int bfs() {
        boolean[][][] visited = new boolean[N][M][2];
        Queue<int[]> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.add(new int[] {0, 0, 0, 0});

        while (hasElement(q)) {
            int row = q.peek()[0];
            int col = q.peek()[1];
            int gram = q.peek()[2];
            int spend = q.poll()[3];

            if (row == N - 1 && col == M - 1) {
                return spend <= T ? spend : -1;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + d[i][0], nc = col + d[i][1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (visited[nr][nc][gram]) continue;

                if (board[nr][nc] == WALL) {
                    if (gram == 1) {
                        visited[nr][nc][gram] = true;
                        q.add(new int[]{nr, nc, gram, spend + 1});
                    }
                } else if (board[nr][nc] == GRAM) {
                    visited[nr][nc][1] = true;
                    q.add(new int[]{nr, nc, 1, spend + 1});
                } else {
                    visited[nr][nc][gram] = true;
                    q.add(new int[]{nr, nc, gram, spend + 1});
                }

            }
        }

        return -1;
    }

    private static boolean hasElement(Queue<int[]> q) {
        return !q.isEmpty();
    }
}
