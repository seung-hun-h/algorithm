import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11000 {
    static int N;
    static ArrayList<int[]> lessons;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        lessons = new ArrayList<>();

        for (int i=0;i<N;i++) {
            String[] line = br.readLine().split(" ");
            lessons.add(new int[] {Integer.parseInt(line[0]), Integer.parseInt(line[1])});
        }

        Collections.sort(lessons, (l1, l2) -> l1[0] - l2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] lesson : lessons) {
            if (!pq.isEmpty() && pq.peek() <= lesson[0]) {
                pq.poll();
            }
            pq.add(lesson[1]);
        }
        System.out.println(pq.size());
    }
} 