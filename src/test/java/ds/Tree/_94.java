package ds.Tree;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _94 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.add(root.val);

        TreeNode l = root.left, r = root.right;
        while (l != null || r != null) {
            if (l != null && r == null) {
                root = l;
                list.add(root.val);
                l = root.left;
                r = root.right;
            } else if (l == null && r != null) {
                root = r;
                list.add(root.val);
                l = root.left;
                r = root.right;
            } else {

            }
        }

        return list;
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 42.2 MB 47.55% */
    public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper1(root, res);
        return res;
    }
    private void helper1(TreeNode root, List<Integer> res){
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) res.add(root.val);
        if (root.left == null && root.right == null) return;
        if (root.left != null) helper(root.left,res);
        else if (root.right != null) helper(root.right,res);
    }

}
