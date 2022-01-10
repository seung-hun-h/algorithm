import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ18513 {
    private static int N, K;
    private static Set<Integer> places;
    private static int[] d = {-1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        places = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            places.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solve());
    }

    private static long solve() {
        return bfs();
    }

    private static long bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int place : places) {
            q.add(new int[] {place, 0});
        }

        int count = 0;
        long unhappy = 0;

        while(!q.isEmpty()) {

            int place = q.peek()[0];
            int value = q.poll()[1];

            for (int i=0;i<2;i++) {
                int np = place + d[i];
                if (places.contains(np)) continue;

                places.add(np);
                q.add(new int[] {np, value + 1});

                count++;
                unhappy += (value + 1);
                if (count == K) {
                    return unhappy;
                }
            }

        }
        return -1;
    }
}
