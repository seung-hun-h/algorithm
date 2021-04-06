import java.io.*;
import java.util.*;

public class BOJ17825 {
    static int[] seq;
    static int[][] piece = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
    static int[][] graph;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        seq = new int[10];
        String[] line = br.readLine().split(" ");

        for(int i=0;i<10;i++){
            seq[i] = Integer.parseInt(line[i]);
        }

        graph = new int[5][];
        int[] route0 = new int[20];
        for(int i=0;i<20;i++){
            route0[i] = i * 2;
        }
        graph[0] = route0;

        int[] route1 = {13, 16, 19};
        graph[1] = route1;

        int[] route2 = {22, 24};
        graph[2] = route2;

        int[] route3 = {28, 27, 26};
        graph[3] = route3;

        int[] route4 = {25, 30, 35, 40};
        graph[4] = route4;

        solve(0, 0);
        System.out.println(ans);
    }
    public static void solve(int idx, int point){
        if(idx == seq.length){
            ans = Math.max(ans, point);
            return;
        }

        int moves = seq[idx];
        for(int i=0;i<4;i++){
            int current = piece[i][0];
            int dir = piece[i][1];
            
            int nc = current + moves;
            int nd = dir;

            if(current == -1) continue;

            if((current == 5 || current == 10 || current == 15) && nd == 0){
                nd = current / 5;
                nc = moves - 1;
            }

            if((nd > 0 && nd <= 3) && nc >= graph[nd].length){
                nc -= graph[nd].length;
                nd = 4;
            }

            if(nd == 0 && nc >= graph[nd].length){
                int temp = graph[nd].length;
                nd = 4;
                nc = nc - temp + graph[nd].length - 1;
            }

            if(nd == 4 && nc >= graph[nd].length){
                piece[i][0] = -1;
                piece[i][1] = nd;
                solve(idx+1, point);
                piece[i][0] = current;
                piece[i][1] = dir;
            } else {
                boolean flag = true;
                for(int j=0;j<4;j++){
                    if(piece[j][0] == nc && piece[j][1] == nd){
                        flag = false;
                        break;
                    }
                }
                if (!flag) continue;

                piece[i][0] = nc;
                piece[i][1] = nd;
                solve(idx+1, point + graph[nd][nc]);
                piece[i][0] = current;
                piece[i][1] = dir;

            }

        }
    }
}
