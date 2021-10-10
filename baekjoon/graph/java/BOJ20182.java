import java.io.*;
import java.util.*;

class BOJ20182 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, A, B; 
    static int C;
    static Map<Integer, List<Edge>> graph;

    static class Edge {
        int node;
        int cost;
        int maxCost = 0;

        Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        graph = new HashMap<>();

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(n, new ArrayList<>());
            graph.putIfAbsent(m, new ArrayList<>());
    
            graph.get(n).add(new Edge(m, c));
            graph.get(m).add(new Edge(n, c));
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.maxCost, e2.maxCost));
        pq.add(new Edge(A, C));
        boolean[] visited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            visited[edge.node] = true;

            if (edge.node == B) {
                return edge.maxCost;
            }

            for (Edge adj : graph.get(edge.node)) {

                if (!visited[adj.node] && edge.cost - adj.cost >= 0) {
                    Edge newEdge = new Edge(adj.node, edge.cost - adj.cost);
                    newEdge.maxCost = Math.max(edge.maxCost, adj.cost);
                    pq.add(newEdge);
                }
            }
        }

        return -1;
    }
}