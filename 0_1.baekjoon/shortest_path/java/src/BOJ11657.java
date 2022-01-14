
import java.util.*;
import java.io.*;

public class BOJ11657 {

    private static final long INF = 9999999999L;
    private static int N, M;
    private static Map<Integer, List<int[]>> graph;
    private static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        graph = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new int[]{to, weight});
        }

        System.out.println(solve());
    }

    private static String solve() {
        if (hasNegativeCycle()) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
        }

        return sb.toString();
    }

    private static boolean hasNegativeCycle() {
        return bellManFord(1);
    }

    private static boolean bellManFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0L;

        for (int i = 0; i < N; i++) {
            for (int node = 1; node <= N; node++) {
                if (dist[node] == INF) {
                    continue;
                }

                for (int[] edge : graph.getOrDefault(node, new ArrayList<>())) {
                    long alt = dist[node] + edge[1];

                    if (dist[edge[0]] > alt) {
                        dist[edge[0]] = alt;

                        if (i == N - 1) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
