import java.io.*;
import java.util.*;
public class BOJ20542 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][m + 1];

        for (int i=0;i<=n;i++) {
            dp[i][0] = i;
        }

        for (int i=0;i<=m;i++) {
            dp[0][i] = i;
        }

        char[] result = br.readLine().toCharArray();
        char[] solution = br.readLine().toCharArray();

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=m;j++) {
                if (isMatched(result[i - 1], solution[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
            }
        }

        System.out.println(dp[n][m]);
    }

    private static boolean isMatched(char input, char target) {
        return input == target || (input == 'i' && (target == 'j' || target == 'l')) || (input == 'v' && target == 'w');
    }

}