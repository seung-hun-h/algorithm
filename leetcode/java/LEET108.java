public class LEET108 {
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
        sortedArrayToBST(new int[] {-10,-3,0,5,9});
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }
    public static TreeNode dfs(int[] nums, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = dfs(nums, start, mid-1);
        node.right = dfs(nums, mid+1, end);

        return node;
    }
}
