import java.util.HashMap;

public class LEET76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t) {

        int missing = t.length();
        HashMap<Character, Integer> need = new HashMap<>();
        int left = 0; int start = 0; int end = 0;

        for (int i=0;i<t.length();i++) {
            int count = need.getOrDefault(t.charAt(i), 0);
            need.put(t.charAt(i), count+1);
        }

        for (int right=1;right<=s.length();right++) {
            char ch = s.charAt(right-1);
            // 아직 포함되지 않은 문자인 경우 추가
            missing -= need.getOrDefault(ch, 0) > 0 ? 1 : 0;
            // 필요한 단어 카운트 1 감소
            need.put(ch, need.getOrDefault(ch, 0)-1);
            // 모든 문자를 포함한 경우
            if (missing == 0) {

                while (left < right && need.get(s.charAt(left)) < 0) { // 필요 없는 문자 제거
                    need.put(s.charAt(left), need.get(s.charAt(left))+1);
                    left++;
                }

                if (end == 0 || right-left <= end-start) {
                    end = right; start = left;
                }
            }
        }
        return s.substring(start, end);
    }

}
