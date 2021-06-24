import java.util.*;
public class KAKAO9 {
    class Solution {
        private final int CONSTANT = 65536;
        public int solution(String str1, String str2) {
            int answer = 0;
            String str1ToUpperCase = str1.toUpperCase();
            String str2ToUpperCase = str2.toUpperCase();

            Map<String, Integer> counter1 = getStrMultipleSet(str1ToUpperCase);
            Map<String, Integer> counter2 = getStrMultipleSet(str2ToUpperCase);
            
            if (counter1.size() == 0 && counter2.size() == 0) {
                answer = CONSTANT;
            } else {
                int intersection = getIntersectionCount(counter1, counter2);
                int union = getUnionCount(counter1, counter2);
                answer = getJacard(intersection, union);
            }
            return answer;
        }
        
        private int getJacard(int inter, int union) {
            return (int)(((float) inter / union) * CONSTANT);
        }
        
        private int getIntersectionCount(Map<String, Integer> counter1, Map<String, Integer> counter2) {
            int result = 0;
            
            for (String key : counter1.keySet()) {
                result += Math.min(counter1.get(key), counter2.getOrDefault(key, 0));
            }
            
            return result;
        }
        
        private int getUnionCount(Map<String, Integer> counter1, Map<String, Integer> counter2) {
            int result = 0;
            
            for (String key : counter1.keySet()) {
                result += Math.max(counter1.get(key), counter2.getOrDefault(key, 0));
            }
            
            for (String key : counter2.keySet()) {
                if (!counter1.containsKey(key)) {
                    result += counter2.get(key);
                }
            }
            
            return result;
        }
        
        private Map<String, Integer> getStrMultipleSet(String str) {
            Map<String, Integer> result = new HashMap<String, Integer>();
            List<String> temp = new ArrayList<>();
            for(int i=0;i<str.length()-1;i++) {
                String current = str.substring(i, i+2);
                if (allAlphabetic(current)) {
                    if (!result.containsKey(current))
                        result.put(current, 0);
                    result.compute(current, (String key, Integer value) -> value+1);
                    temp.add(current);
                } 
            }
            
            return result;
        }

        private boolean allAlphabetic(String str) {
            for (int i=0;i<str.length();i++) {
                if (!Character.isAlphabetic(str.charAt(i)))
                    return false;
            }
            
            return true;
        }
    }
}
/**
 * [카카오 공채 2018] 뉴스 클러스터링
 * 해결: O
 * 시간: 35분
 * 자바 8 문법 활용 해보자!!
 * 
 */