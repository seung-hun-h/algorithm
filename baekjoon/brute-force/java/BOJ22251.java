import java.io.*;
import java.util.*;


public class BOJ22251 {
    static int N, X, K, P;
    static int[] bits = {119, 17, 62, 59, 89, 107, 111, 49, 127, 123};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        System.out.println(solve());
    }

    private static int solve() {
        int count = 0;
        for (int i = 1 ;i <= N; i++) {
            if (i == X) continue;

            if (check(i))
                count++;
        }
        return count;
    }

    private static boolean check(int num) {

        int k = K - 1;
        int temp = X;
        int count = 0;
        while (k >= 0) {
            int digit = (int)Math.pow(10, k);
            count += countDiffBits(temp / digit, num / digit);
            k--;
            temp %= digit;
            num %= digit;
        }
        return count <= P;
    }

    private static int countDiffBits(int num1, int num2) {
        return Integer.bitCount(bits[num1] ^ bits[num2]);
    }

}
