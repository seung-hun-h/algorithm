import java.io.*;
import java.util.*;
public class BOJ1719 {
    static final int INF = 100000000;
    static int[][] dp;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        dp = new int[n + 1][n + 1];
        graph = new int[n + 1][n + 1];

        for (int i=0;i<=n;i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
        
            dp[x][y] = c;
            dp[y][x] = c;

            graph[x][y] = y;
            graph[y][x] = x;
        }

        
        for (int k=1;k<=n;k++) {
            for (int i=1;i<=n;i++) {
                for (int j=1;j<=n;j++){
                    if (i == j) continue;

                    if (dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        
                        graph[i][j] = graph[i][k];
                    }
                }
            }
        }

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (graph[i][j] == 0){
                    System.out.print("- ");
                    continue;
                } 
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}