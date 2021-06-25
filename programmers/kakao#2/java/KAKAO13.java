import java.util.*;
public class KAKAO13 {
    class Solution {
        public int[] solution(String s) {
            String[] arrs = process(s);
            List<Integer> result = new ArrayList<>();
            Arrays.sort(arrs, (s1, s2) -> s1.length()-s2.length());
            
            for (String arr : arrs) {
                String[] nums = arr.split(",");
                
                for (int i=0;i<nums.length;i++) {
                    int num = Integer.parseInt(nums[i]);
                    
                    if(!result.contains(num))
                        result.add(num);
                }
            }
            
            System.out.println(result);
            int[] answer = new int[result.size()];
            
            for(int i=0;i<result.size();i++) {
                answer[i] = result.get(i);
            }
            return answer;
        }
        
        public String[] process(String s) {
            s = s.substring(1, s.length()-2);
            String[] strSplit = s.split("},");
            String[] arrs = new String[strSplit.length];
            
            
            for (int i=0;i<strSplit.length;i++) {
                arrs[i] = strSplit[i].substring(1, strSplit[i].length());
            }
            
            return arrs;
        }
    }
}

/***
 * [카카오 2019 인턴] 튜플
 * 해결: O
 * 시간: 20분
 * 
 */
