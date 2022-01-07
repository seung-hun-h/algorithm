import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ15664 {

    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        Map<Integer, Integer> count = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            count.putIfAbsent(key, 0);
            count.compute(key, (k, v) -> v + 1);
        }

        arr  = new int[count.size()];

        int i = 0;
        for (int num : count.keySet())  {
            arr[i++] = num;
        }

        Arrays.sort(arr);
        N = arr.length;
        dfs(new int[M], 0, 0, count);

        System.out.println(sb);

    }

    private static void dfs(int[] current, int depth, int start, Map<Integer, Integer> count) {
        if (depth == M) {
            for (int num : current) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (count.get(arr[i]) > 0) {
                count.compute(arr[i], (k, v) -> v - 1);
                current[depth] = arr[i];
                dfs(current, depth + 1, i, count);
                count.compute(arr[i], (k, v) -> v + 1);
            }
        }
    }
}
