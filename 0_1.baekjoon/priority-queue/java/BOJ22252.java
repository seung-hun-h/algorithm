import java.io.*;
import java.util.*;

class BOJ22252 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int Q = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> nameMap = new HashMap<>();
        long result = 0;

        for (int i = 0;i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            if (q == 1) {
                nameMap.putIfAbsent(name, new PriorityQueue<>((num1, num2) -> Integer.compare(num2, num1)));

                for (int j=0;j<k;j++) {
                    nameMap.get(name).add(Integer.parseInt(st.nextToken()));
                }

            } else {
                while (k > 0 && !nameMap.getOrDefault(name, new PriorityQueue<>()).isEmpty()) {
                    result += nameMap.get(name).poll();
                    k--;
                }
            }
        }

        System.out.println(result);
    }
}