import java.io.*;
import java.util.*;

public class BOJ20183 {
    static final long INF = (long)Math.pow(10, 14) + 1;
    static int N, M, A, B; 
    static long C;
    static Map<Integer, List<Edge>> graph;

    static class Edge {
        int node;
        long cost;

        Edge(int node, long cost) {
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
        C = Long.parseLong(st.nextToken());
        
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
        int rightMax = (int)Math.pow(10, 9) + 1;;
        int left = 0, right = rightMax;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (dijkstra(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right == rightMax ? -1 : right;
    }

    private static boolean dijkstra(int i) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.cost, e2.cost));
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);

        pq.add(new Edge(A, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (dist[curr.node] > curr.cost) {
                dist[curr.node] = curr.cost;

                for (Edge adj : graph.get(curr.node)) {
                    
                    if (adj.cost > i) continue;

                    long alt = dist[curr.node] + adj.cost;

                    if (dist[adj.node] > alt) {
                        pq.add(new Edge(adj.node, alt));
                    }
                }
            }
        }

        return dist[B] <= C;
    }
}
