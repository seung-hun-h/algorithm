import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13164 {

    static int N, K;
    static int[] children;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        children = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            children[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMinCost());
    }
    private static int getMinCost() {
        int[] diffs = new int[N - 1];
        int result = 0;
        for (int i=0;i<N-1;i++) {
            diffs[i] = children[i + 1] - children[i];
        }

        Arrays.sort(diffs);
        
        for (int i=0;i<N-K;i++) {
            result += diffs[i];
        }

        return result;
    }
}
