import java.io.*;
import java.util.*;

class BOJ20182_dijkstra {
    static final int INF = 1000000000;
    static int N, M, A, B; 
    static int C;
    static Map<Integer, List<Edge>> graph;

    static class Edge {
        int node;
        int cost;

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

        System.out.println(solve());
        
    }

    private static int solve() {
        for (int i=0;i<=20;i++) {
            if (dijkstra(i)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean dijkstra(int i) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        pq.add(new Edge(A, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (dist[curr.node] > curr.cost) {
                dist[curr.node] = curr.cost;

                for (Edge adj : graph.get(curr.node)) {
                    
                    if (adj.cost > i) continue;

                    int alt = dist[curr.node] + adj.cost;

                    if (dist[adj.node] > alt) {
                        pq.add(new Edge(adj.node, alt));
                    }
                }
            }
        }

        return dist[B] <= C;
    }
}