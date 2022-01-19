import java.io.*;
import java.util.*;
public class BOJ17485 {
    private static final int INF = 200000001;
    private static int N, M;
    private static int[][] arr;
    private static int[][][] dp;
    private static int[][] d = {{-1, 0}, {-1, 1}, {-1, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()) + 1;
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M][3];

        for (int i=0;i<N - 1;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                for (int k=0;k<3;k++) {
                    if (i == 0) {
                        dp[i][j][k] = arr[i][j];
                    } else {
                        dp[i][j][k] = INF;
                    }
                }
            }
        }

        int answer = INF;
        for(int i=0;i<M;i++) {
            for (int j=0;j<3;j++) {
                answer = Math.min(answer, dfs(N - 1, i, j));
            }
        }

        System.out.println(answer);
    }

    private static int dfs(int row, int col, int dir) {

        if (dp[row][col][dir] != INF) {
            return dp[row][col][dir];
        }

        for (int i=0;i<3;i++) {
            if (dir == i) continue;
            int nr = row + d[i][0];
            int nc = col + d[i][1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

            dp[row][col][dir] = Math.min(dp[row][col][dir], dfs(nr, nc, i) + arr[row][col]);
        }

        return dp[row][col][dir];
    }
}

/**
 *
 * dfs(row, col) :
 *  if (!checkRange(row, col))
 *      return INF
 *  if (row == 0) :
 *      return arr[row][col]
 *  if (dp[row][col] != INF)
 *      return dp[row][col]
 *
 *  dp[row][col] = Math.min(dp[row][col], dfs(row - 1, col) + arr[row][col])
 *                                        dfs(row - 1, col - 1)
 *                                        dfs(row - 1, col + 1)
 */