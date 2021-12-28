import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21758 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] acc = new int[N];
        acc[0] = arr[0];
        for (int i=1;i<N;i++) {
            acc[i] = acc[i - 1] + arr[i];
        }

        int answer = 0;

        for (int i = 1; i < N-1; i++) {
            int dist1 = acc[i] - arr[0] - arr[i];
            int dist2 = acc[N-1] - acc[i] - arr[N-1];
            int dist3 = acc[N-1] - arr[N-1] - arr[0];

            answer = Math.max(answer, dist1 + dist2 + arr[i] * 2);
            answer = Math.max(answer, dist2 + dist3 + arr[N-1] * 2 - arr[i]);
            answer = Math.max(answer, dist1 + dist3 + arr[0] * 2 - arr[i]);
        }

        System.out.println(answer);
    }
}
