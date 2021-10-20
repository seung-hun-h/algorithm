import java.util.*;

public class LEET105 {
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
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        printTree(buildTree(preorder, inorder, 0, inorder.length-1));
    }
    static int pIndex = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder, int inStr, int inEnd){
        if(inStr <= inEnd){
            TreeNode node = new TreeNode(preorder[pIndex++]);
            if(inStr == inEnd)
                return node;

            int index = search(inorder, inStr, inEnd, node.val);

            node.left = buildTree(preorder, inorder, inStr, index-1);
            node.right = buildTree(preorder, inorder, index+1, inEnd);
            return node;
        } else {
            return null;
        }
    }
    public static int search(int[] inorder, int s, int e, int target){
        int targetIndex = s;
        for(int i=s;i<=e;i++){
            if(inorder[i] == target){
                targetIndex = i;
                break;
            }
        }
        return targetIndex;
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
