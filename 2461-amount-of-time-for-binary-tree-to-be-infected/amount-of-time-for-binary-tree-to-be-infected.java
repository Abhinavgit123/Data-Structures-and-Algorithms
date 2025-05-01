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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();

        TreeNode target = findStartNode(root, start); // ✅ Find the start node
        markParents(parentTrack, root);

        q.offer(target);
        visited.put(target, true);

        int res = -1; // ✅ Start from -1 to account for the first minute
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode current = q.remove();
                if (current.left != null && visited.get(current.left) == null) {
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null) {
                    q.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }
        }
        return res;
    }

    public void markParents(Map<TreeNode, TreeNode> parentTrack, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null) {
                q.offer(node.left);
                parentTrack.put(node.left, node);
            }
            if (node.right != null) {
                q.offer(node.right);
                parentTrack.put(node.right, node);
            }
        }
    }

    // ✅ Helper function to locate the target node by value
    public TreeNode findStartNode(TreeNode root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;
        TreeNode left = findStartNode(root.left, start);
        if (left != null) return left;
        return findStartNode(root.right, start);
    }
}
