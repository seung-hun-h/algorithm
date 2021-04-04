import java.util.*;
import java.io.*;

public class BOJ17822 {
    static int N, M, T, x, k, d;
    static int[][] commands;
    static ArrayList<Integer>[] circles;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        T = Integer.parseInt(line[2]);

        circles = new ArrayList[N+1];
        commands = new int[T][3];


        for(int i=1;i<=N;i++){
            line = br.readLine().split(" ");
            circles[i] = new ArrayList<>();
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

        // for(ArrayList<Integer> circle : circles){
        //     System.out.println(circle);
        // }
        // System.out.println();
        solve();
    }
    public static void solve(){
        for(int[] command : commands){
            rotate(command[0], command[1], command[2]);
            delete();   
            // for(ArrayList<Integer> circle : circles){
            //     System.out.println(circle);
            // }
            // System.out.println();
        }
        System.out.println(getSum());
    }
    public static int getSum(){
        int ans = 0;
        for(int i=1;i<=N;i++){
            for(int j=0;j<M;j++){
                ans += circles[i].get(j);
            }
        }
        return ans;
    }
    public static void delete(){
        double sum = 0;
        int cnt = 0;
        boolean[][] flags = new boolean[N+1][M];
        boolean isDeleted = false;
        for(int i=1;i<=N;i++){
            if(i % 2 == 0){
                int up = i + 1;
                int down = i - 1;
                for(int j=0;j<M;j++){
                    int cur = circles[i].get(j);
                    if(cur == 0) continue;
                    if(up <= N && cur == circles[up].get(j)){
                        flags[up][j] = true;
                        flags[i][j] = true;
                        isDeleted = true;
                    }
                    if(cur == circles[down].get(j)){
                        flags[down][j] = true;
                        flags[i][j] = true;
                        isDeleted = true;
                    }
                }
            }

            for(int j=0;j<M;j++){
                int cur = circles[i].get(j);
                if (cur == 0) continue;
                sum += circles[i].get(j);
                cnt ++;
                if(cur == circles[i].get((j+1) % M)){
                    flags[i][j] = true;
                    flags[i][(j+1) % M] = true;
                    isDeleted = true;
                }
            }
        }

        if(isDeleted){
            for(int i=1;i<=N;i++){
                for(int j=0;j<M;j++){
                    if(flags[i][j]){
                        circles[i].set(j, 0);
                    }
                }
            }
        } else {
            if(cnt != 0){
                double mean = sum / cnt;
                for(int i=1;i<=N;i++){
                    for(int j=0;j<M;j++){
                        int cur = circles[i].get(j);
                        if(cur == 0) continue;
                        if(cur < mean){
                            circles[i].set(j, cur + 1);
                        } else if(cur > mean){
                            circles[i].set(j, cur - 1);
                        }
                    }
                }   
            }
        }
    }
    public static void rotate(int x, int d, int k){
        for(int i=x;i<=N;i+=x){
            if(d == 0){
                for(int j=0;j<k;j++){
                    circles[i].add(0, circles[i].remove(M-1));
                }
            } else {
                for(int j=0;j<k;j++){
                    circles[i].add(M-1, circles[i].remove(0));
                }
            }
        }
    }
}