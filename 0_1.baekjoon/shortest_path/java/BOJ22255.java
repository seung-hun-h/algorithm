import java.io.*;
import java.util.*;

class BOJ22255 {

    static class Point {
        int row, col, move, weight;

        Point(int row, int col, int move, int weight) {
            this.row = row;
            this.col = col;
            this.move = move;
            this.weight = weight;
        }
    }

    static int N, M;
    static int[][] board;
    static int startRow, startCol;
    static int endRow, endCol; 
    static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][][] dp;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        startRow = Integer.parseInt(st.nextToken()) - 1;
        startCol = Integer.parseInt(st.nextToken()) - 1;

        endRow = Integer.parseInt(st.nextToken()) - 1;
        endCol = Integer.parseInt(st.nextToken()) - 1;

        board = new int[N][M];
        dp = new int[N][M][3];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                
                for (int k=0;k<3;k++) {
                    dp[i][j][k] = INF;
                }
            }
        }

        solution();

        int result = Math.min(dp[endRow][endCol][0], Math.min(dp[endRow][endCol][1], dp[endRow][endCol][2]));

        if (result == INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
    private static void solution() {
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.weight, p2.weight));
        dp[startRow][startCol][1] = 0;

        pq.add(new Point(startRow, startCol, 1, 0));

        while(!pq.isEmpty()) {
            Point point = pq.poll();

            if (dp[point.row][point.col][point.move] < point.weight)
                continue;

            if (point.move == 0) {
                for (int i=0;i<4;i++) {
                    int nr = point.row + D[i][0], nc = point.col + D[i][1];
    
                    if (checkRange(nr, nc) && board[nr][nc] != -1) {
                        int alt = point.weight + board[nr][nc];
    
                        if (dp[nr][nc][1] > alt) {
                            dp[nr][nc][1] = alt;
                            pq.add(new Point(nr, nc, 1, alt));
                        }
                    }
                }
            } else if (point.move == 1) {
                for (int i=0;i<2;i++) {
                    int nr = point.row + D[i][0], nc = point.col + D[i][1];
    
                    if (checkRange(nr, nc) && board[nr][nc] != -1) {
                        int alt = point.weight + board[nr][nc];
    
                        if (dp[nr][nc][2] > alt) {
                            dp[nr][nc][2] = alt;
                            pq.add(new Point(nr, nc, 2, alt));
                        }
                    }
                }
            } else {
                for (int i=2;i<4;i++) {
                    int nr = point.row + D[i][0], nc = point.col + D[i][1];
    
                    if (checkRange(nr, nc) && board[nr][nc] != -1) {
                        int alt = point.weight + board[nr][nc];
    
                        if (dp[nr][nc][0] > alt) {
                            dp[nr][nc][0] = alt;
                            pq.add(new Point(nr, nc, 0, alt));
                        }
                    }
                }
            }

        }
        
    }
    
    private static boolean checkRange(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < M;
    }
}