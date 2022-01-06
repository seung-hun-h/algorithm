import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16987 {

    private static int N;
    private static int[] life;
    private static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        life = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            life[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(0));
    }

    private static int dfs(int hold) {
        if (hold == N) {
            return countBrokenEggs();
        }

        if (life[hold] <= 0) {
            return dfs(hold + 1);
        }

        int result = -1;
        for (int i = 0; i < N; i++) {
            if (i == hold) continue;
            if (life[i] <= 0) continue;

            life[hold] -= weight[i];
            life[i] -= weight[hold];

            result = Math.max(result, dfs(hold + 1));

            life[hold] += weight[i];
            life[i] += weight[hold];
        }

        if (result == -1) {
            result = Math.max(result, dfs(hold + 1));
        }

        return result;
    }

    private static int countBrokenEggs() {
        int result = 0;

        for (int egg : life ) {
            if (egg <= 0)
                result++;
        }

        return result;
    }

}
