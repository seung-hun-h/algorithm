import java.util.*;
public class num2 {
    int max = 0;
    int end = 0;
    public static void main(String[] args){
        int n =6;
        int[] passenger = {1, 1, 1, 1, 1, 1};
        int[][] train = {{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}};
        solution(n, passenger, train);
    }
    public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {};
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] t : train){
            graph.get(t[0]).add(t[1]);
            graph.get(t[1]).add(t[0]);
        }
        
        answer = bfs(graph, passenger, 1);
        System.out.println(answer[0]+" "+ answer[1]);
        return answer;
    }
    public static int[] bfs(ArrayList<ArrayList<Integer>> graph, int[] passenger, int start){
        int[] cur = {start, passenger[start-1]};
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()+1];
        visited[start] = true;
        q.add(cur);
        int[] _max = {cur[0], cur[1]};

        while(!q.isEmpty()){
            cur = q.poll();
            System.out.println(cur[0] + " " + cur[1]);
            if(cur[1] >= _max[1]){
                if (cur[1] == _max[1]){
                    if(cur[0] > _max[0]){
                        _max[0] = cur[0];
                        _max[1] = cur[1];        
                    }
                } else {
                    _max[0] = cur[0];
                    _max[1] = cur[1];
                }
            }

            ArrayList<Integer> adj = graph.get(cur[0]);
            for(int i=0;i<adj.size();i++){
                if(!visited[adj.get(i)]){
                    visited[adj.get(i)] = true;
                    int[] _next = {adj.get(i), cur[1]+passenger[adj.get(i)-1]};
                    q.add(_next);
                }
            }
        }
        return _max;
    }
}
