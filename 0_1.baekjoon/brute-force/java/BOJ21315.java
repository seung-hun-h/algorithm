import java.util.*;
import java.io.*;

public class BOJ21315 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] begin = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<N;i++) {
            begin[i] = i + 1;
        }

        for (int i = 1; i < N; i++) {
            if (Math.pow(2, i) >= N)
                continue;

            int[] current = clone(begin);
            shuffle(current, i, 1);
            for (int j = 1; j < N; j++) {
                if (Math.pow(2, j) >= N)
                    continue;
                int[] shuppled = clone(current);
                shuffle(shuppled, j, 1);
                
                if (isEqual(array, shuppled)) {
                    System.out.println(i +" " + j);
                    return;
                }
            }
        }
    }

    private static boolean isEqual(int[] array, int[] shuppled) {
        return Arrays.equals(array, shuppled);
    }

    private static void shuffle(int[] array, int k, int step) {
        if (step == 1) {
            int start = array.length - (int)Math.pow(2, k);
            swap(array, start, array.length - 1);
            shuffle(array, k, step + 1);
        } else if (step <= k + 1) {
            int end = (int)Math.pow(2, k - step + 2) - 1;
            int start = end - (int)Math.pow(2, k - step + 1) + 1;
            swap(array, start, end);
            shuffle(array, k, step + 1);
        }
    }

    private static void swap(int[] array, int start, int end) {
        int[] result = new int[array.length];
        int idx = 0;
        for (int i=start;i<=end;i++) {
            result[idx++] = array[i];
        }
        
        for (int i=0;i<start;i++) {
            result[idx++] = array[i];
        }
        
        for (int i=end+1;i<array.length;i++) {
            result[idx++] = array[i];
        }

        for (int i=0;i<array.length;i++) {
            array[i] = result[i];
        }
    }

    private static int[] clone(int[] array) {
        int[] result = new int[array.length];

        for (int i=0;i<result.length;i++) {
            result[i] = array[i];
        }

        return result;
    }  
}
