/**
 * [카카오 개발자 겨울 인턴] 크레인 인형 뽑기
 * 해결: O
 * 시간: 14분
 */
import java.util.*;
public class KAKAO2 {
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> result = new Stack<>();
            
            for (int move : moves) {
                for (int j=0;j<board.length;j++) {
                    if(board[j][move - 1] != 0) {
                        if (result.isEmpty()) {
                            result.add(board[j][move - 1]);
                            board[j][move - 1] = 0;
                            break;
                        }

                        if (board[j][move-1] == result.peek()) {
                            result.pop();
                            answer += 2;
                        } else {
                            result.add(board[j][move-1]);
                        }
                        board[j][move-1] = 0;
                        break;

                    }
                }
            }
                
            return answer;
        }
    }
}
