import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];


        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long[] dp = new long[21];
        dp[arr[0]] = 1;
        for(int i=1;i<N-1;i++) {
            long[] temp = new long[21];
            for (int j=0;j<=20;j++) {
                if (dp[j] == 0) continue;
                int n1 = j + arr[i], n2 = j - arr[i];

                if (n1 >= 0 && n1 <= 20)
                    temp[n1] += dp[j];
                
                if (n2 >= 0 && n2 <= 20)
                    temp[n2] += dp[j];
            }
            dp = temp;
        }
        System.out.println(dp[arr[N-1]]);
    }
}
