import java.util.*;
public class LEET743 {
    public static void main(String[] args) {
        int[][] times = {{1,2,1},{2,3,1},{1,3,4}};
        int n = 3; int k = 1;
        int res = networkDelayTime(times, n, k);
        System.out.println(res);
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> graph = new HashMap<>();
        for(int[] time : times){
            if(!graph.containsKey(time[0])){
                graph.put(time[0], new ArrayList<>());
            }
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                                    (edge1, edge2) -> edge1[0]-edge2[0]);
        pq.offer(new int[]{0, k});
        Map<Integer, Integer> dist = new HashMap<>();

        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int d = edge[0], node = edge[1];
            if(dist.containsKey(node)) continue;

            dist.put(node, d);
            for(int[] adj : graph.getOrDefault(node, new ArrayList<>())){
                int nei = adj[0], d2 = adj[1];
                if(!dist.containsKey(nei)){
                    pq.offer(new int[]{d+d2, nei});
                }
            }
        }
        if(dist.size() != n) return -1;
        int ans = 0;
        for(int cand : dist.values()){
            ans = Integer.max(ans, cand);
        }
        return ans;
    }
}
