import java.io.*;
import java.util.*;

public class BOJ22253 {
    static int N;
    static Map<Integer, List<Integer>> tree;
    static int[] nums;
    static int[][] dp;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        nums = new int[N + 1];
        tree = new HashMap<>();
        dp = new int[N + 1][10];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            tree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        System.out.println(solve());
        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
    }   

    private static int solve() {

        dfs(-1, 1);
        int result = 0;
        for (int i=0;i<10;i++) {
            result += dp[1][i];
            result %= MOD;
        }

        return result;
    }

    private static void dfs(int parent, int node) {
        dp[node][nums[node]] = 1;
        for (int adj : tree.get(node)) {
            if (adj == parent) continue;

            dfs(node, adj);

            for (int i=0;i<10;i++) {
                dp[node][i] += dp[adj][i];
                dp[node][i] %= MOD;
            }

            for (int i=nums[node]; i<10;i++) {
                dp[node][nums[node]] += dp[adj][i];
                dp[node][nums[node]] %= MOD;
            }
        }
    }
    
}
