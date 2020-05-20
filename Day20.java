/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ar = new ArrayList<>();
        traverse(root, k, ar);
        return ar.get(k - 1);
    }

    public static void traverse(TreeNode node, int k, ArrayList<Integer> ar) {
        if (node == null) {
            return;
        }
        traverse(node.left, k, ar);
        ar.add(node.val);
        traverse(node.right, k, ar);
    }
}