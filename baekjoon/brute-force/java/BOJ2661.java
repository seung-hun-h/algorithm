import java.io.*;

public class BOJ2661 {
    static int N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        System.out.println(dfs("", N));
    }
    private static String dfs(String sequence, int n) {
        if (n == 0) {
            return sequence;
        }
        
        String result = null;
        for (int i = 1; i <= 3; i++) {
            if (result != null) {
                return result;
            }

            if (isGood(sequence + i)) {
                result = dfs(sequence + i, n - 1);
            }
        }

        return result;
    }
    private static boolean isGood(String sequence) {
        int len = sequence.length();

        for (int left = 0;left < len - 1; left++) {
            for (int right = left + 1; right < len; right++) {
                int k = 0, diff = right - left;
                
                while (right + k < len && sequence.charAt(left + k) == sequence.charAt(right + k)) {
                    k++;
                }

                if (k == diff)
                    return false;
            }
        }
        return true;
    }    
}
