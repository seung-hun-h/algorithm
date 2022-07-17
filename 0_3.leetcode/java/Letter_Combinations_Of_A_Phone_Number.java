import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_Of_A_Phone_Number {
    private static final char OFFSET = '2';
    private static String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        combinations(result, "", digits, 0);
        return result;
    }

    private void combinations(List<String> result, String current, String digits, int idx) {
        if (idx == digits.length()) {
            if (!current.isEmpty()) {
                result.add(current);
            }
            return;
        }

        String letter = letters[digits.charAt(idx) - OFFSET];
        for (int i=0;i<letter.length();i++) {
            combinations(result, current + letter.charAt(i), digits, idx + 1);
        }
    }
}
