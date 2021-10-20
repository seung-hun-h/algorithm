import java.util.*;
import java.io.*;

public class BOJ10972 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }

    public static void solve(){
        int[] next = next_permutation();

        if(next == null){
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for(int num : next){
                sb.append(num);
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
    public static int[] next_permutation(){
        int[] copy = arr.clone();

        int idx = -1;
        for(int i=0;i<N-1;i++){
            if(copy[i] < copy[i+1]){
                idx = i;
            }
        }

        if(idx == -1){
            return null;
        }

        for(int i=N-1;i>idx;i--){
            if(copy[i] > copy[idx]){
                int tmp = copy[idx];
                copy[idx] = copy[i];
                copy[i] = tmp;
                break;
            }
        }
        idx++;
        int k = N-1;
        while(idx < k){
            int tmp = copy[idx];
            copy[idx] = copy[k];
            copy[k] = tmp;
            idx++;
            k--;
        }
        return copy;
    }
}