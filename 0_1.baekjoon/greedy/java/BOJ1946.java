import java.io.*;
import java.util.StringTokenizer;

public class BOJ1946 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<T;i++) {
            
            int N = Integer.parseInt(br.readLine());

            int[] candidates = new int[N + 1];

            for (int j=0;j<N;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                candidates[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int count = N;
            int standard = candidates[1];
            for (int j=2;j<=N;j++) {
                if (standard < candidates[j])
                    count--;
                else
                    standard = candidates[j];
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
