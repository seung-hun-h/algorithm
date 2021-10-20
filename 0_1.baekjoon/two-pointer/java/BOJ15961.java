import java.util.*;
import java.io.*;

public class BOJ15961 {
    static int N, d, k, c;
    static int[] belt;
    static Set<Integer> sushi = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        belt = new int[N];

        for (int i=0;i<N;i++) {
            int s = Integer.parseInt(br.readLine());
            belt[i] = s;
            sushi.add(s);
        }

        System.out.println(getMaxKindOfSushi());
    }
    private static int getMaxKindOfSushi() {

        if (N <= k) {
            if (!sushi.contains(c)) {
                d += 1;
            }
            return d;
        }

        int[] count = new int[3001];
        int ans = 0;

        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) {
                ans++;
            }         
            count[belt[i]]++;   
        }

        int left = 0, right = k;
        int kind = ans;

        for (int i = 0; i < N - 1; i++) {
            
            // 윈도우 밖 원소 제거
            count[belt[left]]--;
            if (count[belt[left]] == 0) {
                kind--;
            }

            // 새로운 원소 추가
            count[belt[right]]++;
            if (count[belt[right]] == 1) {
                kind++;
            }

            // 쿠폰 사용
            if (count[c] == 0) {
                ans = Math.max(ans, kind + 1);
            } else {
                ans = Math.max(ans, kind);
            }

            left = (left + 1) % N;
            right = (right + 1) % N;
        }

        return ans;
    }    
}
