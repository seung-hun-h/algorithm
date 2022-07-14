import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        combination(result, "", n, n);
        return result;
    }

    private void combination(List<String> result, String current, int open, int close) {
        if (open + close == 0) {
            result.add(current);
            return;
        }

        if (open > 0) {
            combination(result, current + "(", open - 1, close);
        }

        if (close > open) {
            combination(result, current + ")", open, close - 1);
        }
    }
}
