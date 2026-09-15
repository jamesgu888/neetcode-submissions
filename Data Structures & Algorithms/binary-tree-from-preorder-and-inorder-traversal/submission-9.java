class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(
            preorder, inorder, 0, 0, inorder.length - 1
        );
    }

    private TreeNode buildTreeHelper(
        int[] preorder,
        int[] inorder,
        int preIdx,
        int l,
        int r
    ) {
        if (l > r) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx]);

        int mid = l;
        while (inorder[mid] != root.val) {
            mid++;
        }

        int leftSize = mid - l;

        root.left = buildTreeHelper(
            preorder, inorder,
            preIdx + 1,
            l, mid - 1
        );

        root.right = buildTreeHelper(
            preorder, inorder,
            preIdx + 1 + leftSize,
            mid + 1, r
        );

        return root;
    }
}