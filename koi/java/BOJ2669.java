import java.util.*;
import java.io.*;

public class BOJ2669 {
    static int[][] map;
    static boolean[][] visited;
    static int length;
    static int ans;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        length = 101;
        map = new int[length][length];
        visited = new boolean[length][length];


        for(int i=0;i<4;i++){
            String[] line = br.readLine().split(" ");
            paint(Integer.parseInt(line[0]), Integer.parseInt(line[1]), 
                Integer.parseInt(line[2]), Integer.parseInt(line[3]));
        }

        for(int r=1;r<length;r++){
            for(int c=1;c<length;c++){
                if(map[r][c] == 1 && !visited[r][c]){
                    bfs(r, c);
                }
            }
        }
        System.out.println(ans);
    }
    public static void bfs(int row, int col){
        Queue<int[]> q = new LinkedList<>();
        int[] point = {row, col};
        q.add(point);
        visited[row][col] = true;

        while(!q.isEmpty()){
            point = q.poll();
            ans += 1;

            for(int i=0;i<4;i++){
                int nr = point[0] + dr[i];
                int nc = point[1] + dc[i];

                if((nr>0 && nc >0 && nr<length && nc < length) && map[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    int[] n_point = {nr, nc};
                    q.add(n_point);
                }
            }
        }
    }
    public static void paint(int x1, int y1, int x2, int y2){
        for(int r=y1;r<y2;r++){
            for(int c=x1;c<x2;c++){
                map[r][c] = 1;
            }
        }
    }
}
