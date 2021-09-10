import java.util.*;
import java.io.*;
public class BOJ11438 {
    static final int LOG = 21;
    static Map<Integer, List<Integer>> tree;
    static int[] depth;
    static int[][] parent;
    static int N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        tree = new HashMap<>();
        depth = new int[N + 1];
        parent = new int[N + 1][LOG];

        for (int i = 1;i < N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            tree.putIfAbsent(n, new ArrayList<>());
            tree.putIfAbsent(m, new ArrayList<>());

            tree.get(n).add(m);
            tree.get(m).add(n);
        }

        setParent();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(lca(n, m));
        }

        for (int[] p : parent) {
            System.out.println(Arrays.toString(p));
        }
    }

    private static int lca(int n, int m) {
        int a = depth[n] > depth[m] ? n : m;
        int b = depth[n] > depth[m] ? m : n;

        for (int i = LOG - 1; i >= 0; i--) {
            if ((depth[a] - depth[b]) >= (1 << i))
                a = parent[a][i];
        }

        if (a == b)
            return a;
        
        for (int i = LOG - 1; i >= 0; i--) {

            if (parent[a][i] != parent[b][i]){
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }

    private static void setParent() {
        dfs(1, 1);

        for (int i = 1; i < LOG; i++) {
            for (int node = 1; node <= N; node++) {
                int p = parent[parent[node][i - 1]][i -1];
                parent[node][i] = p;
            }
        }
    }

    private static void dfs(int node, int d) {
        depth[node] = d;

        for (int adj : tree.get(node)) {
            if (depth[adj] == 0) {
                parent[adj][0] = node;
                dfs(adj, d + 1);
            }
        }
    }
}
