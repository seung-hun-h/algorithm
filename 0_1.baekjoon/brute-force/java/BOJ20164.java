import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ20164 {
    static final int INF = 1000000000;
    static int max = 0;
    static int min = INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();

        divide(number, 0);
        System.out.println(min + " " + max);
    }

    private static void divide(String number, int count) {
        count += countOdds(number);
        if (number.length() <= 1) {
            max = Math.max(max, count);
            min = Math.min(min, count);
            return;
        }
        if (number.length() == 2) {
            int one = Integer.parseInt(number.substring(0, 1));
            int two = Integer.parseInt(number.substring(1));
        
            divide(String.valueOf(one + two), count);
            return;
        }

        for (int left = 1; left <= number.length() - 2; left++) {
            for (int right = left + 1; right <= number.length() - 1; right++) {
                int begin = Integer.parseInt(number.substring(0, left));
                int middle = Integer.parseInt(number.substring(left, right));
                int end = Integer.parseInt(number.substring(right));

                String result = String.valueOf(begin + middle + end);

                divide(result, count);
            }
        }
    }

    private static int countOdds(String number) {
        int result = 0;

        for (int i=0;i<number.length();i++) {
            int n = Integer.parseInt(number.substring(i, i + 1));
            result += (n % 2);
        }

        return result;
    }
}
