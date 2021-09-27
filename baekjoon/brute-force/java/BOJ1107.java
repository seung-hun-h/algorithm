import java.util.*;
import java.io.*;

public class BOJ1107 {
    static final int INF = 1000000;
    static int N, M;
    static boolean[] outOfControl;
    static int result = INF;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        outOfControl = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            for (int i=0;i<M;i++) {
                outOfControl[Integer.parseInt(st.nextToken())] = true;
            }
        }

        result = Math.abs(100 - N);
        int minDiffNum = getMinDiffNum();
        result = Math.min(result, Math.abs(minDiffNum - N) + getDigits(minDiffNum));
        System.out.println(result);
    }
    private static int getDigits(int num) {
        int digits = 1;
        while ((num / 10) != 0) {
            num /= 10;
            digits++;
        }

        return digits;
    }

    private static int getMinDiffNum() {
        int minDiff = INF;
        int returnValue = INF; 

        for (int i=0;i<INF;i++) {
            int diff = Math.abs(N - i);

            if (check(i) && diff < minDiff) {
                minDiff = diff;
                returnValue = i;
            }
        }
        return returnValue;
    }

    private static boolean check(int num) {
        if (num == 0) {
            return !outOfControl[0];
        }

        int temp = num;

        while (temp != 0) {
            int remain = temp % 10;

            if (outOfControl[remain])
                return false;

            temp /= 10;
        }
        return true;
    }

}
