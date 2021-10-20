public class KAKAO8 {
    class Solution {
        public int solution(String s) {
            int sizeLimit = (int)Math.ceil(s.length() / 2);
            
            int res = s.length();
            
            for (int size=1;size<=sizeLimit;size++) {
                int count = 1;
                int length = 0;
                String prev = "", current = "";
                for (int i=0;i<s.length();i+=size) {
                    current = s.substring(i, i+size < s.length() ? i+size : s.length());
                    
                    if (current.equals(prev)) {
                        count++;
                    } else {
                        length += prev.length() + (count == 1 ? 0 : String.valueOf(count).length());
                        count = 1;
                        prev = current;
                    }
                }
                
                length += prev.length() + (count == 1 ? 0 : String.valueOf(count).length());
                res = Math.min(res, length);
            }
            
            return res;
        }
    }
}
/***
 * [카카오 2020 공채] 문자열 압축
 * 해결: O
 * 시간: 28분
 */