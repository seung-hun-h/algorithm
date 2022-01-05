import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1747 {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int answer = - 1;

        while (answer == -1) {
            if (isPrime(N) && isPalindrome(N)) {
                answer = N;
            }
            N++;
        }
        System.out.println(answer);
    }

    private static boolean isPalindrome(int num) {
        String strNum = String.valueOf(num);

        int left = 0, right = strNum.length() - 1;

        while (left < right) {
            if (strNum.charAt(left) != strNum.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
