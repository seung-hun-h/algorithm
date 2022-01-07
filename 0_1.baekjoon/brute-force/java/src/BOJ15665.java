import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ15665 {

    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        arr  = new int[set.size()];

        int i = 0;
        for (int num : set) {
            arr[i++] = num;
        }

        Arrays.sort(arr);
        N = arr.length;
        dfs(new int[M], 0);

        System.out.println(sb);

    }

    private static void dfs(int[] current, int depth) {
        if (depth == M) {
            for (int num : current) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            current[depth] = arr[i];
            dfs(current, depth + 1);
        }
    }
}
