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
    public int diameterOfBinaryTree(TreeNode root) {
       int diameter[] = new int[1];
        height(root, diameter);
        return diameter[0];        
    }

    private int height(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        // Similar to max height of tree
        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);
        // have to add this below step in order to find longest path
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}