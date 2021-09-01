import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2631 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] = 1;

            for (int j=0;j<i;j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        int ans = 0;
        for (int i=0;i<N;i++) {
            if (ans < dp[i]) {
                ans = dp[i];
            }
        }

        System.out.println(N - ans);
    }
}
