import java.util.*;
import java.io.*;
public class BOJ2250 {
    static int N;
    static int[][] tree;
    static boolean[] isChild;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        tree = new int[N+1][2];
        isChild = new boolean[N+1];
        HashMap<Integer, ArrayList<Integer>> cols = new HashMap<>();

        for (int i=0;i<N;i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            tree[u][0] = v;
            tree[u][1] = w;
            cols.put(u, new ArrayList<>());
            if (v >= 0)
                isChild[v] = true;
            if (w >= 0)
                isChild[w] = true;
        }

        int root = findRoot();
    
        findColForLevel(root, cols, 1);
        int[] result = {0, -1};
        for (int i=1;i<=N;i++) {
            if (cols.containsKey(i)) {
                ArrayList<Integer> value = cols.get(i);
                if (value.isEmpty()) continue;
                Collections.sort(value);
                int width = value.get(value.size()-1) - value.get(0) + 1;

                if (width > result[1]) {
                    result[0] = i;
                    result[1] = width;
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
    static int col = 1;
    public static void findColForLevel(int node, HashMap<Integer, ArrayList<Integer>> cols, int level) {
        if (node == -1)
            return;

        findColForLevel(tree[node][0], cols, level+1);
        cols.get(level).add(col++);
        findColForLevel(tree[node][1], cols, level+1);
    }
    public static int findRoot() {
        int root = 1;
        for(int i=1;i<isChild.length;i++) {
            if (!isChild[i]){
                root = i;
                break;
            }
        }
        return root;
    }
}
