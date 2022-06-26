import java.util.PriorityQueue;

public class PRGRMS42626 {
    public static void main(String[] args) {

    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        init(pq, scoville);
        int count = 0;
        while(pq.size() > 1) {
            count++;
            int first = pq.poll();
            int second = pq.poll();

            pq.add(first + second * 2);
            if (pq.peek() >= K) break;
        }

        return pq.peek() >= K ? count : -1;
    }

    private void init(PriorityQueue<Integer> pq, int[] array) {
        for (int number : array) {
            pq.add(number);
        }
    }

}
