import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());

        int[][] cargo = new int[N][];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cargo[i] = new int[] {Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())};
        }

        int[][] dp = new int[N+1][K+1];

        for (int i=1;i<=N;i++) {
            for (int j=1;j<=K;j++) {
                if (cargo[i-1][0] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], cargo[i-1][1] + dp[i-1][j - cargo[i-1][0]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
