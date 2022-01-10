import java.io.*;
import java.util.*;

public class BOJ1761 {
    static Map<Integer, List<Edge>> tree;
    static int[] dist;
    static int[] depth;
    static int[][] parent;
    static final int LOG = 16;
    static int N;

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        parent = new int[N + 1][LOG];
        depth = new int[N + 1];
        dist = new int[N + 1];

        for (int i = 1;i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree.putIfAbsent(n, new ArrayList<>());
            tree.putIfAbsent(m, new ArrayList<>());

            tree.get(n).add(new Edge(m, c));
            tree.get(m).add(new Edge(n, c));
            
        }
        setParent();

        int M = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dist[start] + dist[end] - 2 * dist[lca(start, end)]).append("\n");

        }
        System.out.println(sb);
    }

    private static int lca(int n, int m) {
        int a = depth[n] > depth[m] ? n : m;
        int b = depth[n] > depth[m] ? m : n;

        for (int i = LOG - 1; i >= 0;i--) {
            if (depth[a] - depth[b] >= (1 << i)) {
                a = parent[a][i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = LOG - 1; i >= 0;i--) {
            
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }

    private static void dfs(int node, int d, int p, int w) {
        depth[node] = d;

        for (Edge child : tree.get(node)) {
            if (child.to == p) continue;            

            parent[child.to][0] = node;
            dist[child.to] = w + child.weight;

            dfs(child.to, d + 1, node, dist[child.to]);
        }
    }

    public static void setParent() {
        dfs(1, 1, 0, 0);
        for (int i = 1; i < LOG; i++) {
            for (int node = 1; node <= N; node++) {
                parent[node][i] = parent[parent[node][i - 1]][i - 1];
            }
        }
    }
}
