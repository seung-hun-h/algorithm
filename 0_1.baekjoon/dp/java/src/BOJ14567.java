import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14567 {

    private static int N, M;
    private static Map<Integer, List<Integer>> graph;
    private static int[] inDegree;
    private static int[] term;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();
        inDegree = new int[N + 1];
        term = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            inDegree[v]++;
        }

        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0 && !visited[i]) {
                topologySort(i, visited);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(term[i] + " ");
        }
    }

    private static void topologySort(int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        term[start] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int adj : graph.getOrDefault(node, new ArrayList<>())) {
                if (visited[adj] || inDegree[adj] == 0) {
                    continue;
                }

                term[adj] = Math.max(term[adj], term[node] + 1);
                inDegree[adj]--;

                if (inDegree[adj] == 0) {
                    q.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }
}
