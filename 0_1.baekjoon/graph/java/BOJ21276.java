import java.io.*;
import java.util.*;


class BOJ21276 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] people = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, List<String>> descentdants = new HashMap<>();
        Map<String, PriorityQueue<String>> tree = new HashMap<>();
        Map<String, Integer> indegrees = new HashMap<>();

        for (int i=0;i<N;i++) {
            people[i] = st.nextToken();
            descentdants.put(people[i], new ArrayList<>());
            tree.put(people[i], new PriorityQueue<>());
            indegrees.put(people[i], 0);
        }

        Arrays.sort(people);

        int M = Integer.parseInt(br.readLine());

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            String desc = st.nextToken();
            String asc = st.nextToken();

            descentdants.get(asc).add(desc);
            indegrees.compute(desc, (key, value) -> value + 1);
        }
        StringBuilder sb = new StringBuilder();
        List<String> roots = new ArrayList<>();
        for (String name : people) {
            if (indegrees.get(name) == 0) {
                roots.add(name);
            }
        }
        
        sb.append(roots.size()).append("\n");

        for (String root : roots) {
            buildTree(tree, descentdants, indegrees, root);
            sb.append(root).append(" ");
        }

        sb.append("\n");
        
        for (String name : people) {
            PriorityQueue<String> children = tree.get(name);
            sb.append(name).append(" ").append(children.size());
            while(!children.isEmpty()) {
                sb.append(" ").append(children.poll());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void buildTree(Map<String, PriorityQueue<String>> tree, Map<String, List<String>> descentdants,
            Map<String, Integer> indegrees, String root) {

        Queue<String> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            
            String node = q.poll();
            
            for (String adj : descentdants.get(node)) {
                indegrees.compute(adj, (key, value) -> value - 1);

                if (indegrees.get(adj) == 0) {
                    tree.get(node).add(adj);
                    q.add(adj);
                }
            }
        }
    }
}