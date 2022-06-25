import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PRGRMS42586 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i=0;i < progresses.length;i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            int DONE = 100;
            int days = (int)Math.ceil((DONE - progress) / (double)(speed));

            if (q.isEmpty() || q.peek() >= days) {
                q.add(days);
                continue;
            }

            result.add(q.size());
            q.clear();
            q.add(days);
        }

        result.add(q.size());
        int[] answer = new int[result.size()];
        for (int i=0;i < answer.length;i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

}
