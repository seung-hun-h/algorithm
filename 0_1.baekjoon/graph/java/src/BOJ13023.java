import java.io.*;
import java.util.*;
public class BOJ13023 {
    private static int N, M;
    private static Map<Integer, List<Integer>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(solve());
    }

    private static int solve() {
        for (int i=0;i<N;i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            if (dfs(i, visited, 1)) {
                return 1;
            }
        }
        return 0;
    }

    private static boolean dfs(int node, boolean[] visited, int depth) {
        if (depth == 5) {
            return true;
        }

        for (int adj : graph.getOrDefault(node, new ArrayList<>())) {
            if (visited[adj]) continue;
            visited[adj] = true;
            if (dfs(adj, visited, depth + 1)) {
                return true;
            }
            visited[adj] = false;
        }
        return false;
    }
}
