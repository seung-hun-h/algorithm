import java.util.*;

public class LEET783 {
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
        TreeNode root = buildTree(new Integer[] {1,0,48,null,null,12,49});
        System.out.println(minDiffInBST(root));
    }
    static int result = 999999999;
    static int prev = -999999999;
    public static int minDiffInBST(TreeNode root) {
        if(root.left != null){
            minDiffInBST(root.left);
        }
        result = Math.min(result, root.val-prev);
        prev = root.val;
        
        if(root.right != null){
            minDiffInBST(root.right);
        }
        return result;
    }
    
    public static int minDiffInBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int res = 999999999, pre = -99999999;
        TreeNode node = root;

        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            res = Math.min(res, node.val-pre);
            pre = node.val;

            node = node.right;
        }
        return res;
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
