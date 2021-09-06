import java.util.*;
class KAKAO33 {
    class Edge {
        int node;
        int cost;
        
        Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    
    boolean[] Traps;    
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        
        Traps = new boolean[n + 1];
        Map<Integer, List<Edge>> graph = new HashMap<>();
        Map<Integer, List<Edge>> reverseGraph = new HashMap<>();
        
        for (int trap : traps) {
            Traps[trap] = true;
        }
        
        for (int[] road : roads) {
            int v = road[0];
            int m = road[1];
            int cost = road[2];
            
            graph.putIfAbsent(v, new ArrayList<>());
            reverseGraph.putIfAbsent(m, new ArrayList<>());
            
            graph.get(v).add(new Edge(m, cost));
            reverseGraph.get(m).add(new Edge(v, cost));
        }
        
        int cost = 0;
        while (true) {
            System.out.println(start);
            Edge edge = bfs(graph, start, end);
            cost += edge.cost;
            if (edge.node == end)
                return cost;
            
            start = edge.node;
            edge = bfs(reverseGraph, start, end);
            
            cost += edge.cost;
            if (edge.node == end)
                return cost;
            
            start = edge.node;
        }
        
    }
    
    public Edge bfs(Map<Integer, List<Edge>> graph, int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
        pq.add(new Edge(start, 0));
        
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (edge.node == end || (edge.node != start && Traps[edge.node])) {
                return edge;
            }
            
            for(Edge adj : graph.getOrDefault(edge.node, new ArrayList<>())) {
                pq.add(new Edge(adj.node, edge.cost + adj.cost));
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[][] roads = {{1,2,1}, {3,2,1}, {2, 4, 1}};
        int[] traps = {2, 3};
        int result = new KAKAO33().solution(4, 1, 4, roads, traps);
        System.out.println(result);
    }
}
