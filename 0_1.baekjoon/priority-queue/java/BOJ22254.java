import java.util.*;
import java.io.*;

class BOJ22254 {
    static int N, X;
    static int[] gifts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        gifts = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            gifts[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = N + 1;
        int ans = right;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            boolean result = underLimitTimes(mid);
            if (!result) {
                left = mid;
            } else {
                right = mid;
                ans = right;
            }
        }
        System.out.println(ans);

    }
    private static boolean underLimitTimes(int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0;
        for (; i < Math.min(N, k); i++){
            pq.add(gifts[i]);
        }

        while (!pq.isEmpty()) {
            int gift = pq.poll();
            
            if (gift > X) return false;

            if (i < N) {
                pq.add(gifts[i++] + gift);
            }
        }

        return true;
    }
}