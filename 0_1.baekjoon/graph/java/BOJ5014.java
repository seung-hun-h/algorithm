import java.util.*;
import java.io.*;

public class BOJ5014 {
    static int F, S, G, U, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
    
        int result = bfs();

        if (result == -1) {
            System.out.println("use the stairs");
            return;
        }

        System.out.println(result);
    }
    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];
        q.add(new int[] {S, 0});
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if (current[0] == G) 
                return current[1];

            int up = current[0] + U;
            if (up <= F && !visited[up]) {
                visited[up] = true;
                q.add(new int[] {up, current[1] + 1});
            }
            
            int down = current[0] - D;
            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                q.add(new int[] {down, current[1] + 1});
            }
        }

        return -1;
    }
}
