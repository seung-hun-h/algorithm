import java.util.*;
import java.io.*;

class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        solve1(line);
        solve2(line);
    }

    public static void solve2(String line) {
        String[] splited = line.split("\\-");
        int result = 0;
        
        for (String num : splited[0].split("\\+")) {
            result += Integer.parseInt(num);
        }

        for (int i=1;i<splited.length;i++) {
            for (String num : splited[i].split("\\+")) {
                result -= Integer.parseInt(num);
            }
        }
        

        System.out.println(result);
    }

    public static void solve1(String line) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int prev = -1;
        int len = line.length();
        for (int i=0;i<len;i++) {
            char ch = line.charAt(i);

            if (!Character.isDigit(ch)) {
                numbers.add(Integer.parseInt(line.substring(prev + 1, i)));
                
                if (!operators.isEmpty() && operators.peek() == '+') {
                    operators.pop();
                    if (numbers.size() > 1) {
                        numbers.add(numbers.pop() + numbers.pop());
                    }
                }
                operators.add(ch);
                prev = i;
            }
  
        }
        numbers.add(Integer.parseInt(line.substring(prev + 1)));
        
        while (!operators.isEmpty() && operators.peek() == '+') {
            operators.pop();
            numbers.add(numbers.pop() + numbers.pop());
        }
        
        int result = 0;
        for (int i=1;i<numbers.size();i++) {
            result += numbers.get(i);
        }

        result = numbers.get(0) - result;

        System.out.println(result);
    }
}