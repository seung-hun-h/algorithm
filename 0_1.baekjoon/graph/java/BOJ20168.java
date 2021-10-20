import java.io.*;
import java.util.*;

class BOJ20168 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, A, B, C;
    static Map<Integer, List<Edge>> graph;

    static class Edge {
        int node;
        int cost;

        Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    
    static class Path {
        int node;
        int maxCost;
        int remain;
        int visited;

        Path(int node, int maxCost, int remain, int visited) {
            this.node = node;
            this.maxCost = maxCost;
            this.remain = remain;
            this.visited = visited;
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
        int ans = INF;

        Queue<Path> q = new LinkedList<>();
        q.add(new Path(A, 0, C, 1 << A));

        while (!q.isEmpty()) {
            Path path = q.poll();

            if (ans <= path.maxCost)
                continue;

            if (path.node == B) {
                ans = Math.min(ans, path.maxCost);
                continue;
            }

            for (Edge adj : graph.get(path.node)) {

                if ((path.visited & (1 << adj.node)) == 0 && path.remain - adj.cost >= 0) {
                    q.add(new Path(adj.node, Math.max(path.maxCost, adj.cost), path.remain - adj.cost, path.visited | (1 << adj.node)));
                }
            }
        }

        return ans == INF ? -1 : ans;
    }
}
