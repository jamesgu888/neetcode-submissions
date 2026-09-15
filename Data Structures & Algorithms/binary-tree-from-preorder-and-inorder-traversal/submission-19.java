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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> positions = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            positions.put(inorder[i], i);
        }

        return buildTreeHelper(positions, preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(Map<Integer, Integer> positions, int[] preorder, int[] inorder, int preIdx, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = positions.get(preorder[preIdx]);
        TreeNode root = new TreeNode(inorder[mid]);

        int leftSize = mid - l;
        int rightSize = r - mid;

        root.left = buildTreeHelper(positions, preorder, inorder, preIdx + 1, l, mid - 1);
        root.right = buildTreeHelper(positions, preorder, inorder, preIdx + 1 + leftSize, mid + 1, r);

        return root;
    }
}
