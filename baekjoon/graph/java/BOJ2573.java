import java.io.*;
import java.util.*;

public class BOJ2573 {
    static int[][] board;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve());
    }
    private static int solve() {
        boolean flag = true;    
        int year = 1;    
        while (flag) {
            flag = false;
            int[][] count = new int[N][M];

            for (int r=0;r<N;r++) {
                for (int c=0;c<M;c++) {
                    if (board[r][c] != 0) continue;

                    for (int i=0;i<4;i++) {
                        int nr = r + dr[i], nc = c + dc[i];
                        if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                            if (board[nr][nc] != 0) {
                                count[nr][nc]++;
                                flag = true;
                            }
                        }
                    }
                }
            }

            for (int r=0;r<N;r++) {
                for (int c=0;c<M;c++) {
                    if (count[r][c] == 0) continue;
                    
                    board[r][c] -= count[r][c];
                    
                    if (board[r][c] < 0)
                        board[r][c] = 0;
                }
            }

            boolean[][] visited = new boolean[N][M];
            int result = 0;
            for (int r=0;r<N;r++) {
                for (int c=0;c<M;c++) {
                    if (board[r][c] != 0 && !visited[r][c]) {
                        dfs(r, c, visited);
                        result++;
                    }
                }

            }
            if (result >= 2)
                return year;
            year++;
        }
        return 0;

    }
    private static void bfs(int row, int col, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i=0;i<4;i++) {
                int nr = point[0] + dr[i], nc = point[1] + dc[i];

                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (!visited[nr][nc] && board[nr][nc] != 0) {
                        q.add(new int[] {nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }

    private static void dfs(int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        for (int i=0;i<4;i++) {
            int nr = row + dr[i], nc = col + dc[i];

            if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                if (!visited[nr][nc] && board[nr][nc] != 0) {
                    dfs(nr, nc, visited);
                }
            }
        }
    }
}
