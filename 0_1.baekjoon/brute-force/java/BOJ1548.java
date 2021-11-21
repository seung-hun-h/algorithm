import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1548 {
    static int N;
    static int[] array;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        
        System.out.println(longestTriangleSequence());
        
    }
    private static int longestTriangleSequence() {
        if (N <= 2)
            return N;

        int ans = 2;
        for (int i = 0; i < N - 2; i++) {
            for (int j = N - 1; j > i + 1; j--) {
                if (array[i] + array[i + 1] > array[j])
                    ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
