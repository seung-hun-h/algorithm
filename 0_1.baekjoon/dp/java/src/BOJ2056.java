import java.io.*;
import java.util.*;

public class BOJ2056 {
    private static int[] indegree;
    private static int[] spend;
    private static int[] dp;
    private static Map<Integer, List<Integer>> graph;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        indegree = new int[N + 1];
        spend = new int[N + 1];
        graph = new HashMap<>();
        dp = new int[N + 1];

        List<Integer> roots = new ArrayList<>();
        for (int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            spend[i] = weight;

            int previous = Integer.parseInt(st.nextToken());
            indegree[i] = previous;

            while (previous-- > 0) {
                int parent = Integer.parseInt(st.nextToken());
                graph.putIfAbsent(parent, new ArrayList<>());
                graph.get(parent).add(i);
            }

            if (indegree[i] == 0) {
                roots.add(i);
            }
        }

        for (int root : roots) {
            topologySort(root);
        }

        int max = 0;
        for (int i=1;i<=N;i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    private static void topologySort(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dp[start] = spend[start];
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int adj : graph.getOrDefault(node, new ArrayList<>())) {
                if (indegree[adj] == 0) continue;
                indegree[adj]--;
                dp[adj] = Math.max(dp[adj], dp[node]);
                if (indegree[adj] == 0) {
                    dp[adj] += spend[adj];
                    q.add(adj);
                }
            }
        }
    }
}