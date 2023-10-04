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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return result;
        q.offer(root);
        boolean leftToRight=true;
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> sublist=new ArrayList<>();
            for(int i=0;i<n;i++){
            TreeNode node=q.poll();

                // int index=(leftToRight) ? i: n-1-i;
                // sublist[index]=node.val;
                if(node.left!=null) q.offer(node.left);

                if(node.right!=null) q.offer(node.right);

                if(leftToRight){
                 sublist.add(node.val);
                }else{
                    sublist.add(0,node.val);
                }
            }
            leftToRight=!leftToRight;
            result.add(sublist);
        }

        return result;
    }
}