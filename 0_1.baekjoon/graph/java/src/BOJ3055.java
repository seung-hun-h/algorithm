import java.util.*;
import java.io.*;

public class BOJ3055 {
    static int R, C;
    static int[][] graph;
    static List<Point> waterPoints;
    static Point hogPoint;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static final int EMPTY = 0;
    static final int ROCK = 1;
    static final int WATER = 2;
    static final int TARGET = 3;
    static class Point {
        int row, col, time;
        Point(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new int[R][C];
        waterPoints = new ArrayList<>();


        for (int i=0;i<R;i++) {
            String line = br.readLine();

            int j = 0;
            for (char ch : line.toCharArray()) {
                if (ch == 'D') {
                    graph[i][j] = TARGET;
                } else if (ch == '*') {
                    waterPoints.add(new Point(i, j, 0));
                    graph[i][j] = WATER;
                } else if (ch == 'S') {
                    hogPoint = new Point(i, j, 0);
                } else if (ch == 'X') {
                    graph[i][j] = ROCK;
                }
                j++;
            }
        }
        int result = bfs();
        System.out.println(result == -1 ? "KAKTUS" : result);
    }   
    public static int bfs() {
        Queue<Point> waters = new LinkedList<>();
        Queue<Point> hogs = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        visited[hogPoint.row][hogPoint.col] = true;

        waters.addAll(waterPoints);
        hogs.add(hogPoint);

        while (!hogs.isEmpty()) {
            int len = waters.size();
            
            for (int i=0;i<len;i++) {
                Point water = waters.poll();

                for (int j=0;j<4;j++) {
                    int nr = water.row + dr[j], nc = water.col + dc[j];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                        continue;
                    
                    if (graph[nr][nc] != EMPTY)
                        continue;
                    
                    graph[nr][nc] = WATER;
                    waters.add(new Point(nr, nc, 0));
                }
            }

            len = hogs.size();
            for (int i=0;i<len;i++) {
                Point hog = hogs.poll();
                
                for (int j=0;j<4;j++) {
                    int nr = hog.row + dr[j], nc = hog.col + dc[j];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                        continue;
                    
                    if (graph[nr][nc] == TARGET)
                        return hog.time + 1;
                    
                    if (graph[nr][nc] != EMPTY)
                        continue;
                
                    if (visited[nr][nc])
                        continue;
                    
                    visited[nr][nc] = true;
                    hogs.add(new Point(nr, nc, hog.time + 1));
                }
            }
        }

        return -1;
    }
    private static void printGraph() {
        for (int[] g : graph) {
            System.out.println(Arrays.toString(g));
        }
        System.out.println();
    }
}
