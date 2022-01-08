/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1799 {
    private static int[] answer = {0, 0};
    private static int[][] d = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private static final int BISHOP = 2;
    private static final int BLACK = 0;
    private static final int WHITE = 1;
    private static int N;
    private static int[][] board;
    private static int[][] colors;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        colors = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        colors[i][j] = BLACK;
                    } else {
                        colors[i][j] = WHITE;
                    }
                } else {
                    if (j % 2 == 0) {
                        colors[i][j] = WHITE;
                    } else {
                        colors[i][j] = BLACK;
                    }
                }
            }
        }

        System.out.println(solve());
    }

    private static int solve() {
        go(-1, 0, BLACK);
        go(-1, 0, WHITE);
        return answer[BLACK] + answer[WHITE];
    }

    private static void go(int n, int count, int color) {
        answer[color] = Math.max(answer[color], count);

        for (int i = n + 1; i < N * N; i++) {
            int row = i / N;
            int col = i % N;

            if (colors[row][col] != color) {
                continue;
            }
            if (board[row][col] != 1) {
                continue;
            }
            go(i, count, color);

            if (check(row, col)) {
                board[row][col] = BISHOP;
                go(i, count + 1, color);
                board[row][col] = 1;
            }
        }
    }

    private static boolean check(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nr = row, nc = col;
            while (checkRange(nr, nc, N, N)) {
                if (board[nr][nc] == BISHOP) {
                    return false;
                }

                nr += d[i][0];
                nc += d[i][1];
            }
        }

        return true;
    }

    private static boolean checkRange(int row, int col, int height, int width) {
        return 0 <= row && row < height && 0 <= col && col < width;
    }
}
