import java.util.HashMap;
import java.util.PriorityQueue;

public class LEET621 {
    public static void main(String[] args) {
        System.out.println(
            leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2)
        );
    }
    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> counter = new HashMap<>();
        
        for (char task : tasks) {
            counter.putIfAbsent(task, 0);
            counter.compute(task, (key, value) -> value+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> counter.get(b)-counter.get(a));
        
        for (char key : counter.keySet()) {
            pq.add(key);
        }

        int step = 0;
        while (!pq.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<=n;i++) {
                step++;
                if (!pq.isEmpty()){
                    char ch = pq.poll();
                    int count = counter.get(ch); 
                
                    if (count-1 > 0) {
                        sb.append(ch);
                        counter.compute(ch, (key, value) -> value-1);
                    }
                }

                if (sb.length() == 0)
                    break;
            }
            
            for (char ch : sb.toString().toCharArray()) {
                pq.add(ch);
            }
        }

        return step;
    }

}
