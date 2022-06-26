import java.util.*;

public class PRGRMS42748 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();

        for (int[] command : commands) {
            int i = command[0] - 1;
            int j = command[1] - 1;
            int k = command[2] - 1;

            int[] subArray = Arrays.copyOfRange(array, i, j + 1);
            Arrays.sort(subArray);
            result.add(subArray[k]);
        }

        int[] answer = new int[result.size()];
        for (int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
