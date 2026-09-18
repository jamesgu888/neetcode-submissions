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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(tmp);
        }

        return res;
    }
}
