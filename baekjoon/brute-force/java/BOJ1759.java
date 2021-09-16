import java.io.*;
import java.util.*;

public class BOJ1759 {
    
    static final char OFFSET = 'a';
    static int L, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[] count = new int[26];
        char[] ch = br.readLine().replace(" ", "").toCharArray();
        
        for (int i=0;i<C;i++) {
            count[ch[i] - OFFSET]++;
        }

        dfs(count, 0, 0, 0);
    }
    private static void dfs(int[] count, int start, int depth, int mask) {
        if (depth == L) {
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<26;i++) {
                if ((mask & (1 << i)) != 0) {
                    sb.append((char)(OFFSET + i));
                }
            }
            if (check(sb.toString())) {
                System.out.println(sb);
            }
            return;
        }

        for (int i=start;i<26;i++) {
            if (count[i] != 0 && (mask & (1 << i)) == 0) {
                dfs(count, i + 1, depth + 1, mask | (1 << i));
            }
        }
    
    }
    private static boolean check(String string) {
        int count = 0;
        for (char ch : string.toCharArray()) {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            } 
        }

        return count >= 1 && (string.length() - count) >= 2;
    }
}
