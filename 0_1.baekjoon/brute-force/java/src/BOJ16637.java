import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ16637 {
  static int N;
  static List<Integer> numbers;
  static List<Character> operators;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    numbers = new ArrayList<>();
    operators = new ArrayList<>();

    parse(br.readLine());

    System.out.println(dfs(numbers.get(0), 0));
  }

  private static int dfs(int number, int idx) {

    if (idx == operators.size()) {
      return number;
    }

    // 괄호 없는 경우
    int result = calc(number, numbers.get(idx + 1), operators.get(idx));
    int max = dfs(result, idx + 1);

    if (idx + 1 < operators.size()) {
      int temp = calc(numbers.get(idx + 1), numbers.get(idx + 2), operators.get(idx + 1));
      result = calc(number, temp, operators.get(idx));

      max = Math.max(max, dfs(result, idx + 2));
    }

    return max;
  }

  private static int calc(int number1, int number2, char operator) {

    switch (operator) {
      case '+':
        return number1 + number2;
      case '*':
        return number1 * number2;
      default:
        return number1 - number2;
    }
  }

  private static void parse(String expression) {
    int prev = -1;
    for (int i = 0; i < N; i++) {
      if (!Character.isDigit(expression.charAt(i))) {
        numbers.add(Integer.parseInt(expression.substring(prev + 1, i)));
        operators.add(expression.charAt(i));
        prev = i;
      }
    }
    numbers.add(Integer.parseInt(expression.substring(prev + 1)));
  }
}
