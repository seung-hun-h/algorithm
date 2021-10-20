import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KAKAO23 {
    public static void main(String[] args) {
        int result = solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
        System.out.println(result);
    }    
    public static int solution(int[] stones, int k) {
        int ans = 0;
        int left = 1, right = k;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i=0;i<k;i++) {
            ans = Math.max(ans, stones[i]);
            counter.putIfAbsent(stones[i], 0);
            counter.compute(stones[i], (key, value) -> value + 1);
            pq.add(stones[i]);
        }

        for (;right<stones.length;right++) {
            counter.compute(stones[left-1], (key, value) -> value - 1);

            while (!pq.isEmpty() && counter.get(pq.peek()) == 0)
                pq.poll();
            
            pq.add(stones[right]);
            counter.putIfAbsent(stones[right], 0);
            counter.compute(stones[right], (key, value) -> value + 1);

            ans = Math.min(ans, pq.peek());

            left++;
        }
        
        return ans;
    }
}
/**
 * [2019 카카오 인턴] 징검다리 건너기
 * 해결: X
 */