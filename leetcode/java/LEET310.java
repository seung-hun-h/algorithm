import java.util.*;
public class LEET310 {
    public static void main(String[] args) {
        System.out.println(findMinHeightTrees(4, new int[][] {{1,0},{1,2},{1,3}}));
    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if(n <= 1){
            leaves.add(0);
            return leaves;
        }
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<>());
            }
            if(!graph.containsKey(edge[1])){
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++){
            if(graph.get(i).size() == 1){
                leaves.add(i);
            }
        }

        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves){
                int neighbor = graph.get(leaf).remove(0);
                graph.get(neighbor).remove(Integer.valueOf(leaf));

                if(graph.get(neighbor).size() == 1){
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }
        return leaves;
    }
}
