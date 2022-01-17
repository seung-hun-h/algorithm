import java.util.*;
import java.io.*;

public class BOJ17069 {
    static int N;
    static int[][] map;
    static long[][][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        dp = new long[3][N+1][N+1];
    
        for(int i=1;i<N+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][2] = 1;

        for(int r=1;r<=N;r++){
            for(int c=1;c<=N;c++){
                if(r == 1 && c == 1) continue;
                if(c < N && map[r][c+1] != 1){
                    dp[0][r][c+1] = dp[0][r][c] + dp[1][r][c];
                }

                if(r < N && map[r+1][c] != 1){
                    dp[2][r+1][c] = dp[1][r][c] + dp[2][r][c];
                }

                if(r < N && c < N && map[r+1][c] != 1 && map[r][c+1] != 1 && map[r+1][c+1] != 1){
                    dp[1][r+1][c+1] = dp[0][r][c] + dp[1][r][c] + dp[2][r][c];
                }
            }
        }

        System.out.println(dp[0][N][N] + dp[1][N][N] + dp[2][N][N]);
    }
}