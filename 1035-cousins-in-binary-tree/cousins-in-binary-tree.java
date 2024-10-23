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
 class NodeInfo{
    TreeNode parent;
    int depth;
    NodeInfo(TreeNode parent,int depth){
        this.parent=parent;
        this.depth=depth;
    }
 }

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        Map<Integer,NodeInfo> map=new HashMap<>();
        q.add(root);
        map.put(root.val,new NodeInfo(null,0));

        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.left!=null){
                q.add(current.left);
                map.put(current.left.val,new NodeInfo(current,map.get(current.val).depth+1));

            }

              if(current.right!=null){
                q.add(current.right);
                map.put(current.right.val,new NodeInfo(current,map.get(current.val).depth+1));
                
            }
            if(map.containsKey(x) && map.containsKey(y)){
                NodeInfo xvalue=map.get(x);
                NodeInfo yvalue=map.get(y);
                return xvalue.depth==yvalue.depth &&  xvalue.parent!=yvalue.parent;

            }

            
    }
    return false;
}
}