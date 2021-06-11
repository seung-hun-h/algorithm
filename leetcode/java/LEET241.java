import java.util.ArrayList;
import java.util.List;

public class LEET241 {
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("11"));
    }
    static char add = '+';
    static char subs = '-';
    static char mul = '*';
    public static List<Integer> diffWaysToCompute(String expression) {
        if (expression.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        if (isNumber(expression)) {
            results.add(Integer.valueOf(expression));
            return results;
        }
        
        for (int i=0;i<expression.length();i++) {
            char value = expression.charAt(i);

            if (value == add || value == subs || value == mul) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1, expression.length()));
                
                List<Integer> sub_results = compute(left, right, value);
                results.addAll(sub_results);
            }
        }
        return results;
    }

    public static boolean isNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> compute(List<Integer> left, List<Integer> right, char op) {
        List<Integer> result = new ArrayList<>();
        for (int l : left) {
            for (int r : right) {
                if (op == subs) {
                    result.add(l - r);
                } else if (op == add) {
                    result.add(l + r);
                } else {
                    result.add(l * r);
                }
            }
        } 
        return result;
    }
}
