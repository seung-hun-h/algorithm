import java.io.*;
import java.util.*;

class BOJ1484 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        
        int left = 1, right = 1;
        List<Integer> result = new ArrayList<>();

        while ((int)(Math.pow(right, 2) - Math.pow(right - 1, 2)) <= G) {
            int diff = (int)(Math.pow(right, 2) - Math.pow(left, 2));

            if (diff == G) {
                result.add(right++);
            } else if (diff > G) {
                left++;
            } else {
                right++;
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } {
            result.forEach(r -> System.out.println(r));
        }
    }
}