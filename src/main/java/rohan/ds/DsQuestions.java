package rohan.ds;

import rohan.ds.MyTree.TreeNode;

public class DsQuestions {

    // public static int count = 0;

    public TreeNode getLca(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null || n1 == null || n2 == null)
            return null;
        if (root == n1 || root == n2)
            return root;
        TreeNode leftSide, rightSide;
        leftSide = getLca(root.left, n1, n2);
        rightSide = getLca(root.right, n1, n2);
        if (leftSide != null && rightSide != null)
            return root;
        else if (leftSide != null)
            return leftSide;
        else
            return rightSide;
    }

    public void getKthLargest(TreeNode root, int k, Integer count) {
        if (root == null || count >= k)
            return;

        getKthLargest(root.right, k, count);
        count++;
        if (k == count) {
            System.out.println(root);
            return;
        }

        getKthLargest(root.left, k, count);

    }

}
