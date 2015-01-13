package com.leetcode.uniquebst2;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/12/14.
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBST2 {

    public static void main(String[] strings) {
        UniqueBST2 uniqueBST2 = new UniqueBST2();

        List<TreeNode> list = uniqueBST2.generateTrees(3);

        for (TreeNode root : list) {
            TreeNodePrinter.printNode(root);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        result[0].add(null);

        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null)
            return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}
