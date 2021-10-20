import java.util.*;
import java.io.*;
public class BOJ3584 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++) {

            int N = Integer.parseInt(br.readLine());
            
            int[] parent = new int[N + 1];
            

            for (int j=1;j<N;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                parent[b] = a;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            List<Integer> path1 = new ArrayList<>();
            List<Integer> path2 = new ArrayList<>();

            findPath(parent, node1, path1);
            findPath(parent, node2, path2);
            
            List<Integer> search = path1.size() < path2.size() ? path1 : path2;
            List<Integer> check = path1.size() < path2.size() ? path2 : path1;
            Collections.sort(check);

            for (int node : search) {
                int idx = Collections.binarySearch(check, node);
                
                if (idx < 0) continue;

                if (check.get(idx) == node) {
                    System.out.println(node);
                    break;
                }
            }
            
        }

    }

    private static void findPath(int[] parent, int node, List<Integer> path) {

        path.add(node);

        if (parent[node] == 0)
            return;

        findPath(parent, parent[node], path);
    }
}
