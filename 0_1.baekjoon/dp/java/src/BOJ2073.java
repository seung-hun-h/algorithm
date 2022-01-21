import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2073 {
    private static int D, P;
    private static int[] dp;
    private static List<int[]> pipes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        pipes = new ArrayList<>();
        dp = new int[D + 1];
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pipes.add(new int[]{l, c});
        }

        dp[0] = Integer.MAX_VALUE;
        for (int i = 0; i < P; i++) {
            int[] pipe = pipes.get(i);
            for (int j = D; j >= 0; j--) {
                if (j - pipe[0] < 0) continue;
                dp[j] = Math.max(dp[j], Math.min(dp[j - pipe[0]], pipe[1]));
            }
        }

        System.out.println(dp[D]);
    }
}
