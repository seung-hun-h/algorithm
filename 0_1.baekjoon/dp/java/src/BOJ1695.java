import java.io.*;
import java.util.*;
public class BOJ1695 {
    private static int N;
    private static int[] arr;
    private static int[][] dp;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        dfs(0, N - 1);
        System.out.println(dp[0][N - 1]);

    }

    private static int dfs(int left, int right) {
        if (left >= right) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        if (arr[left] == arr[right]) {
            dp[left][right] = dfs(left + 1, right - 1);
        } else {
            dp[left][right] = Math.min(dfs(left + 1, right), dfs(left, right - 1)) + 1;
        }

        return dp[left][right];
    }

}