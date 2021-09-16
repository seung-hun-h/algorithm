import java.io.*;

public class BOJ6603 {
    static final int LIMIT = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while ((line = br.readLine()).length() != 1) {
            String[] splited = line.split(" ");
            int len = Integer.parseInt(splited[0]);

            int[] arr = new int[len];

            for (int i=0;i<len;i++) {
                arr[i] = Integer.parseInt(splited[i + 1]);
            }
            
            dfs(arr, 0, new int[LIMIT], 0);
            System.out.println();
        }
    }
    private static void dfs(int[] arr, int current, int[] result, int idx) {
        
        if (idx == LIMIT) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i=current;i<arr.length;i++) {
            result[idx] = arr[i];
            dfs(arr, i+1, result, idx+1);
        }
    }
}
