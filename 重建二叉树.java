/*
题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/
/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int sPre, int ePre, int[] in, int sIn, int eIn) {
        if (sPre > ePre || sIn > eIn)
            return null;
        // 此部分的根节点
        TreeNode root = new TreeNode(pre[sPre]);
        for (int i = sIn; i <= eIn; i++) {
            // 根据中序遍历获取左右子树
            if (in[i] == pre[sPre]) {
                // i-sIn为左右子树的节点个数
                root.left = reConstructBinaryTree(pre, sPre + 1, sPre + i - sIn, in, sIn, i - 1);
                root.right = reConstructBinaryTree(pre, sPre + i - sIn + 1, ePre, in, i + 1, eIn);
            }
        }
        return root;
    }
}