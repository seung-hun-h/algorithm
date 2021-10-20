import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11066 {
    private static BufferedReader br;
    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));       
        
        int T = Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++) {
            System.out.println(mergeFiles());
        }
    }

    public static int mergeFiles() throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());
        int[] files = getFiles(N);
        int[] acc = accumulate(files);
        int[][] dp = new int[N][N];

        for (int step=1;step<N;step++) {
            for(int start=0;start<N-step;start++) {
                int end = start + step;

                dp[start][end] = Integer.MAX_VALUE;

                for (int j=start;j<end;j++) {
                    dp[start][end] = Math.min(
                        dp[start][end],
                        dp[start][j] + dp[j+1][end] + acc[end+1] - acc[start]);
                }
            }
        }

        return dp[0][N-1];
    }

    public static int[] accumulate(int[] arr) {
        int[] res = new int[arr.length+1];

        for (int i=0;i<arr.length;i++) {
            res[i+1] = res[i] + arr[i];
        }
        return res;
    }

    public static int[] getFiles(int N) throws IOException {
        int[] files = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i=0;i<N;i++) {
            files[i] = Integer.parseInt(st.nextToken());
        }
        return files;
    }
}
