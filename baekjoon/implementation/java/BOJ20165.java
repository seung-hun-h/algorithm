import java.io.*;
import java.util.*;

class BOJ20165 {
    static int N, M, R;
    static int[][] board;
    static boolean[][] isDown;
    static int[][] D = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        isDown = new boolean[N][M];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for (int i=0;i<R;i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            int dir = convertDirectionToInt(st.nextToken());
            
            if (!isDown[row][col])
                result += dfs(row, col, dir, board[row][col]) + 1;
            
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken()) - 1;
            col = Integer.parseInt(st.nextToken()) - 1;

            if (isDown[row][col]) {
                isDown[row][col] = false;
            }
        }

        printResult(result);

    }
    private static void printResult(int result) {
        System.out.println(result);
        for (boolean[] down : isDown) {
            for (boolean d : down) {
                if (d) {
                    System.out.print("F");
                } else {
                    System.out.print("S");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private static int dfs(int row, int col, int dir, int height) {
        
        isDown[row][col] = true;
        int total = 0;
        if (height > 1) {
            int nr = row + D[dir][0], nc = col + D[dir][1];

            if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                if (!isDown[nr][nc]) {
                    height = Math.max(height - 1, board[nr][nc]);
                    total++;
                } else {
                    height--;
                }

                total += dfs(nr, nc, dir, height);
            }
        }
        return total;
        
    }
    private static int convertDirectionToInt(String direction) {
        if (direction.equals("E"))
            return 0;

        if (direction.equals("W"))
            return 1;

        if (direction.equals("S"))
            return 2;

        return 3;
    }
}