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

 // 1,2,#,#,3,4,#,#,5,#,#,

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(root, res);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>();

        for (String node : nodes) {
            queue.offer(node);
        }

        return dfsBuild(queue);
    }

    private TreeNode dfsBuild(Queue<String> queue) {
        String cur = queue.poll();

        if (queue.isEmpty() || getValue(cur) == null) {
            return null;
        }

        TreeNode node = new TreeNode(getValue(cur));
        node.left = dfsBuild(queue);
        node.right = dfsBuild(queue);

        return node;
    }

    private void dfs(TreeNode root, StringBuilder string) {
        if (root == null) {
            string.append("#,");
            return;
        }

        string.append(root.val).append(",");
        dfs(root.left, string);
        dfs(root.right, string);
    }

    private Integer getValue(String node) {
        if (node.equals("#")) {
            return null;
        }

        return Integer.parseInt(node);
    }
}
