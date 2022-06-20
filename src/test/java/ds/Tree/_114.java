package ds.Tree;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _114 {
    /** runtime: 1 ms 48.01%
     *  memory usage: 42.6 MB 21.80% */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }
}
