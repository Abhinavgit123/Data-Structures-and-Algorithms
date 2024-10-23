class Solution {

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        List<Integer> levelSums = new ArrayList<>();

        // First BFS: Calculate sum of nodes at each level
       while(!nodeQueue.isEmpty()){
        int levelsum=0;
        
        int size=nodeQueue.size();
        for(int i=0;i<size;i++){
            TreeNode current=nodeQueue.poll();
            levelsum+=current.val;
            if(current.left!=null){
                nodeQueue.offer(current.left);
            }
            if(current.right!=null){
                nodeQueue.offer(current.right);
            }
        }
        levelSums.add(levelsum);
       }

       nodeQueue.offer(root);
       root.val=0;
       int levelIndex=1;
       while(!nodeQueue.isEmpty()){
        int size=nodeQueue.size();

       for(int i=0;i<size;i++){
        TreeNode current=nodeQueue.poll();
            int childSum=(current.left!=null ? current.left.val:0) + (current.right!=null ? current.right.val :0);
            if(current.left!=null){
                current.left.val=levelSums.get(levelIndex) - childSum;
                nodeQueue.offer(current.left);
            }
             if(current.right!=null){
                current.right.val=levelSums.get(levelIndex) - childSum;
                nodeQueue.offer(current.right);
            }
        }
        levelIndex++;
       }

        return root;
    }
}