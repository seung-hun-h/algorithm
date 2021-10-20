import java.util.*;
class num3 {
    public static void main(String[] args){
        solution({ { 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1} }, 2);    
    }
    int _max = 0;
    public int solution(int[][] needs, int r) {
        int answer = 0;
        int col_length = needs[0].length;
        boolean[] visited = new boolean[col_length];
        combination(new ArrayList<Integer>(), visited, 0, col_length, r, needs);
        
        answer = _max;
        return answer;
    }
    public void combination(ArrayList<Integer> result, boolean[] visited, int idx, int length, int r, int[][] needs){
        if(r == 0){
            _max = Math.max(_max, count_possible(result, needs));
            return;
        }
        for(int i=idx;i<length;i++){
            if(!visited[i]){
                result.add(i);
                visited[i] = true;
                combination(result, visited, idx+1, length, r-1, needs);
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
    }
    public int count_possible(ArrayList<Integer> result, int[][] needs){
        int cnt = 0;
        for(int[] need : needs){
            int[] temp = new int[need.length];
            for(int i=0;i<temp.length;i++){
                temp[i] = need[i];
            }
            boolean flag = true;
            for(int r : result){
                temp[r] = 0;
            }
            for(int i=0;i<temp.length;i++){
                if(temp[i] == 1){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                cnt++;
            }       
        }
        return cnt;
    }
}