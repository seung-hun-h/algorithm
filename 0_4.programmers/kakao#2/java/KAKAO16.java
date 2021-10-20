import java.util.*;
public class KAKAO16 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            LinkedList<String> q = new LinkedList<>();
            
            for (String city : cities) {
                city = city.toLowerCase();
                if (q.contains(city)) {
                    q.remove(city);
                    q.addLast(city);
                    answer++;
                } else {
                    q.addLast(city);
                    
                    if (q.size() > cacheSize) {
                        q.removeFirst();
                    }
                    answer += 5;
                }
            }
            return answer;
        }
    }
}
/**
 * [2018 카카오 공채] 캐시
 * 해결: O
 * 
 */