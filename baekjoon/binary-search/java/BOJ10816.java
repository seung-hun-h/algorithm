import java.util.*;
import java.io.*;
public class BOJ10816 {
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[20000001];
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            count[Integer.parseInt(st.nextToken()) + 10000000]++;
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            sb.append(count[Integer.parseInt(st.nextToken()) + 10000000] +" ");
        }

        System.out.println(sb);

       
    }
}