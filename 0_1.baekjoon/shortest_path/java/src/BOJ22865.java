
import java.io.*;
import java.util.*;

public class BOJ22865 {

    private static final long INF = 99999999999L;
    private static int N, M;
    private static Map<Integer, List<int[]>> graph;
    private static Map<Integer, long[]> distMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        distMap = new HashMap<>();
        graph = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int node = Integer.parseInt(st.nextToken());
            distMap.put(node, new long[N + 1]);
            Arrays.fill(distMap.get(node), INF);
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());

            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight});
        }

        System.out.println(solve());
    }

    private static int solve() {
        for (int key : distMap.keySet()) {
            dijkstra(key, distMap.get(key));
        }
        long answer = 0;
        int node = 0;
        for (int i = 1; i <= N; i++) {
            long min = INF;

            for (int key : distMap.keySet()) {
                min = Math.min(min, distMap.get(key)[i]);
            }

            if (answer < min) {
                answer = min;
                node = i;
            }

        }
        return node;
    }

    private static void dijkstra(int start, long[] dist) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a1, a2) -> Long.compare(a1[1], a2[1]));
        dist[start] = 0L;
        pq.add(new long[]{start, 0L});

        while (!pq.isEmpty()) {
            int node = (int) pq.peek()[0];
            long weight = pq.poll()[1];

            if (weight > dist[node]) {
                continue;
            }

            for (int[] adj : graph.getOrDefault(node, new ArrayList<>())) {
                long alt = weight + adj[1];

                if (dist[adj[0]] > alt) {
                    dist[adj[0]] = alt;
                    pq.add(new long[]{adj[0], alt});
                }
            }
        }

    }
}

/**
 * 친구들의 위치에서 임의의 한점까지의 거리
 * 다익스트라(1->N), 플로이드-와샬(N->N)
 * N 최대 10만 -> 플로이드-와샬 X
 * 다익스트라 => Elog(V) = 3 * Elog(V)  good 
 * 1. A, B, C 각각의 위치에서 다른 지점까지의 거리르 구한다 dijkstra() * 3
 * - distMap<Integer, int[]>
 * 2. A, B, C를 제외한 다른 위치에서 A, B, C까지의 거리 중 최소를 구하고 최대가 그 답
 *
 **/