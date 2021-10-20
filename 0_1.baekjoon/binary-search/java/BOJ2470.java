import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = binarySearch(N, arr);
        System.out.println(result[0] +" " + result[1]);
    }
    public static int[] binarySearch(int N, int[] arr) {
        Arrays.sort(arr);
        
        int left = 0, right = N-1;
        int[] ans = new int[2];
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int result = arr[left] + arr[right];

            if (Math.abs(result) < min) {
                min = Math.abs(result);
                ans = new int[] {arr[left], arr[right]};
            }

            if (result < 0) {
                left++;
            } else if (result > 0) {
                right--;
            } else {
                break;
            }
        }

        return ans;
    }
}
