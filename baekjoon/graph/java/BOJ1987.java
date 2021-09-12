import java.util.*;
import java.io.*;

class BOJ1987 {
    static int[][] graph;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int result = 0;
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char offset = 'A';

        graph = new int[R][C];

        for (int i=0;i<R;i++) {
            String line = br.readLine();
            int j = 0;
            for (char ch : line.toCharArray()) {
                graph[i][j++] = ch - offset; 
            } 
        }
        

        dfs(0, 0, 1, 0);
        System.out.println(result);
    }

    public static void dfs(int r, int c, int count, int visited) {
        result = Math.max(result, count);

        visited |= (1 << graph[r][c]);

        for (int i=0;i<4;i++) {
            int nr = r + dr[i], nc = c + dc[i];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if ((visited & (1 << graph[nr][nc])) == 0) {
                    dfs(nr, nc, count + 1, visited);
                }
            }
        }
    }
}