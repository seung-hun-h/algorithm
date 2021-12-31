import java.io.*;
import java.util.StringTokenizer;
class BOJ15652 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        dfs(1, new int[M], 0);
    }

    public static void dfs(int current, int[] result, int idx) {
        if (idx == M) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = current; i <= N; i++) {
            result[idx] = i;
            dfs(i, result, idx + 1);
        }
    }
}