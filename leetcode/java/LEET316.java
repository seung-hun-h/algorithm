import java.util.*;

public class LEET316 {
    public static void main(String[] args) {
        String result = removeDuplicateLetters("bcabc");
        System.out.println(result);
    }
    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> counter = countLetter(s);
        Set<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            counter.put(ch, counter.get(ch)-1);
            
            if(seen.contains(ch)){
                continue;
            }

            while(!stack.isEmpty() && ch < stack.peek() && counter.get(stack.peek()) > 0){
                seen.remove(stack.pop());
            }
            stack.add(ch);
            seen.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<stack.size();i++){
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
    public static Map<Character, Integer> countLetter(String s){
        Map<Character, Integer> counter = new HashMap<>();
        char[] charArray = s.toCharArray();

        for(char ch : charArray){
            counter.put(ch, counter.getOrDefault(ch, 0)+1);
        }

        return counter;
    } 
}