import java.util.*;
public class tree {
    public class TreeNode {
        private int value;
        private int subTreeSize;
        private List<TreeNode> child;

        TreeNode(int value) {
            this.value = value;
            child = new ArrayList<>();
            subTreeSize = 1;
        }
        public int getValue() {
            return value;
        }
        public int getSubTreeSize() {
            return this.subTreeSize;
        }

        public void addSubTreeSize(int amount) {
            this.subTreeSize += amount;
        }

        public void addChild(TreeNode node) {
            child.add(node);
        }
        
        public List<TreeNode> getChild() {
            return child;
        }

        @Override
        public int hashCode() {
            return value;
        }

        @Override
        public String toString() {
            return value +" " + subTreeSize;
        }
    
    }
    private Map<Integer, TreeNode> nodes = new HashMap<>();
    private int root = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        buildTree(wires);
        findSizeOfSubtree(nodes.get(root), new HashSet<TreeNode>());


        int answer = Integer.MAX_VALUE;
        TreeNode rootTreeNode = nodes.get(root);
        for (int key : nodes.keySet()) {
            if (key == root) continue;
            TreeNode node = nodes.get(key);
            int newSubTreeSize = rootTreeNode.getSubTreeSize() - node.getSubTreeSize();
            answer = Math.min(answer, Math.abs(newSubTreeSize - node.getSubTreeSize()));
        }

        return answer;
    }

    private void findSizeOfSubtree(TreeNode node, Set<TreeNode> visited) {
        visited.add(node);
        if (node.getChild().isEmpty()) {
            return;
        }

        for (TreeNode child : node.getChild()) {
            if(!visited.contains(child)){
                findSizeOfSubtree(child, visited);
                node.addSubTreeSize(child.getSubTreeSize());
            }
        }
    }

    private void buildTree(int[][] wires) {
        for(int[] wire : wires) {
            nodes.putIfAbsent(wire[0], new TreeNode(wire[0]));
            nodes.putIfAbsent(wire[1], new TreeNode(wire[1]));
        
            TreeNode tn1 = nodes.get(wire[0]);
            TreeNode tn2 = nodes.get(wire[1]);

            tn1.getChild().add(tn2);
            tn2.getChild().add(tn1);

            root = Math.min(root, Math.min(wire[0], wire[1])); // 값이 가장 작은 노드가 루트
        }

    }
    public static void main(String[] args) {
        int result = new tree().solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
        System.out.println(result);
    }
}
