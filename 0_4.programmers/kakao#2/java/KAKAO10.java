import java.util.*;
public class KAKAO10 {
    class Solution {
        Map<String, Integer>[] counters;
        public String[] solution(String[] orders, int[] course) {
            counters = new Map[11];
            
            for (int i=0;i<=10;i++) {
                counters[i] = new HashMap<String, Integer>();
            }
            
            for (String order : orders) {
                order = sort(order);
                permutation("", order);
            }
            
            List<String> maxCourses = new ArrayList<>();
            
            for (int c : course) {
                maxCourses.addAll(getMaxCourse(new ArrayList<Map.Entry<String, Integer>>(counters[c].entrySet())));
            }
            Collections.sort(maxCourses);
            return maxCourses.toArray(new String[maxCourses.size()]);
        }
        
        private List<String> getMaxCourse(ArrayList<Map.Entry<String, Integer>> counter) {
            List<String> result = new ArrayList<>();
            
            Collections.sort(counter, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            
            if (!counter.isEmpty()) {
                int max = counter.get(0).getValue();
                if (max >= 2){
                    for (Map.Entry<String, Integer> count : counter) {
                        if (count.getValue() != max) 
                            break;
                        result.add(count.getKey());
                    }
                }
            }
            return result;
        }
        private String sort(String str) {
            char[] charArray = str.toCharArray();
            
            Arrays.sort(charArray);
            
            return new String(charArray);
        }
        private void permutation(String prefix, String current) {
            if (prefix.length() > 1) {
                counters[prefix.length()].putIfAbsent(prefix, 0);
                counters[prefix.length()].compute(prefix, (String key, Integer value) -> value+1);
            }
            
            for (int i=0;i<current.length();i++) {
                permutation(prefix+current.substring(i, i+1), current.substring(i+1, current.length()));
            }
        }
    }
}

/**
 * [카카오 2021 공채] 메뉴 리뉴얼
 * 해결: O
 * 시간: 37분
 * 
 */
