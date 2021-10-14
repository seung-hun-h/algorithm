import java.io.*;
import java.util.*;

class BOJ21278 {
    static final int INF = 1000000000;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] dist = new int[N + 1][N + 1];

        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                if (i == j) continue;
                dist[i][j] = INF;
            }
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dist[u][v] = 1;
            dist[v][u] = 1;
        }

        for (int k=1;k<=N;k++){
            for (int i=1;i<=N;i++) {
                for (int j=1;j<=N;j++) {
                    if (i == j) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }


        int ans = INF;
        int c1 = 0, c2 = 0;
        for (int i=1;i<=N;i++) {
            for (int j=i+1;j<=N;j++) {
                int current = 0;
                for (int k=1;k<=N;k++){
                    if (i == k || j == k) continue;
                    
                    current += Math.min(dist[i][k], dist[j][k]);
                }

                if (current < ans) {
                    c1 = i;
                    c2 = j;
                    ans = current;
                }
            }
        }

        System.out.println(c1 +" " + c2 +" "+ (ans*2));

    }
}