import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRGRMS42747 {
    public static void main(String[] args) {

    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int max = citations[citations.length - 1];
        for (int i=0;i<=max;i++) {
            int lower = Arrays.binarySearch(citations, i);

            if (lower < 0) {
                lower = -lower - 1;
            }

            int count = citations.length - lower;
            if (i <= count) {
                answer = i;
            }
        }

        return answer;
    }
}
