import java.util.*;
class KAKAO25 {
    public static class Node {
        int value;
        int x, y;
        Node left, right;
        
        Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
        
        public String toString() {
            return "value = " + value;
        }
    }
    private int index = 0;
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();

        for (int i=0;i<nodeinfo.length;i++) {
            nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        sortByCoordinate(nodes);
        buildTree(nodes);
        
        int[][] answer = new int[2][nodes.size()];
        preorder(answer[0], nodes.get(0));
        index = 0;
        postorder(answer[1], nodes.get(0));
        return answer;
    }
    
    private void postorder(int[] seq, Node node) {
        if (node != null) {
            postorder(seq, node.left);
            postorder(seq, node.right);
            seq[index++] = node.value;
        }
    }
    
    private void preorder(int[] seq, Node node) {
        if (node != null) {
            seq[index++] = node.value;
            preorder(seq, node.left);
            preorder(seq, node.right);
        }
    }
    
    private void buildTree(List<Node> nodes) {
        Node root = nodes.get(0);
        
        for (int i=1;i<nodes.size();i++) {
            addNode(root, nodes.get(i));
        }
    }
    
    private void addNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                addNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                addNode(parent.right, child);
            }
        }
    }
    
    private void sortByCoordinate(List<Node> nodes) {
        Collections.sort(nodes, new Comparator<>() {
           public int compare(Node n1, Node n2) {
               if (n1.y != n2.y) 
                   return n2.y - n1.y;
               return n1.x - n2.x;
           } 
        });
    }
}
/***
 * [카카오 2019 공채] 길 찾기 게임
 * 해결: X
 */