public class KAKAO5 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer =  intArrToBinaryStringArr(orOperate(arr1, arr2));
            
            for (int i=0;i<n;i++) {
                answer[i] = zFils(answer[i], n);
                answer[i] = answer[i].replace('1', '#').replace('0', ' ');
            }
            return answer;
        }
        
        private int[] orOperate(int[] arr1, int[] arr2) {
            for (int i=0;i<arr1.length;i++) {
                arr1[i] |= arr2[i];
            }
            return arr1;
        }
        
        private String[] intArrToBinaryStringArr(int[] arr) {
            String[] result = new String[arr.length];
            for (int i=0;i<result.length;i++) {
                result[i] = Integer.toBinaryString(arr[i]);
            }
            
            return result;
        }
        
        private String zFils(String str, int length) {
            while (str.length() < length) {
                str = "0" + str;
            }
            return str;
        }
    }
}

/**
 * [카카오 2018 공채] 비밀지도
 * 해결: O
 * 시간: 14분
 * 함수를 잘게 나누어야할 듯, 문자열 관련 함수를 잘 모른다.
 * 
 */
