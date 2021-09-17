import java.util.*;
import java.io.*;

public class BOJ15654 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(arr, new int[M], 0, 0);
        System.out.println(sb.toString());
    }

    private static void dfs(int[] arr, int[] result, int idx, int mask) {
        if (idx == M) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0;i<N;i++) {
            if ((mask & (1 << i)) == 0) {
                result[idx] = arr[i];
                dfs(arr, result, idx + 1, mask | (1 << i));
                result[idx] = 0;
            }
        }
        
    }
}
