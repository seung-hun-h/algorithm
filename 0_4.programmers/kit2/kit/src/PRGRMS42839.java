import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PRGRMS42839 {
    public static void main(String[] args) {

    }

    private Set<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {
        permutation("", numbers);

        return numberSet.size();
    }

    private void permutation(String result, String numbers) {
        if (!result.isEmpty()) {
            int number = Integer.parseInt(result);
            if (isPrime(number) && !numberSet.contains(number)) {
                numberSet.add(number);
            }
        }

        if (numbers.isEmpty()) {
            return;
        }


        for (int i=0;i<numbers.length();i++) {
            String before = numbers.substring(0, i);
            String after = numbers.substring(i + 1);
            permutation(result + numbers.substring(i, i + 1), before + after);
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number);
        for (int i=2;i<=sqrt;i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
