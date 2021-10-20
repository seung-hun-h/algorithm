import java.util.*;

public class LEET938 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[] {10,5,15,3,7,null,18});
        System.out.println(rangeSumBST(root, 7, 15));
    }
    public static int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
    public static int dfs(TreeNode node, int low, int high){
        if(node == null)
            return 0;

        if(node.val > high)
            return dfs(node.left, low, high);
        if(node.val < low)
            return dfs(node.right, low, high);

        return node.val + dfs(node.left, low, high) + dfs(node.right, low, high);
    }
    public static void printTree(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                System.out.print("NULL ");
                continue;
            }
            System.out.print(node.val +" ");
            
            q.add(node.left);
            q.add(node.right);
        }
        System.out.println();
    }
    public static TreeNode buildTree(Integer[] nums){
        if(nums.length == 0){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        int index = 1;
        q.add(root);
        while(index < nums.length){
            TreeNode node = q.poll();
            if(nums[index] != null){
                node.left = new TreeNode(nums[index]);
                q.add(node.left);
            }
            index++;

            if(index >= nums.length)
                break;
            
            if(nums[index] != null){
                node.right = new TreeNode(nums[index]);
                q.add(node.right);
            }
            index++;
        }
        return root;
    }
}
