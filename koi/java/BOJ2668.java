import java.io.*;
import java.util.*;

public class BOJ2668 {
    static int N;
    static int[] array;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        array = new int[N+1];
        ans = 0;

        for(int i=1;i<N+1;i++){
            array[i] = Integer.parseInt(br.readLine().trim());
        }

        solve();
    }
    public static void solve(){
        boolean[] visited = new boolean[N+1];
        
        for(int i=1;i<N+1;i++){
            Queue<Integer> q = new LinkedList<>();
            if(!visited[i]){
                visited[i] = true;
                if(!dfs(i, i, 1, visited, q)){
                    while (!q.isEmpty()){
                        visited[q.poll()] = false;
                    }
                }
            }
        }

        System.out.println(ans);
        for(int i=1;i<N+1;i++){
            if(visited[i]){
                System.out.println(i);
            }
        }
    }
    public static boolean dfs(int startIdx, int idx, int cnt, boolean[] visited, Queue<Integer> q){
        visited[idx] = true;
        q.add(idx);

        int _next = array[idx];

        if(startIdx == _next){
            ans += cnt;
            return true;
        }
        if(!visited[_next]){
            return dfs(startIdx, _next, cnt+1, visited, q);
        }
        return false;
    }
}