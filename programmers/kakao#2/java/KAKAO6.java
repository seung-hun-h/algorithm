import java.util.*;

public class KAKAO6 {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            
            List<Integer> nums = new ArrayList<>();
            
            int prev = -1;
            for (int i=0;i<dartResult.length();i++) {
                if (!Character.isDigit(dartResult.charAt(i))) {
                    if (dartResult.substring(prev+1, i).length() != 0) {
                        nums.add(Integer.parseInt(dartResult.substring(prev+1, i)));
                    }
                    prev = i;
                    
                    char oper = dartResult.charAt(i);
                    
                    if (oper == 'D') {
                        nums.set(nums.size()-1, (int)Math.pow(nums.get(nums.size()-1), 2));
                    } else if (oper == 'T') {
                        nums.set(nums.size()-1, (int)Math.pow(nums.get(nums.size()-1), 3));
                    } else if (oper == '*') {
                        nums.set(nums.size()-1, nums.get(nums.size()-1)*2);
                        if (nums.size() > 1)
                            nums.set(nums.size()-2, nums.get(nums.size()-2)*2);
                    } else if (oper == '#') {
                        nums.set(nums.size()-1, nums.get(nums.size()-1)*(-1));
                    }
                }
            }
            
            for (int num : nums) {
                answer += num;
            }
            
            return answer;
        }
    }
}

/**
 * [카카오 2018 공채] 다트 게임
 * 해결: O
 * 시간: 22분
 */