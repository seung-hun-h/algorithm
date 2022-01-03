import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18808 {
    private static int N, M, K;
    private static int[][][] stickers;
    private static int[][] laptop;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        laptop = new int[N][M];
        stickers = new int[K][][];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

            stickers[i] = new int[r][c];

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    stickers[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(countAttachedBlocks());
    }

    private static int countAttachedBlocks() {
        for (int[][] sticker : stickers) {
            for (int i = 0; i < 4; i++) {
                if (attach(sticker)) {
                    break;
                }
                sticker = rotate(sticker);
            }
        }

        return count();
    }

    private static int count() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (laptop[i][j] != 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int[][] rotate(int[][] sticker) {
        int m = sticker[0].length;
        int n = sticker.length;
        int[][] temp = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][n - i - 1] = sticker[i][j];
            }
        }

        return temp;
    }

    private static boolean attach(int[][] sticker) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isAttachable(i, j, sticker)) {
                    attach(i, j, sticker);
                    return true;
                }
            }
        }
        return false;
    }

    private static void attach(int row, int col, int[][] sticker) {
        int n = sticker.length;
        int m = sticker[0].length;

        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + m; j++) {
                if (sticker[i - row][j - col] == 1) {
                    laptop[i][j] = 1;
                }
            }
        }
    }

    private static boolean isAttachable(int row, int col, int[][] sticker) {

        int n = sticker.length;
        int m = sticker[0].length;

        if (row + n > N || col + m > M) {
            return false;
        }

        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + m; j++) {
                if (sticker[i - row][j - col] == 1 && laptop[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

}
