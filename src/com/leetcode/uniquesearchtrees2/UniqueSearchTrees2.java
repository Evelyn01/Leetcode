package com.leetcode.uniquesearchtrees2;

import com.leetcode.common.TreeNode;
import com.leetcode.common.TreeNodePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/12/14.
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueSearchTrees2 {

    public static void main(String[] strings) {
        UniqueSearchTrees2 uniqueSearchTrees2 = new UniqueSearchTrees2();

        List<TreeNode> list = uniqueSearchTrees2.generateTrees(3);

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
