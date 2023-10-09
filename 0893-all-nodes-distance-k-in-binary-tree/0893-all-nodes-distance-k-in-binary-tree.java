/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

 public void markParents(Map<TreeNode,TreeNode> parentTrack,TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.remove();
            if(node.left!=null){
                q.offer(node.left);
                parentTrack.put(node.left,node);
            }
            if(node.right!=null){
                q.offer(node.right);
                parentTrack.put(node.right,node);
            }
        }
    }



    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentTrack=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        HashMap<TreeNode,Boolean> visited=new HashMap<>();
        markParents(parentTrack,root);
        q.offer(target);
        visited.put(target,true);
        int currlevel=0;
        while(!q.isEmpty()){
                int size=q.size();
                if(currlevel==k) break;
                currlevel++;
                for(int i=0;i<size;i++){
                    TreeNode current=q.remove();
                    if(current.left!=null && visited.get(current.left)==null){
                        q.offer(current.left);
                        visited.put(current.left,true);
                    }
                    if(current.right!=null && visited.get(current.right)==null){
                        q.offer(current.right);
                        visited.put(current.right,true);
                    }
                    if(parentTrack.get(current)!=null && visited.get(parentTrack.get(current))==null){
                        q.offer(parentTrack.get(current));
                        visited.put(parentTrack.get(current),true);
                    }
                }
                
        }
        List<Integer> res=new ArrayList<>();
                while(!q.isEmpty()){
                    TreeNode node=q.remove();
                    res.add(node.val);
                }
                return res;

    }
}