import java.io.*;
import java.util.*;

public class BOJ18427 {
    private static final int MOD = 10007;
    private static int N, M, H;
    private static int[][] blocks;
    private static int[][] dp;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dp = new int[N][H + 1];
        blocks = new int[N][];

        for (int i=0;i<N;i++) {
            String[] line = br.readLine().split(" ");
            blocks[i] = new int[line.length];

            for (int j=0;j<line.length;j++) {
                blocks[i][j] = Integer.parseInt(line[j]);
            }
            dp[i][0] = 1;
            for (int j=0;j<=H;j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, H));
    }

    private static int dfs(int idx, int height) {
        if (height == 0) return 1;
        if (height < 0) return 0;
        if (idx == N) return 0;
        if (dp[idx][height] != -1) return dp[idx][height];


        dp[idx][height] = dfs(idx + 1, height);
        for (int block : blocks[idx]) {
            dp[idx][height] += dfs(idx + 1, height - block);
        }

        dp[idx][height] %= MOD;
        return dp[idx][height];
    }
}
/***
 * dp[h] = 높이 h를 만들 수 있는 블럭의 수
 * blocks[n][m] = n 학생이 가지고 있는 m번째 블럭의 높이
 *
 * dfs(int idx, int h):
 *  if (idx == N || h < 0):
 *      return 0
 * if (dp[h] != 0):
 *      return dp[h]
 *
 * for (int block : blocks[idx]):
 *      dp[h] += dfs(idx + 1, h - block)
 *
 * dp[h] += dfs(idx + 1, h)
 *
 * return dp[h];
 */