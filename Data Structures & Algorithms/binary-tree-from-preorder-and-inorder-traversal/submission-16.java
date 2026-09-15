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
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preIdx, int l, int r) {
        if (l > r) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx]);

        int mid = l;
        while (inorder[mid] != preorder[preIdx]) {
            mid++;
        }

        int leftSize = mid - l;
        int rightSize = r - mid;

        root.left = buildTreeHelper(preorder, inorder, preIdx + 1, l, mid - 1);
        root.right = buildTreeHelper(preorder, inorder, preIdx + 1 + leftSize, mid + 1, r);

        return root;
    }
}
