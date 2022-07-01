import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Character {
    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Character solution = new Longest_Substring_Without_Repeating_Character();
        int answer = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println("answer = " + answer);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> idxMap = new HashMap<>();
        int left = 0;
        int answer = 0;
        for (int right=0;right<s.length();right++) {
            char ch = s.charAt(right);
            if (idxMap.get(ch) != null && left <= idxMap.get(ch)) {
                left = idxMap.get(ch) + 1;
            } else {
                answer = Math.max(answer, right - left + 1);
            }

            idxMap.put(ch, right);

        }

        return answer;
    }
}
