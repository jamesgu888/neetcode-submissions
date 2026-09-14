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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalHelper(res, root);
        return res;
    }

    public void inorderTraversalHelper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversalHelper(res, root.left);
        res.add(root.val);
        inorderTraversalHelper(res, root.right);
    }
}