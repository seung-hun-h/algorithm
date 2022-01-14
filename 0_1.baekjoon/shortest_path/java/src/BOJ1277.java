import java.io.*;
import java.util.*;
public class BOJ1277 {
    private static int N, M;
    private static double W;
    private static double[][] dist;
    private static Map<Integer, int[]> pointMap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        W = Double.parseDouble(br.readLine());

        pointMap = new HashMap<>();
        dist = new double[N + 1][N + 1];

        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            pointMap.put(i, new int[] {row, col});
        }

        for (int i=1;i<=N;i++) {
            for (int j=i + 1;j<=N;j++) {
                dist[i][j] = getDist(i, j);
                dist[j][i] = dist[i][j];
            }
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dist[u][v] = 0;
            dist[v][u] = 0;
        }

        System.out.println(solve());
    }

    private static double getDist(int node1, int node2) {
        int row1 = pointMap.get(node1)[0], col1 = pointMap.get(node1)[1];
        int row2 = pointMap.get(node2)[0], col2 = pointMap.get(node2)[1];

        return Math.sqrt(Math.pow(Math.abs(row1 - row2), 2.0) + Math.pow(Math.abs(col1 - col2), 2.0));
    }

    private static int solve() {
        double result = getMinWireLength(1);

        return (int) (result * 1000);
    }

    private static double getMinWireLength(int start) {
        double[] dp = new double[N + 1];

        Arrays.fill(dp, Double.MAX_VALUE);

        PriorityQueue<Plant> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p1.wire, p2.wire));

        dp[start] = 0;
        pq.add(new Plant(start, 0.0));

        while (!pq.isEmpty()) {
            Plant plant = pq.poll();

            if (plant.wire > dp[plant.idx]) {
                continue;
            }


            for (int i=1;i<=N;i++) {
                if (i == plant.idx) continue;
                double alt = plant.wire + dist[plant.idx][i];

                if (dp[i] > alt) {
                    dp[i] = alt;
                    pq.add(new Plant(i, alt));
                }
            }
        }

        return dp[N];
    }

    static class Plant {
        int idx;
        double wire;

        Plant(int idx, double wire) {
            this.idx = idx;
            this.wire = wire;
        }
    }
}
