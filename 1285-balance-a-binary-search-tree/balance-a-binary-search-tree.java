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
    private void inorder(TreeNode root, List<Integer> values) {
        if (root == null) return;
        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }

    private TreeNode buildBalanced(List<Integer> values, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = buildBalanced(values, left, mid - 1);
        node.right = buildBalanced(values, mid + 1, right);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return buildBalanced(values, 0, values.size() - 1);
    }
}
