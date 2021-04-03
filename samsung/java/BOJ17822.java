import java.util.*;
import java.io.*;

public class BOJ17822 {
    static int N, M, T, x, d, k;
    static Deque[] circles;
    static int[][] commands;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        T = Integer.parseInt(line[2]);

        circles = new ArrayDeque[N+1];
        commands = new int[T][3];

        for(int i=1;i<=N;i++){
            line = br.readLine().split(" ");
            circles[i] = new ArrayDeque<Integer>();
            for(int j=0;j<M;j++){
                circles[i].add(Integer.parseInt(line[j]));
            }
        }

        for(int i=0;i<T;i++){
            line = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                commands[i][j] = Integer.parseInt(line[j]);
            } 
        }
        solve();
    }

    public static void solve(){
        for(int[] command: commands){
            for(Deque circle: circles){
                System.out.println(circle);
            }
            System.out.println();
            rotate(command[0], command[1], command[2]);
            delete();

            for(Deque circle: circles){
                System.out.println(circle);
            }
        }
    }
    public static void delete(){
        boolean[][] flags = new boolean[N+1][M];
        int total = 0;
        int cnt = 0;
        for(int i=1;i<=N;i++){
            if(i % 2 == 0){
                int up = i + 1;
                int down = i - 1;
                
                for(int j=0;j<M;j++){
                    if(up <= N && circles[i]. == circles[up].get(j)){
                        
                    }
                }
            }

        }
    }
    public static void rotate(int x, int d, int k){
        for(int i=1;i<=N;i++){
            if(i % x == 0){
                if(d == 0){
                    for(int j=0;j<k;j++){
                        circles[i].addFirst(circles[i].pollLast());
                    }
                } else {
                    for(int j=0;j<k;j++){
                        circles[i].add(circles[i].poll());
                    }
                }
            }
        }
    }
}
