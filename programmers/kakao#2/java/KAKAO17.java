public class KAKAO17 {
    class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "(None)";
            int maxPlay = 0;
            m = process(m);
            
            for (String musicinfo : musicinfos) {
                String[] infoArr = musicinfo.split(",");
                infoArr[3] = process(infoArr[3]);
                int start = Integer.parseInt(infoArr[0].split(":")[0]) * 60 + Integer.parseInt(infoArr[0].split(":")[1]);
                int end = Integer.parseInt(infoArr[1].split(":")[0]) * 60 + Integer.parseInt(infoArr[1].split(":")[1]);
                
                int diff = end - start;
                
                StringBuffer sb = new StringBuffer();
                for(int i=0;i<diff/infoArr[3].length();i++) {
                    sb.append(infoArr[3]);
                }
                sb.append(infoArr[3].substring(0, diff % infoArr[3].length()));
                
                String music = sb.toString();
    
                if (music.indexOf(m) != -1) {
                    if (maxPlay < diff) {
                        answer = infoArr[2];
                        maxPlay = diff;
                    }
                }
            }
            return answer;
        }
        public String process(String str){
            return str.replace("A#", "a").replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g");
        }
    }
}
/**
 * [카카오 2018 공채] 방금 그 곡
 * 해결: O
 */