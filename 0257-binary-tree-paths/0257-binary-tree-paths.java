import java.util.ArrayList;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        backtrack(root, new StringBuilder(), result);
        return result;
    }

    private void backtrack(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null) {
            return;
        }

        int lengthBefore = path.length(); // Store length for backtracking reset

        // Leaf node check
        if (node.left == null && node.right == null) {
            path.append(node.val);
            result.add(path.toString());
            path.setLength(lengthBefore); // Backtrack
            return;
        }

        // Internal node: append value + arrow and explore children
        path.append(node.val).append("->");
        
        if (node.left != null) {
            backtrack(node.left, path, result);
        }
        if (node.right != null) {
            backtrack(node.right, path, result);
        }

        path.setLength(lengthBefore); // Reset path length for parent call
    }
}