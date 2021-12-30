import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1374 {

    static class Class {
        public final int seq;
        public final int start;
        public final int end;

        Class(int seq, int start, int end) {
            this.seq = seq;
            this.start = start;
            this.end = end;
        }
    }

    static int N;
    static List<Class> classes;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        classes = new ArrayList<>();

        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            classes.add(new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        classes.sort((c1, c2) -> Integer.compare(c1.start, c2.start));

        int answer = 0;

        PriorityQueue<Class> pq = new PriorityQueue<>((c1, c2) -> Integer.compare(c1.end, c2.end));
        for (int i=0;i<N;i++) {
            while (!pq.isEmpty() && pq.peek().end <= classes.get(i).start) {
                pq.poll();
            }

            pq.add(classes.get(i));
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }
}
