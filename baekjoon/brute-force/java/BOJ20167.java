import java.io.*;
import java.util.StringTokenizer;
public class BOJ20167 {
    static int N, K, result = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(result);
    }
    private static void dfs(int idx, int satisfaction, int energy) {

        if (idx == N) {
            result = Math.max(result, energy);
            return;
        }

        dfs(idx + 1, 0, energy);

        if (satisfaction + arr[idx] >= K) {
            dfs(idx + 1, 0, energy + satisfaction + arr[idx] - K);
        } else {
            dfs(idx + 1, satisfaction + arr[idx], energy);
        }
    }
}
