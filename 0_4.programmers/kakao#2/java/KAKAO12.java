import java.util.*;
class KAKAO12 {
    class Solution {
        private List<String> priorities = new ArrayList<>();
        private long max = 0;
        public long solution(String expression) {
            permutations("", "*+-");
            
            for (String priority : priorities) {
                findMaxResult(priority, expression);
            }
            
            return max;
        }
        
        private void findMaxResult(String priority, String expression) {
            Stack<Character> oper = new Stack<>();
            Stack<Long> nums = new Stack<>();
            int prev = -1;
            for (int i=0;i<expression.length();i++) {
                if (!Character.isDigit(expression.charAt(i))) {
                    nums.add(Long.valueOf(expression.substring(prev+1, i)));
                    prev = i;
                    if (oper.isEmpty()) {
                        oper.add(expression.charAt(i));
                    } else {
                        while (!oper.isEmpty() && isSmallerPriority(priority, expression.charAt(i), oper.peek())) {
                            nums.add(operate(nums.pop(), nums.pop(), oper.pop()));
                        }
                        oper.add(expression.charAt(i));
                    }
                    
                }
            }
            // 마지막 수
            // 남아있는 수와 연산자 처리
            // 연산자의 우선순위가 오름차순으로 정렬되어있음.
            nums.add(Long.valueOf(expression.substring(prev+1, expression.length())));
            while (!oper.isEmpty()) {
                nums.add(operate(nums.pop(), nums.pop(), oper.pop()));
            }
            max = Math.max(max, Math.abs(nums.pop()));
        }
        
        private long operate(long num1, long num2, char operation) {
            System.out.println(num1+" "+num2+" "+ operation);
            if (operation == '+') {
                return num2 + num1;   
            } else if (operation == '-') {
                return num2 - num1;
            }
            return num2 * num1;
        }
        
        // ch1 보다 ch2가 우선순위가 높거나 같은경우
        private boolean isSmallerPriority(String priority, char ch1, char ch2) {
            int idx1 = 0;
            int idx2 = 0;
            
            // 더 앞에 위치한 연산자가 우선순위가 높다.
            for (int i=0;i<priority.length();i++) {
                if (priority.charAt(i) == ch1)
                    idx1 = i;
                if (priority.charAt(i) == ch2)
                    idx2 = i;
            }
            
            return idx1 >= idx2;
        }
        
        private void permutations(String prefix, String str) {
            if (str.length() == 0) {
                priorities.add(prefix);
                return;
            }
            
            for (int i=0;i<str.length();i++) {
                permutations(prefix+str.substring(i, i+1), str.substring(0, i) + str.substring(i+1, str.length()));
            }
        }
    }
}

/***
 * [카카오 2020 인턴] 수식 최대화
 * 해결: O
 * 시간: 57분
 * 다시 풀 필요 있다.
 */