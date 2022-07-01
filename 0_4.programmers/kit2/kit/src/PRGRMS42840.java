import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRGRMS42840 {
    public static void main(String[] args) {

    }

    private static final int[] ANSWER_1 = {1, 2, 3, 4, 5};
    private static final int[] ANSWER_2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] ANSWER_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        int[] answer = {};
        int count1 = check(answers, ANSWER_1);
        int count2 = check(answers, ANSWER_2);
        int count3 = check(answers, ANSWER_3);

        return findMaxCounts(count1, count2, count3);
    }

    private int check(int[] answers, int[] input) {
        int count = 0;
        for (int i=0;i<answers.length;i++) {
            int idx = i % input.length;
            if (answers[i] == input[idx]) {
                count++;
            }
        }
        return count;
    }

    private int[] findMaxCounts(int ...counts) {
        int seq = 1;
        int max = 0;
        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            if (max == count) {
                result.add(seq);
            } else if (max < count) {
                max = count;
                result.clear();
                result.add(seq);
            }
            seq++;
        }

        int[] maxSeqArray = new int[result.size()];
        for (int i=0;i<result.size();i++) {
            maxSeqArray[i] = result.get(i);
        }
        return maxSeqArray;
    }
}
