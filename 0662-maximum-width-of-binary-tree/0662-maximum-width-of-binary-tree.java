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

 class Node{
     TreeNode node;
     int idx;
     Node(TreeNode node,int idx){
         this.node=node;
         this.idx=idx;
     }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> q=new LinkedList<>();
        int max=0;
        q.add(new Node(root,1));
        // if index starts from 1 l will be 2*i and r will be 2*i+1
        // if index starts from 0 l will be 2*i+1 and r will be 2*i+2
        
        while(!q.isEmpty()){
            int start=0;
            int end=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                Node nd=q.remove();
                int index=nd.idx;
                if(i==0){
                    start=index;
                }
                if(i==size-1){
                    end=index;
                }
                if(nd.node.left!=null){
                    q.add(new Node(nd.node.left,2*index));
                }
                  if(nd.node.right!=null){
                    q.add(new Node(nd.node.right,2*index+1));
                }
            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}