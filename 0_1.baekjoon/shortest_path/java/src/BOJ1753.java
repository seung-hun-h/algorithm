import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ1753 {
    static class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    static final int INF = 100000000;
    static Map<Integer, ArrayList<Edge>> graph;
    static int[] dist;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken()); 
        int start = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        dist = new int[V + 1];


        for (int i=0;i<=V;i++) {
            dist[i] = INF;
        }

        for (int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(n, new ArrayList<>());
            graph.get(n).add(new Edge(m, w));
        }

        dijkstra(start);

        for (int i=1;i<=V;i++) {
            System.out.println(dist[i] != INF ? dist[i] : "INF");
        }
    }
    private static void dijkstra(int start) {
 
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            if (edge.weight > dist[edge.node])
                continue;

            for (Edge adj : graph.getOrDefault(edge.node, new ArrayList<>())) {
                int alt = edge.weight + adj.weight;

                if (dist[adj.node] > alt) {
                    dist[adj.node] = alt;
                    pq.add(new Edge(adj.node, alt));
                }
            }
        }
    }
}