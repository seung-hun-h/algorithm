import java.util.*;
class KAKAO18 {
    public int[] solution(String[] gems) {
        HashSet<String> gemDistinct = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> counter = new HashMap<>();
        int start = 0;
        int[] result = {0, gems.length};
        
        for(int i=0;i<gems.length;i++) {
            counter.putIfAbsent(gems[i], 0);
            counter.compute(gems[i], (key, value) -> value+1);
            
            while (gemDistinct.size() == counter.keySet().size()) {
                if (i - start < result[1] - result[0]) {
                    result[0] = start+1;
                    result[1] = i+1;
                }
                
                counter.compute(gems[start], (key, value) -> value - 1);
                
                if (counter.get(gems[start]) <= 0) {
                    counter.remove(gems[start]);
                }
                start++;
            } 
        }
        
        return result;
    }
}
/***
 * [2020 카카오 인턴] 보석 쇼핑
 * 해결: O
 */