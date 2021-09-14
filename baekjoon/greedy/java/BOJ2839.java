import java.io.*;

public class BOJ2839 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        solve2(N);
    }
    
    public static void solve2(int N) {
        int result = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                N -= 5;
            } else {
                N -= 3;
            }
            result++;
        }

        if (N < 0) {
            result = -1;
        }

        System.out.println(result);
    }

    public static void solve1(int N) {
        int[] dp = new int[50001];
        dp[3] = 1;
        dp[5] = 1;

        for (int i=6;i<N+1;i++) {
            if (dp[i-3] != 0) {
                dp[i] = dp[i - 3] + 1;
            }

            if (dp[i-5] != 0) {
                dp[i] = dp[i-5] + 1;
            }
        }

        System.out.println(dp[N] == 0 ? -1 : dp[N]);
    }
}
