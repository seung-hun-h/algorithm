import java.util.*;
public class KAKAO11 {
    class Solution {
        public String solution(String p) {
            if (p.length() == 0)
                return "";
        
            int balancedIdx = getBalancedIdx(p);
            String u = p.substring(0, balancedIdx+1);
            String v = p.substring(balancedIdx+1, p.length());

            if (isCorrected(u))
                return u += solution(v);
            
            String temp = "(";
            temp += solution(v);
            temp += ")";
            
            temp += process(u);
            
            return temp;
        }
        
        private String process(String str) {
            String result = "";
            
            for(int i=1;i<str.length()-1;i++) {
                if (str.charAt(i) == '(') {
                    result += ")";
                } else {
                    result += "(";
                }
            }
            return result;
        }
        
        private boolean isCorrected(String str) {
            Stack<Character> stack = new Stack<>();
            
            for (int i=0;i<str.length();i++) {
                char current = str.charAt(i);
                
                if (current == '(') {
                    stack.add(current);
                } else {
                    if (stack.isEmpty())
                        return false;
                    stack.pop();
                }
            }
            return true;
        }
        
        private int getBalancedIdx(String str) {
            int count = 1;
            int i = 1;
            char first = str.charAt(0);
            for (;i<str.length();i++) {
                if (str.charAt(i) == first) {
                    count++;
                } else {
                    count--;
                }
                
                if (count == 0)
                    break;
            }
            return i;
        }
    }
}
/**
 * [카카오 2020 공채] 괄호 변환
 * 해결: O
 * 시간: 측정 안함, 빨리 끝남 
 * 
 */