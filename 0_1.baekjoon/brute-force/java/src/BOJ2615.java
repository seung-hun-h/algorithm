import java.util.*;
import java.io.*;

public class BOJ2615 {
    static int N = 19;
    static int[][] map = new int[N][N];
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // for(int[] line : map){
        //     for(int num : line){
        //         System.out.print(num +" ");
        //     }
        //     System.out.println();
        // }
        solve();
    }
    public static void solve(){
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(map[r][c] != 0){
                    int[] point = check(r, c);

                    if(point != null){
                        System.out.println(map[r][c]);
                        System.out.println((point[0]+1) + " " + (point[1]+1));
                        return;
                    }  
                }
            }
        }
        System.out.println(0);
    }
    public static int[] check(int row, int col){
        int[] point = {row, col};
        int target = map[row][col];
        for(int i=0;i<8;i++){
            int nr = row + dr[i], nc = col + dc[i];
            int minCol = col, minRow = row;
            int cnt = 1;

            while(nr>= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == target){
                if(nc < minCol){
                    minCol = nc;
                    minRow = nr;
                } else if(minCol == nc && minRow > nr){
                    minCol = nc;
                    minRow = nr;
                }
                cnt++;
                nr += dr[i]; nc += dc[i];
            }

            nr = row + dr[(i+12) % 8]; nc = col + dc[(i+12) % 8];
            while(nr>= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == target){
                if(nc < minCol){
                    minCol = nc;
                    minRow = nr;
                } else if(minCol == nc && minRow > nr){
                    minCol = nc;
                    minRow = nr;
                }
                cnt++;
                nr += dr[(i+12) % 8]; nc += dc[(i+12) % 8];
            }

            if(cnt == 5){
                point[0] = minRow;
                point[1] = minCol;
                return point;
            }
        }
        return null;
    }
}