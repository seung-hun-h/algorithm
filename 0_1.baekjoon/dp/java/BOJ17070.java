import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ17070 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][][] dp = new int[3][n][n];

        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0][1] = 1;

        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (arr[i][j] == 1 || (i ==0 && j == 1)) continue;
                
                if (j - 1 >= 0) {
                    dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1];
                }

                if (i - 1 >= 0) {
                    dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (arr[i-1][j] != 1 && arr[i][j-1] != 1)
                        dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
                }
            }
        }

        for (int[][] ds : dp) {
            for (int[] d : ds) {
                for (int s : d) {
                    System.out.print(s +" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        int result = dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1];
        System.out.println(result);
    }
}