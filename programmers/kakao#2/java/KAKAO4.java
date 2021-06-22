import java.util.*;
public class KAKAO4 {
    class Solution {
        static class Stage {
            int stage;
            float value;
            Stage(int stage, float value) {
                this.stage = stage;
                this.value = value;
            }
            
            public String toString() {
                return "stage = " + stage + " value = " + value;
            }
        }
        public int[] solution(int N, int[] stages) {
            Stage[] stagesObj = getFails(N, stages);
            
            Arrays.sort(stagesObj, (s1, s2) -> Float.compare(s2.value, s1.value));
            
            int[] answer = new int[N];
            for (int i=0;i<N;i++) {
                answer[i] = stagesObj[i].stage;
                System.out.println(stagesObj[i]);
            }
            
            return answer;
        }
        public Stage[] getFails(int N, int[] stages) {
            Stage[] result = new Stage[N];
            int m = stages.length;
            int j = 0;
            Arrays.sort(stages);
            for (int s=1;s<=N;s++) {
                int prev = j;
                while (j < stages.length && stages[j] == s)
                    j++;
                
                if (m != 0){
                    result[s-1] = new Stage(s, (j - prev) / (float)m);
                    m -= (j - prev);
                } else {
                    result[s-1] = new Stage(s, 0);
                }
            }
            return result;
        }
    }
}
/**
 * [카카오 2019 공채] 실패율
 * 해결: O
 * 시간: 35분
 * 자바는 객체로 설계하는 것이 매우 좋을 듯
 * 
 */
