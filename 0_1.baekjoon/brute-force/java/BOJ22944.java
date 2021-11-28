import java.io.*;
import java.util.*;

public class BOJ22944 {
    static class Point {
        int row, col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Info {
        int health, shield, move;
        Point point;
        Info(Point point, int health, int shield, int move) {
            this.point = point;
            this.health = health;
            this.shield = shield;
            this.move = move;
        }
    }
    static int N, H, D;
    static char[][] board;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new char[N][N];
        Point start = null;
        for (int i=0;i<N;i++) {
            String line = br.readLine();
            for (int j=0;j<N;j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'S') {
                    start = new Point(i, j);
                }
            }
        }

        System.out.println(bfs(start));
    }
    private static int bfs(Point start) {
        Queue<Info> q = new LinkedList<>();

        Info info = new Info(start, H, 0, 0);
        int[][] history = new int[N][N];

        q.add(info);

        while(!q.isEmpty()) {
            info = q.poll();
            Point point = info.point;
            for (int i = 0; i < 4; i++) {
                int nr = point.row + dir[i][0], nc = point.col + dir[i][1];
            
                if (isInvalid(nr, nc)) {
                    continue;
                }

                int nh = info.health, ns = info.shield, nm = info.move + 1;

                if (board[nr][nc] == 'E') {
                    return nm;
                }

                if (board[nr][nc] == 'U') {
                    ns = D;
                } 
                
                if (ns > 0) {
                    ns -= 1;
                } else {
                    nh -= 1;
                }

                if (nh <= 0)
                    continue;
                if (history[nr][nc] >= nh + ns)
                    continue;

                history[nr][nc] = nh + ns;
                q.add(new Info(new Point(nr, nc), nh, ns, nm));
            }
        }
        
        return -1;
    }
    private static boolean isInvalid(int row, int col) {
        return row < 0 || col < 0 || row >= N || col >= N;
    }
}

