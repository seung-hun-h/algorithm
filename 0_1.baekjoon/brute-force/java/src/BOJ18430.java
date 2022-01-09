import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ18430 {
    private static int N, M;
    private static int[][] board;
    public static void main(String[] args) throws Exception {
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
    private static int answer = 0;
    private static int[][][] pieces = {{{2, 1},
        {1, 0}},
        {{1, 2},
            {0, 1}},
        {{0, 1},
            {1, 2}},
        {{1, 0},
            {2, 1}}};
    private static int solve() {
        boolean[][] visited = new boolean[N][M];

        dfs(visited, 0, 0);
        return answer;
    }

    private static void dfs(boolean[][] visited, int result, int idx) {
        if (idx == N*M) {
            answer = Math.max(answer, result);
            return;
        }

        int row = idx / M;
        int col = idx % M;

        dfs(visited, result, idx + 1);

        for (int[][] piece : pieces) {
            if (!check(row, col, visited, piece)) continue;
            fill(visited, true, row, col, piece);
            int s = calcSolidity(row, col, piece);
            dfs(visited, result + s, idx + 1);
            fill(visited, false, row, col, piece);
        }

    }

    private static int calcSolidity(int row, int col, int[][] piece) {
        int result = 0;
        for (int i=0;i<2;i++) {
            for (int j=0;j<2;j++) {
                result += (piece[i][j] * board[row+i][col+j]);
            }
        }

        return result;
    }

    private static void fill(boolean[][] visited, boolean value, int row, int col, int[][] piece) {
        for (int i=row;i<row + 2;i++) {
            for (int j=col;j<col + 2;j++) {
                if (piece[i-row][j-col] == 0) continue;
                visited[i][j] = value;
            }
        }
    }

    private static boolean check(int row, int col, boolean[][] visited, int[][] piece) {
        for (int i=row;i<row + 2;i++) {
            for (int j=col;j<col + 2;j++) {
                if (!checkRange(i, j)) return false;
                if (piece[i-row][j-col] == 0) continue;
                if (visited[i][j]) return false;
            }
        }
        return true;
    }

    private static boolean checkRange(int row, int col) {
        return row < N && col < M;
    }
}
