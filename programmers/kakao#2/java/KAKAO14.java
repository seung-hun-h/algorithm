import java.util.*;
public class KAKAO14 {
    class Solution {
        private Map<String, ArrayList<Integer>> data = new HashMap<String, ArrayList<Integer>>();
        
        public int[] solution(String[] info, String[] queries) {
            List<Integer> res = new ArrayList<>();
            processInfo(info);
            
            for (String key : data.keySet()) {
                Collections.sort(data.get(key));
            }
            
            for (String query : queries) {
                String[] q = query.replace("and", "").replace("-","").split(" ");
                int score = Integer.parseInt(q[q.length-1]);
                String key = String.join("",Arrays.copyOf(q, q.length-1));
            
                ArrayList<Integer> scores = data.getOrDefault(key, new ArrayList<>());
                
                res.add(lowerBound(scores, score));
            }
            
            
            int[] answer = new int[res.size()];
            for (int i=0;i<answer.length;i++) {
                answer[i] = res.get(i);
            }
            
            return answer;
        }
        
        private int lowerBound(ArrayList<Integer> scores, int target) {
            if (scores.isEmpty())
                return 0;
            
            int left = 0, right = scores.size();
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                
                if (scores.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            return scores.size() - right;
        }
        
        private void processInfo(String[] infos){
            for (String info : infos) {
                String[] line = info.split(" ");
                int score = Integer.parseInt(line[line.length-1]);
                String[] condition = Arrays.copyOf(line, line.length-1);
                
                combinations(condition, "", 0, score);
                
            }
        }
        
        private void combinations(String[] strs, String prefix, int idx, int score) {
            data.putIfAbsent(prefix, new ArrayList<>());
            data.get(prefix).add(score);
            for (int i=idx;i<strs.length;i++) {
                combinations(strs, prefix+strs[i], i+1, score);
            }
        }
    }
}
/**
 * [카카오 2021 공채] 순위 검색
 * 해결: O
 * 
 */