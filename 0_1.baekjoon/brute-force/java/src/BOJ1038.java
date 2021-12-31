import java.io.*;

public class BOJ1038 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        long result = findNthDecreasedNumber(N);
        System.out.println(result);
    }

    private static long findNthDecreasedNumber(int n) {
        if (n <= 9) {
            return n;
        }
        int R = 11;
        int C = 10;
        int K = 10000;
        long[][][] dp = new long[R][C][K];

        for (int i=0;i<R;i++) {
            for (int j=0;j<C;j++) {
                for (int k=0;k<K;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        for (int i=0;i<C;i++) {
            dp[1][i][0] = i;
        }

        int seq = 9;
        
        for (int i=2;i<R;i++) {
            for (int j=i-1;j<C;j++) {
                int idx = 0, k = 0;
                while (dp[i][j-1][k] != -1) {
                    dp[i][j][idx++] = dp[i][j-1][k++] + (long)Math.pow(10, i-1);
                    seq++;
                    if (seq == n)
                        return dp[i][j][idx-1];
                }

                k = 0;
                
                while (dp[i-1][j-1][k] != -1) {
                    dp[i][j][idx++] = dp[i-1][j-1][k++] + j * (long)Math.pow(10, i-1);
                    seq++;
                    if (seq == n)
                        return dp[i][j][idx-1];
                }
            }
        }

        return -1;
    }
}
