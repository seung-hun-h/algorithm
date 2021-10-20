import java.io.*;
import java.util.*;

class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, curr = 0;
        int ans = Integer.MAX_VALUE;

        while (right < N) {
            curr += arr[right];

            if (curr >= S) {

                while (left < right && curr - arr[left] >= S) {
                    curr -= arr[left++];
                }

                if (ans > right - left + 1) {
                    ans = right - left + 1;
                }
            }

            right++;
        }
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}