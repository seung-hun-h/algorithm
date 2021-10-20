import java.io.*;
import java.util.*;

public class BOJ14938 {
    static class Edge {
        int node;
        int dist;
        Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    static final int INF = 100;
    static int n, m, r;
    static Map<Integer, List<Edge>> graph;
    static int[] items;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new HashMap<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];


        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            items[i + 1] = Integer.parseInt(st.nextToken());
        }
        
        for (int i=0;i<r;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(x, new ArrayList<>());
            graph.putIfAbsent(y, new ArrayList<>());
        
            graph.get(x).add(new Edge(y, w));
            graph.get(y).add(new Edge(x, w));
        }

        int max = 0;
        for (int i=1;i<=n;i++) {
            max = Math.max(max, bfs(i));
        }

        System.out.println(max);
    }
    private static int bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Edge> q = new PriorityQueue<>((e1, e2) -> e1.dist - e2.dist);
        q.add(new Edge(start, 0));
        int result = 0;
        
        while (!q.isEmpty()) {
            Edge current = q.poll();
            
            if (dist[current.node] == INF) {
                dist[current.node] = current.dist;
                
                if (current.dist <= m)
                    result += items[current.node];
                
                for (Edge adj : graph.getOrDefault(current.node, new ArrayList<>())) {
                    int alt = current.dist + adj.dist;
                    
                    if (dist[adj.node] == INF)
                        q.add(new Edge(adj.node, alt));
                }
            }

        }
        return result;
    }
}
