import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ8980 {
    public static class Delivery {
        int from;
        int to;
        int box;
        Delivery(int from, int to, int box) {
            this.from = from;
            this.to = to;
            this.box = box;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        Delivery[] works = new Delivery[M];
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            works[i] = new Delivery(from, to, box);
        }

        Arrays.sort(works, (o1, o2) -> o1.to - o2.to);
        int[] delivered = new int[N+1];
        int total = 0;
        for (int i=0;i<M;i++) {
            Delivery info = works[i];
            int max = 0;
            int possible = 0;
            for (int j=info.from;j<info.to;j++) {
                max = Math.max(max, delivered[j]);
            }

            possible = Math.min(C-max, info.box);
            total += possible;
            
            for (int j=info.from;j<info.to;j++) {
                delivered[j] += possible;
            }
        }
        System.out.println(total);
    }
}
