import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class BOJ21941 {
    private static String S;
    private static int N;
    private static Map<String, Integer> words;
    private static int[] dp;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        words = new HashMap<>();
        S = br.readLine();
        N = S.length();
        dp = new int[N];
        int M = Integer.parseInt(br.readLine());

        Arrays.fill(dp, -1);
        for (int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            int point = Integer.parseInt(st.nextToken());

            if (word.length() >= point) continue;
            words.put(word, Math.max(words.getOrDefault(word, 0), point));
        }

        System.out.println(dfs(0));

    }

    private static int dfs(int idx) {
        if (idx >= N) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int result = 0;

        for (String word : words.keySet()) {
            int length = word.length();
            if (S.startsWith(word, idx)) {
                dp[idx] = Math.max(dp[idx], dfs(idx + length) + words.get(word));
            }
        }

        dp[idx] = Math.max(dp[idx], dfs(idx + 1) + 1);

        return dp[idx];
    }
}