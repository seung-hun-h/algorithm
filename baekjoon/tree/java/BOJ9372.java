import java.util.*;
import java.io.*;

public class BOJ9372 {
    static int T;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        
        for (int i=0;i<T;i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int j=0;j<M;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.putIfAbsent(a, new ArrayList<>());
                graph.putIfAbsent(b, new ArrayList<>());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            System.out.println(N-1);
            // System.out.println(bfs(graph, N));
        }
    }

    private static int bfs(Map<Integer, List<Integer>> graph, int N) {
        int result = 0;
        boolean[] visited = new boolean[N+1];
        int node = 1;
        Queue<Integer> q = new LinkedList<>();

        visited[node] = true;
        q.add(node);

        while(!q.isEmpty()) {
            node = q.poll();

            for (int adj : graph.get(node)) {
                if (!visited[adj]) {
                    q.add(adj);
                    visited[adj] = true;
                    result++;
                }
            }
        }

        return result;
    }
}