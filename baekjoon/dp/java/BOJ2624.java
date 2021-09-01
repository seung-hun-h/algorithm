import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] counts = new int[k][2];

        for (int i=0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            counts[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int[][] dp = new int[k+1][T+1];
        dp[0][0] = 1;

        for (int i=1;i<=k;i++) {
            int coin = counts[i-1][0];
            int limit = counts[i-1][1];
            for (int j=0;j<=T;j++){
                dp[i][j] = dp[i-1][j];
            }
            for (int count=1;count<=limit;count++) {
                for (int money=coin*count;money<=T;money++) {
                    dp[i][money] += dp[i-1][money - count*coin];
                }
            }
        }
        System.out.println(dp[k][T]);
    }
}
