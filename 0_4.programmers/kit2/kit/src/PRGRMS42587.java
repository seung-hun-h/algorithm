import java.util.*;

public class PRGRMS42587 {
    public static void main(String[] args) {

    }

    static class Document {
        int location;
        int priority;

        Document(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }

        public String toString() {
            return "p = " + priority + " l = " + location;
        }
    }
    public int solution(int[] priorities, int location) {
        PriorityQueue<Document> pq = new PriorityQueue<>((d1, d2) -> Integer.compare(d2.priority, d1.priority));

        for (int i=0;i<priorities.length;i++) {
            Document doc = new Document(i, priorities[i]);
            pq.add(doc);
        }
        int seq = 1;
        while (!pq.isEmpty()) {
            for (int i=0;i<priorities.length;i++) {
                if (priorities[i] == pq.peek().priority) {
                    if (i == location) {
                        return seq;
                    }
                    pq.poll();
                    seq++;
                }
            }
        }
        return seq;
    }

}
