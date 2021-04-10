import java.util.*;
import java.io.*;

public class BOJ2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> count = new HashMap<>();

        for(int i=0;i<N;i++){
            int sum = 0;
            for(int j=i;j<N;j++){
                sum += A[j];
                count.put(sum, count.getOrDefault(sum, 0) + 1);
            }
        }
        long res = 0;
        for(int i=0;i<M;i++){
            int sum = 0;
            for(int j=i;j<M;j++){
                sum += B[j];
                int key = T - sum;
                res += count.getOrDefault(key, 0);
            }
        }
        System.out.println(res);
    }    
}
