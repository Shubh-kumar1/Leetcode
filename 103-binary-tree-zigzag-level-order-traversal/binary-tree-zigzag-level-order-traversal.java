

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            LinkedList<Integer> currLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = q.poll();

                if (leftToRight) {
                    currLevel.addLast(currentNode.val);
                } else {
                    currLevel.addFirst(currentNode.val);
                }

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }

            leftToRight = !leftToRight;
            result.add(currLevel);
        }

        return result;
    }
}