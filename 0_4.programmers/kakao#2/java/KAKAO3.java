public class KAKAO3 {  
    class Solution {
        public String solution(String new_id) {
            KAKAOID kakaoId = new KAKAOID(new_id);
    
            kakaoId.replaceToLowerCase()
                .deleteUnpermittedChar()
                .replaceDoubleDotToSingle()
                .deleteFirstDot()
                .deleteLastDot()
                .appendAifAbsent()
                .spliceIfOverLimit()
                .deleteLastDot()
                .appendAifAbsent()
                .spliceIfOverLimit()
                .appendIfShort();
    
            return kakaoId.id;
        }
        private static class KAKAOID {
            private String id;
            KAKAOID(String id) {
                this.id = id;
            }
            private KAKAOID replaceToLowerCase() {
                this.id = this.id.toLowerCase();
                return this;
            }
            private KAKAOID deleteUnpermittedChar() {
                StringBuilder sb = new StringBuilder();
                for (char ch : this.id.toCharArray()) {
                    if (Character.isDigit(ch) || Character.isAlphabetic(ch) || ch == '-' || ch == '.' || ch == '_') {
                        sb.append(ch);
                    }
                }
    
                this.id = sb.toString();
                return this;
            }
    
            private KAKAOID replaceDoubleDotToSingle() {
                while (this.id.indexOf("..") != -1) {
                    this.id = this.id.replace("..", ".");
                }
                return this;
            }
    
            private KAKAOID deleteFirstDot() {
                if (this.id.length() != 0 && this.id.charAt(0) == '.') {
                    this.id = this.id.substring(1, this.id.length());
                }
                return this;
            }
    
            private KAKAOID deleteLastDot() {
                if (this.id.length() != 0 && this.id.charAt(this.id.length()-1) == '.') {
                    this.id = this.id.substring(0, this.id.length()-1);
                }
                return this;
            }
    
            private KAKAOID appendAifAbsent() {
                if (this.id.length() == 0) {
                    this.id += "a";
                }
                return this;
            }
    
            private KAKAOID spliceIfOverLimit() {
                if (this.id.length() >= 16) {
                    this.id = this.id.substring(0, 15);
                }
                return this;
            }
    
            private KAKAOID appendIfShort() {
                while (this.id.length() < 3) {
                    this.id += String.valueOf(this.id.charAt(this.id.length()-1));
                }
                return this;
            }
    
        }
    }
}
/**
 * [카카오 2021 공채] 신규 아이디 추천
 * 해결: O
 * 시간: 16분
 */

