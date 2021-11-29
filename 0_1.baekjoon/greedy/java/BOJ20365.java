import java.util.*;
import java.io.*;

public class BOJ20365 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String sequence = br.readLine();
        Map<Character, Integer> count = new HashMap<>();
        count.put('B', 0);
        count.put('R', 0);

        char current = sequence.charAt(0);
        char next = current;

        for (int i = 1; i < N; i++) {
            next = sequence.charAt(i);
            if (current != next) {
                count.compute(current, (key, value) -> value + 1);
                current = next;
            }
        }

        count.compute(next, (key, value) -> value + 1);

        if (sequence.length() == 1) {
            System.out.println(1);
        } else {
            System.out.println(Math.min(count.get('B'), count.get('R')) + 1);
        }       


    }
}