import java.util.*;

class KAKAO19 {
    List<Set<String>> results = new ArrayList<>();
    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> candidates = new ArrayList<>(); // banned_id  가능한 후보들    
        
        for (int i=0;i<banned_id.length;i++) {
            List<String> candidate = new ArrayList<>();
            
            for (String id : user_id) {
                if (isLike(id, banned_id[i]))
                    candidate.add(id);
            }
            candidates.add(candidate);
        }
        
        combine(new HashSet<String>(), candidates, 0, banned_id.length);
        return results.size();
    }
    
    private void combine(Set<String> current, List<List<String>> candidates, int idx, int limit) {
        
        if (current.size() == limit) {
            if (check(current)) {
                results.add(new HashSet<>(current));
            }
            return;
        }
        
        for (String candidate : candidates.get(idx)) {
            if (!current.contains(candidate)) {
                current.add(candidate);
                combine(current, candidates, idx+1, limit);
                current.remove(candidate);
            }
        }
    }
    
    public boolean check(Set<String> target) {
        for (Set<String> result : results) {
            Set<String> temp = new HashSet<>(target);
            temp.removeAll(result);
            
            if(temp.isEmpty()){
                return false;
            }
        }
        return true;
    }
    
    public boolean isLike(String target, String key) {
        if (target.length() != key.length())
            return false;
        
        for (int i=0;i<key.length();i++) {
            if (key.charAt(i) == '*')
                continue;
            
            if (key.charAt(i) != target.charAt(i))
                return false;
        }
        
        return true;
    }
}
/***
 * [카카오 2019 인턴] 불량 사용자
 * 해결: X
 * 시간: 1시간 15분
 */