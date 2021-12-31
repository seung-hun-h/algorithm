import java.util.*;
import java.io.*;

public class BOJ6443 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            char[] word = br.readLine().strip().toCharArray();
            Arrays.sort(word);
            StringBuilder sb = new StringBuilder();
            sb.append(word).append("\n");

            while (nextPermutation(word)) {
                sb.append(word).append("\n");
            }

            System.out.print(sb);

        }
    }

    private static boolean nextPermutation(char[] word) {
        int i = word.length - 1, j = word.length - 1;

        while (i > 0 && word[i - 1] >= word[i]) {
            i--;
        }

        if (i == 0)
            return false;

        while (word[i - 1] >= word[j]) {
            j--;
        }

        swap(word, i - 1, j);
        
        Arrays.sort(word, i, word.length);

        return true;
    }

    private static void swap(char[] word, int i, int j) {
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
    }
}
