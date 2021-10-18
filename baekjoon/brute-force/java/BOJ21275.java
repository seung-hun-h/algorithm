import java.io.*;
import java.util.*;

public class BOJ21275 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        long[] result = {-1, -1, -1};

        for (int i=2;i<=36;i++) {
            long A = convertToTen(a, i);

            for (int j=2;j<=36;j++) {
                if (i == j) continue;
                long B = convertToTen(b, j);

                if (A == B && A != -1 && A != Long.MAX_VALUE) {
                    if (result[0] != -1) {
                        System.out.println("Multiple");
                        return;
                    } else { 
                        result = new long[] {A, i, j};
                    }
                }
            }
        }
        if (result[0] == -1) {
            System.out.println("Impossible");
        } else {
            System.out.println(result[0] +" " + result[1] + " " + result[2]);
        }

    }

    private static long convertToTen(String num, int n) {

        long result = 0;
        int len = num.length() - 1;

        for (int i = len; i >= 0; i--) {
            char ch = num.charAt(i);
            int current = 0;
            if (Character.isDigit(ch)) {
                current = (ch - '0');
            } else {
                current = (10 + ch - 'a');
            }

            if (current >= n)
                return -1;

            result += current * Math.pow(n, len - i);
        }

        return result;
    }
}
