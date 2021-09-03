import java.io.*;
import java.util.*;
public class BOJ1719_2 {
    static class Edge {
        int node;
        int weight;
        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    
    static final int INF = 100000000;
    static Map<Integer, List<Edge>> graph;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(x, new ArrayList<>());
            graph.putIfAbsent(y, new ArrayList<>());

            graph.get(x).add(new Edge(y, c));
            graph.get(y).add(new Edge(x, c));
        }

        for (int i=1;i<=n;i++) {
            dijkstra(i);
        }
    }
    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        int[] dist = new int[n + 1];
        int[] trace = new int[n + 1];
        Arrays.fill(dist, INF);

        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            
            if (current.weight > dist[current.node]) continue;

            for (Edge adj : graph.get(current.node)) {
                int alt = current.weight + adj.weight;
                
                if (dist[adj.node] > alt) {
                    pq.add(new Edge(adj.node, alt));
                    dist[adj.node] = alt;
                    trace[adj.node] = current.node;
                }
            }
        }
        findAdjacent(start, trace);
    }
    private static void findAdjacent(int start, int[] trace) {
        
        for (int i=1;i<=n;i++) {
            if (i == start) {
                System.out.print("- ");
                continue;
            }

            if (trace[i] == start) {
                System.out.print(i + " ");
                continue;
            }

            int node = i;
            while (trace[node] != start) {
                node = trace[node];
            }
            System.out.print(node + " ");
        }
        System.out.println();
        
    }
}