/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode first=new TreeNode(-1);

        curr=first;
        dfs(root);
        return first.right;
    }

    public void dfs(TreeNode root){
        if(root==null) return;

        dfs(root.left);
        curr.right=new TreeNode(root.val);
        curr=curr.right;
        dfs(root.right);
    }
}