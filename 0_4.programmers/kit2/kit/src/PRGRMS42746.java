import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PRGRMS42746 {
    public static void main(String[] args) {

    }

    public String solution(int[] numbers) {
        List<String> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(String.valueOf(number));
        }

        numberList.sort((n1, n2) -> {
            int first = Integer.parseInt(n1 + n2);
            int second = Integer.parseInt(n2 + n1);
            return Integer.compare(second, first);
        });

        StringBuilder sb = new StringBuilder();
        for (String num : numberList) {
            sb.append(num);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
