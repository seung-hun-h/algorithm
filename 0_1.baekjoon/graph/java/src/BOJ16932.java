import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ16932 {
    private static int N, M;
    private static int[][] board;
    private static int[][] group;
    private static int[] size;
    private static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        group = new int[N][M];
        size = new int[N * M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }

    private static int solve() {
        int answer = 0;
        grouping();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    continue;
                }

                int result = 1;

                if (i - 1 >= 0) {
                    result += size[group[i - 1][j]];
                    set.add(group[i - 1][j]);
                }

                if (i + 1 < N && !set.contains(group[i + 1][j])) {
                    result += size[group[i + 1][j]];
                    set.add(group[i + 1][j]);
                }

                if (j - 1 >= 0 && !set.contains(group[i][j - 1])) {
                    result += size[group[i][j - 1]];
                    set.add(group[i][j - 1]);
                }

                if (j + 1 < M && !set.contains(group[i][j + 1])) {
                    result += size[group[i][j + 1]];
                }

                answer = Math.max(answer, result);
                set.clear();
            }
        }

        return answer;
    }

    private static void grouping() {
        boolean[][] visited = new boolean[N][M];
        int seq = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || board[i][j] == 0) {
                    continue;
                }
                groupingHelp(i, j, seq++, visited);
            }
        }
    }

    private static void groupingHelp(int row, int col, int seq, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        visited[row][col] = true;
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            row = q.peek()[0];
            col = q.poll()[1];

            group[row][col] = seq;
            size[seq]++;

            for (int i = 0; i < 4; i++) {
                int nr = row + d[i][0], nc = col + d[i][1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (board[nr][nc] == 0) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}
