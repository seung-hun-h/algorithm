import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14391 {

    static int N, M;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int idx, int check) {
        if (idx == (N * M)) {
            return getScore(check);
        }

        int result = dfs(idx + 1, check | (1 << idx)); // 가로
        result = Math.max(result, dfs(idx + 1, check)); // 세로

        return result;
    }

    private static int getScore(int visited) {
        int total = 0;

        for (int i = 0; i < N; i++) {
            int horizon = 0;
            for (int j = 0; j < M; j++) {
                if ((visited & (1 << (i * M + j))) != 0) {
                    horizon *= 10;
                    horizon += board[i][j];
                } else {
                    total += horizon;
                    horizon = 0;
                }
            }
            total += horizon;
        }

        for (int j = 0; j < M; j++) {
            int vertical = 0;
            for (int i = 0; i < N; i++) {
                if ((visited & (1 << (i * M + j))) == 0) {
                    vertical *= 10;
                    vertical += board[i][j];
                } else {
                    total += vertical;
                    vertical = 0;
                }
            }
            total += vertical;
        }

        return total;
    }
}
