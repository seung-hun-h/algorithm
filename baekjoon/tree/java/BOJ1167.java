import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1167 {
    public static class Edge {
        private int node;
        private int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return this.node;
        }

        public int getWeight() {
            return this.weight;
        }

        public String toString() {
            return node + " " + weight;
        }
    }
    static Map<Integer, List<Edge>> tree;
    static int u;
    static long max;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        tree = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            tree.putIfAbsent(node, new ArrayList<>());
            while (true) {
                int n2 = Integer.parseInt(st.nextToken());
                if (n2 == -1) // 입력 때매 ㅜㅜ
                    break;
                int w = Integer.parseInt(st.nextToken());
                
                tree.get(node).add(new Edge(n2, w));
            }
        }
        u = 1;   
        boolean[] visited = new boolean[n+1];
        dfs(u, visited, 0);
        visited = new boolean[n+1];
        dfs(u, visited, 0);
        System.out.println(max);
    }

    public static void dfs(int node, boolean[] visited, long value) {
        visited[node] = true;

        if (value > max) {
            max = value;
            u = node;
        }

        for (Edge adj : tree.get(node)) {
            if (!visited[adj.getNode()]) {
                dfs(adj.getNode(), visited, value + adj.getWeight());
            }
        }
    }
}