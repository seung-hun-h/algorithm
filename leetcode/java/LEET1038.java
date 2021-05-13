import java.util.*;

public class LEET1038 {
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
        TreeNode root = buildTree(new Integer[] {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        printTree(root);
        bstToGst(root);
        printTree(root);
    }
    static int val = 0;
    public static TreeNode bstToGst(TreeNode root) {
        if(root != null){
            bstToGst(root.right);
            val += root.val;
            root.val = val;
            bstToGst(root.left);
        }
        return root;
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
