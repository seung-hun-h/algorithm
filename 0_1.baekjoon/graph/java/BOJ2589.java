import java.util.*;
import java.io.*;

public class BOJ2589 {

    static class Point {
        int row, col, dist;
        Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        public String toString() {
            return String.format("row = %d, col = %d, dist = %d", row, col, dist);
        }
    }

    static int R, C;
    static char[][] graph;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];

        for (int i=0;i<R;i++) {
            char[] line = br.readLine().toCharArray();

            for (int j=0;j<C;j++) {
                graph[i][j] = line[j];
            }
        }
        
        int result = 0;
        for (int r=0;r<R;r++) {
            for (int c=0;c<C;c++) {
                if (graph[r][c] == 'L') {
                    result = Math.max(result, bfs(new Point(r, c, 0)));
                }
            }
        }
        System.out.println(result);
    }
    private static int bfs(Point start) {
        boolean[][] visited = new boolean[R][C];
        Queue<Point> q = new LinkedList<>();
        Point result = start;
        visited[start.row][start.col] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.dist > result.dist) {
                result = point;
            }

            for (int i=0;i<4;i++) {
                int nr = point.row + dr[i], nc = point.col + dc[i];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                    continue;
                
                if(graph[nr][nc] == 'W')
                    continue;

                if (visited[nr][nc])
                    continue;

                visited[nr][nc] = true;
                q.add(new Point(nr, nc, point.dist + 1));
            }
        }

        return result.dist;
    }
}
