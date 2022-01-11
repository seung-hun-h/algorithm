
import java.io.*;
import java.util.*;

public class BOJ16954 {
    private static final int N = 8;
    private static int[][] d = {{-1, -1}, {-1, 1}, {-1, 0}, {1, -1}, {1, 1}, {1, 0}, {0, 1}, {0, -1}, {0, 0}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<int[]> walls = new ArrayList<>();

        for (int i=0;i<N;i++) {
            char[] line = br.readLine().toCharArray();
            for(int j=0;j<N;j++) {
                if (line[j] == '#') {
                    walls.add(new int[] {i, j});
                }
            }
        }

        System.out.println(solve(walls));
    }

    private static int solve(List<int[]> walls) {
        return dfs(7, 0, walls) ? 1 : 0;
    }

    private static boolean dfs(int row, int col, List<int[]> walls) {
        if ((row == 0 && col == 7) || walls.isEmpty()) {
            return true;
        }

        List<int[]> next = move(walls);

        for (int i=0;i<9;i++) {
            int nr = row + d[i][0], nc = col + d[i][1];
            if (!check(nr, nc, walls, next)) continue;
            if (dfs(nr, nc, next)) {
                return true;
            }
        }

        return false;
    }

    private static List<int[]> move(List<int[]> walls) {
        List<int[]> temp = new ArrayList<>();
        for (int[] wall : walls) {
            int nr = wall[0] + 1, nc = wall[1];
            if (checkRange(nr, nc)) {
                temp.add(new int[] {nr, nc});
            }
        }

        return temp;
    }

    private static boolean check(int row, int col, List<int[]> current, List<int[]> next) {
        if (!checkRange(row, col)) {
            return false;
        }

        for (int[] wall : current) {
            if (row == wall[0] && col == wall[1]) {
                return false;
            }
        }

        for (int[] wall : next) {
            if (row == wall[0] && col == wall[1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkRange(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < N;
    }
}
