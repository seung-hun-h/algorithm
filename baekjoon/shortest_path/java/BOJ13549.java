import java.io.*;
import java.util.*;

public class BOJ13549 {
    static class Point {
        int x;
        int time;
        
        Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    static final int INF = 100002;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
        
    }
    private static int bfs(int n, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p1.time - p2.time);
        int[] dist = new int[INF + 1];

        for (int i=0;i<dist.length;i++) {
            dist[i] = INF;
        }

        pq.add(new Point(n, 0));
        dist[n] = 0;

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            System.out.println(current.x +" " + current.time);
            if (current.x == k)
                return current.time;

            if (current.time > dist[current.x]) continue;

            int nextX = current.x + 1;
            int nextTime = current.time + 1;

            if (nextX <= INF && dist[nextX] > nextTime) {
                dist[nextX] = nextTime;
                pq.add(new Point(nextX, nextTime));
            }
            
            nextX = current.x * 2;
            nextTime = current.time;
            
            if (nextX <= INF && dist[nextX] > nextTime) {
                dist[nextX] = nextTime;
                pq.add(new Point(nextX, nextTime));
            }
            
        
            nextX = current.x - 1;
            nextTime = current.time + 1;

            if (nextX >= 0 && dist[nextX] > nextTime) {
                dist[nextX] = nextTime;
                pq.add(new Point(nextX, nextTime));
            }
        }
        return -1;
    }
}
