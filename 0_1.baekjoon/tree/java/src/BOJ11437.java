import java.util.*;
import java.io.*;

public class BOJ11437 {
    static Map<Integer, List<Integer>> tree;
    static int[] nodesDepth;
    static int[] parent;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        nodesDepth = new int[N + 1];
        parent = new int[N + 1];

        for (int i=1;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            tree.putIfAbsent(n, new ArrayList<>());
            tree.putIfAbsent(m, new ArrayList<>());

            tree.get(n).add(m);
            tree.get(m).add(n);
        }

        dfs(1, 1);
        
        int M = Integer.parseInt(br.readLine());

        for (int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(lca(a, b));
        }
    }

    private static int lca(int n, int m) {

        while (nodesDepth[n] != nodesDepth[m]) {
            if (nodesDepth[n] > nodesDepth[m]) {
                n = parent[n];
            } else {
                m = parent[m];
            }
        }

        while (n != m) {
            n = parent[n];
            m = parent[m];
        }        

        return n;
    }

    private static void dfs(int node, int depth) {
        nodesDepth[node] = depth;

        for (int adj : tree.get(node)) {
            if (nodesDepth[adj] == 0) {
                parent[adj] = node;
                dfs(adj, depth + 1);
            }
        }
    }
}
