import java.util.*;
import java.io.*;

public class BOJ1062 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] words = new String[N];

        for (int i=0;i<N;i++) {
            String line = br.readLine();
            String word = line.substring(4, line.lastIndexOf("tica"));
            words[i] = word;
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }

        int mask = 0;

        for (char ch : new char [] {'a', 'c', 'i', 'n', 't'}) {
            mask |= (1 << (ch - 'a'));
        }

        System.out.println(dfs(words, mask, K - 5, 0));
    }

    private static int dfs(String[] words, int mask, int k, int start) {
        if (k == 0) {
            return countReadableWords(words, mask);
        }

        int count = 0;
        for (int i=start;i<26;i++) {
            if ((mask & (1 << i)) != 0) continue;
            count = Math.max(count, dfs(words, mask | (1 << i), k - 1, i));
        }
        
        return count;
    }

    private static int countReadableWords(String[] words, int mask) {
        int count = 0;
        for (String word : words) {
            if (isReadable(word, mask))
                count++;
        }

        return count;
    }

    private static boolean isReadable(String word, int mask) {
        for(char ch : word.toCharArray()) {
            if ((mask & (1 << (ch - 'a'))) == 0)
                return false;
        }
        return true;
    }
}
