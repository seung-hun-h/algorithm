import java.io.*;
import java.util.*;
public class BOJ1956 {

    private static final int INF = 50000000;
    private static int V, E;
    private static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];

        for (int i=0;i<=V;i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            dist[u][v] = e;
        }


        for (int k=1;k<=V;k++) {
            for (int i=1;i<=V;i++) {
                if (i == k) continue;
                for (int j=1;j<=V;j++) {
                    if (dist[i][k] == INF || dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int answer = INF;
        for (int i=1;i<=V;i++) {
            answer = Math.min(answer, dist[i][i]);
        }

        System.out.println(answer == INF ? -1 : answer);
        br.close();

    }
}