/**
 * [카카오 인턴] 키패드 누르기
 * 해결: O
 * 시간: 17분
 */

public class KAKAO1 {
    class Solution {
        int[][] numPadPos = {
            {3, 1},
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1},
            {1, 2},
            {2, 0},
            {2, 1},
            {2, 2},
    
        };
    
        int[] left = {3, 0}, right = {3, 2};
        String mainHand = "";
        public String solution(int[] numbers, String hand) {
            mainHand = hand.equals("right") ? "R" : "L";
            String answer = "";
            
            for (int number : numbers) {
                String location = pushNumber(number);
                answer += location;
                
                if (location.equals("R")){
                    right = numPadPos[number];
                } else{
                    left = numPadPos[number];
                }
            }
            
            return answer;
        }
        
        private String pushNumber(int number) {
            if (number == 1 || number == 4 || number == 7)
                return "L";
            
            if (number == 3 || number == 6 || number == 9)
                return "R";
            
            if (getDist(left, number) > getDist(right, number))
                return "R";
            if (getDist(left, number) < getDist(right, number))
                return "L";
            
            return mainHand;
        }
        
        private int getDist(int[] pos, int number) {
            return Math.abs(pos[0] - numPadPos[number][0]) + Math.abs(pos[1] - numPadPos[number][1]); 
        }
    }
}