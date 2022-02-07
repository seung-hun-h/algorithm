import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14728 {
    private static int N, T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[] dp = new int[T + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for (int j = T; j >= k; j--) {
                dp[j] = Math.max(dp[j], dp[j - k] + s);
            }
        }
        System.out.println(dp[T]);
    }
}
