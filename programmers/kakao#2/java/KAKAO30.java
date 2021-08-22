import java.util.*;
class KAKAO30 {
    public String solution(int n, int k, String[] cmds) {
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2) -> o1 - o2);
        Stack<Integer> removed = new Stack<>();
        
        // 처음에 선택된 행
        for (int i=0;i<=k;i++) {
            left.add(i);
        }
        
        for (int i=k+1;i<n;i++) {
            right.add(i);
        }
        
        
        for (String cmd : cmds) {
            String c = cmd.split(" ")[0];
            
            if (c.equals("U")) {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                
                for (int i=0;i<num;i++) {
                    right.add(left.poll());
                }
            } else if (c.equals("D")) {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                
                for (int i=0;i<num;i++) {
                    left.add(right.poll());
                }
            } else if (c.equals("C")) {
                removed.add(left.poll());
                
                if (!right.isEmpty())
                    left.add(right.poll());
                
            } else {
                if (removed.peek() > left.peek()) {
                    right.add(removed.pop());
                } else {
                    left.add(removed.pop());
                }
            }
        }
        
        boolean[] removedMark = new boolean[n];
        for (int i=0;i<removed.size();i++) {
            removedMark[removed.get(i)] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0;i<n;i++) {
            if (!removedMark[i])
                sb.append("O");
            else
                sb.append("X");
        }
        return sb.toString();
    }
}
/**
 * [카카오 2021 인턴] 표 편집
 * 해결: O
 */