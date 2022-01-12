import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
public class BOJ22868 {
    private static int N, M;
    private static Map<Integer, List<Integer>> graph;
    private static boolean[] path;
    private static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        graph = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        path = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());

        for (int key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }

        for (int i=0;i<=N;i++) {
            parent[i] = i;
        }

        System.out.println(solve(s, e));

    }

    private static int solve(int s, int e) {
        int answer = bfs(s, e);

        pathCheck(e);
        path[s] = false;
        path[e] = false;

        return answer + bfs(e, s);
    }

    private static void pathCheck(int node) {
        path[node] = true;
        if (parent[node] == node) {
            return;
        }

        pathCheck(parent[node]);
    }

    private static int bfs(int s, int e) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(new int[] {s, 0});
        visited[s] = true;

        while (!q.isEmpty()) {
            int node = q.peek()[0];
            int length = q.poll()[1];

            for (int adj : graph.getOrDefault(node, new ArrayList<>())) {
                if (visited[adj] || path[adj]) continue;

                parent[adj] = node;

                if (adj == e) {
                    return length + 1;
                }

                visited[adj] = true;
                q.add(new int[] {adj, length + 1});
            }
        }

        return -1;
    }
}
