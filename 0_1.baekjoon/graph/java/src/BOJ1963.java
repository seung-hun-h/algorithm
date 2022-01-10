import java.util.*;
import java.io.*;

public class BOJ1963 {
    static class Number {
        String value;
        int count;

        Number(String value, int count) {
            this.value = value;
            this.count = count;
        }

        public boolean isPrime() {
            int num = Integer.parseInt(value);

            for (int i=2;i<=Math.sqrt(num);i++) {
                if (num % i == 0)
                    return false;
            }

            return true;
        }

        public boolean is4Digits() {
            int num = Integer.parseInt(value);
            return 1000 <= num && num <= 9999; 
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String target = st.nextToken();

            int result = bfs(start, target);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(String start, String target) {
        Queue<Number> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(new Number(start, 0));        
        visited.add(start);

        while (!q.isEmpty()) {
            Number number = q.poll();

            if (target.equals(number.value))
                return number.count;

            for (int i=0;i<4;i++) {
                for (int j=0;j<10;j++) {

                    Number newNumber = createNewNumber(number, i, j);
                    
                    if (newNumber.is4Digits() && newNumber.isPrime() && !visited.contains(newNumber.value)) {
                        q.add(newNumber);
                        visited.add(newNumber.value);
                    }
                }
            }
        }

        return -1;
    }    

    public static Number createNewNumber(Number number, int i, int j) {
        String left = number.value.substring(0, i);
        String right = number.value.substring(i + 1);

        String newValue = left + j + right;

        return new Number(newValue, number.count + 1);
    }
}
