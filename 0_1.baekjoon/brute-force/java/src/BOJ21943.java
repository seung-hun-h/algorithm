import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21943 {
    private static int N, P, Q;
    private static int[] arr;
    private static int[] ps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ps = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        System.out.println(dfs(0));
    }

    private static int dfs(int idx) {
        if (idx == N) {
            return getResult();
        }

        int result = 0;

        for (int i = 0; i <= Q; i++) {
            ps[i] += arr[idx];
            result = Math.max(result, dfs(idx + 1));
            ps[i] -= arr[idx];
        }

        return result;
    }

    private static int getResult() {
        int result = 1;

        for (int i = 0; i <= Q; i++) {
            result *= ps[i];
        }

        return result;
    }
}
