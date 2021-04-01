import java.util.*;
import java.io.*;

public class BOJ17779{
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        int ans = 100000000;
        int total = 0;

        for(int i=1;i<=N;i++){
            String[] line = br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                map[i][j] = Integer.parseInt(line[j-1]);
                total += map[i][j];
            }
        }
        
        for(int x=1;x<=N;x++){
            for(int y=1;y<=N;y++){
                for(int d1=1;d1<=N;d1++){
                    for(int d2=1;d2<=N;d2++){
                        if (x + d1 + d2 > N) continue;
                        if (y - d1 < 1) continue;
                        if (y + d2 > N) continue;

                        ans = Math.min(ans, find(x, y, d1, d2, total));
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static int find(int x, int y, int d1, int d2, int total){
        int[][] region = new int[N+1][N+1];
        int[] population = new int[N+1];
        
        // 경계
        region[x][y] = 5;
        for(int i=1;i<=d1;i++){
            region[x+i][y-i] = 5; 
        }        
        for(int i=1;i<=d2;i++){
            region[x+i][y+i] = 5; 
        }        
        for(int i=1;i<=d2;i++){
            region[x+d1+i][y-d1+i] = 5;
        }
        for(int i=1;i<=d1;i++){
            region[x+d2+i][y+d2-i] = 5;
        }

        // 1 구역
        for(int r=1;r<x+d1;r++){
            for(int c=1;c<=y;c++){
                if(region[r][c] == 5) break;
                if(region[r][c] == 0){
                    region[r][c] = 1;
                    population[1] += map[r][c];
            
                }
            }
        }
        
        // 2 구역
        for(int r=1;r<=x+d2;r++){
            for(int c=N;c>y;c--){
                if(region[r][c] == 5) break;
                if(region[r][c] == 0){
                    region[r][c] = 2;
                    population[2] += map[r][c];
                }
            }
        }
        
        // 3 구역
        for(int r=x+d1;r<=N;r++){
            for(int c=1;c<y-d1+d2;c++){
                if(region[r][c] == 5) break;
                if(region[r][c] == 0){
                    region[r][c] = 3;
                    population[3] += map[r][c];
                }
            }
        }

        // 4 구역
        for(int r=x+d2+1;r<=N;r++){
            for(int c=N;c>=y-d1+d2;c--){
                if(region[r][c] == 5) break;
                if(region[r][c] == 0){
                    region[r][c] = 4;
                    population[4] += map[r][c];
                }
            }
        }
        
        int cur = 0;
        for(int p : population){
            cur += p;
        }
        population[5] = total-cur; 

        int max = 0;
        int min = 100000000;
        for(int i=1;i<=5;i++){
            if(max < population[i]){
                max = population[i];
            }
            if(min > population[i]){
                min = population[i];
            }
        }
        return max - min;
    }
}