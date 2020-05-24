public class Day24 {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return bstHelper(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    TreeNode bstHelper(int[] preorder, int max, int min) {
        if (index > preorder.length) {
            return null;
        }
        int key = preorder[index];
        TreeNode node = null;
        if (key > min && key < max) {
            node = new TreeNode(key);
            node.left = bstHelper(preorder, key, min);
            node.right = bstHelper(preorder, max, key);
        }
        return node;
    }
}