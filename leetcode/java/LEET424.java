import java.util.Arrays;

public class LEET424 {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
    public static int characterReplacement(String s, int k) {
        int left=0, right=0;
        int[] counts = new int[26];
        int maxCharN = 0;
        for (right=1;right<=s.length();right++) {
            char ch = s.charAt(right-1);
            counts[ch - 'A']++;
            maxCharN = Math.max(maxCharN, counts[ch - 'A']);

            if (right - left - maxCharN > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
        }
        // right가 s.length()를 초과한 후 종료
        return right - left - 1;
    }
    public static int findMax(int[] counts) {
        return Arrays.stream(counts).max().getAsInt();
    }
}
