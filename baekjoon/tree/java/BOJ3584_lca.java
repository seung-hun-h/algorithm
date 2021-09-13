import java.util.*;
import java.io.*;
public class BOJ3584_lca {
    static final int LOG = 21;
    static int N;
    static Map<Integer, List<Integer>> tree; 
    static Set<Integer> children; 
    static int[] depth;
    static int[][] parent;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<T;i++) {

            N = Integer.parseInt(br.readLine());
            
            tree = new HashMap<>();
            children = new HashSet<>();

            depth = new int[N + 1];
            parent = new int[N + 1][LOG];
            

            for (int j=1;j<N;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                tree.putIfAbsent(a, new ArrayList<>());
                tree.get(a).add(b);
                children.add(b);
            }

            int root = findRoot();
            
            setParent(root);

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            sb.append(lca(node1, node2)).append("\n");
        }

        System.out.println(sb);

    }

    private static int lca(int n, int m) {
        int a = depth[n] > depth[m] ? n : m;
        int b = depth[n] > depth[m] ? m : n;

        for (int i=LOG-1;i>=0;i--) {
            if (depth[a] - depth[b] >= (1 << i)) {
                a = parent[a][i];
            }
        }

        if (a == b)
            return a;


        for (int i=LOG-1;i>=0;i--) {
            
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        } 
        
        return parent[a][0];
    }

    private static void setParent(int root) {
        dfs(root, 1);


        for (int i=1;i<LOG;i++) {
            for (int node=1;node<=N;node++) {
                parent[node][i] = parent[parent[node][i - 1]][i - 1];
            }
        }
    }

    private static void dfs(int node, int d) {
        depth[node] = d;

        for (int child : tree.getOrDefault(node, new ArrayList<>())) {
            parent[child][0] = node;
            dfs(child, d + 1);
        }
    }

    private static int findRoot() {
        for (int i = 1; i <= N; i++) {
            if (!children.contains(i))
                return i;
        }

        return -1;
    }

    private static void findPath(int[] parent, int node, List<Integer> path) {

        path.add(node);

        if (parent[node] == 0)
            return;

        findPath(parent, parent[node], path);
    }
}
