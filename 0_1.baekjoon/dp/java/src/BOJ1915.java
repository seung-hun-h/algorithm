import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];

        for (int i=1;i<=N;i++) {
            String line = br.readLine();
            for (int j=1;j<=M;j++) {
                arr[i][j] = line.charAt(j-1) - '0';
            }
        }

        int max = 0;
        for (int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                if (arr[i][j] == 0) continue;

                arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1])) + 1;
                max = Math.max(arr[i][j], max);
            }
        }
        System.out.println(max * max);
    }
}
