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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
         ArrayList<Integer> l1=new ArrayList<>();
        ArrayList<Integer> l2=new ArrayList<>();
        leaf(root1,l1);
        leaf(root2,l2);
        return l1.equals(l2);
    }
    public void leaf(TreeNode root,ArrayList<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        
        leaf(root.left,list);
        leaf(root.right,list);
    }
}