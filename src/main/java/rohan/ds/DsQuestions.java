package rohan.ds;

import java.util.ArrayDeque;
import java.util.Queue;

import rohan.ds.MyTree.TreeNode;

public class DsQuestions {

    public static int count = 0;

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

    public void getKthLargest(TreeNode root, int k) {
        if (root == null || count >= k)
            return;

        getKthLargest(root.right, k);
        count++;
        if (k == count) {
            System.out.println(root);
            return;
        }
        getKthLargest(root.left, k);
    }

    public boolean isBst(TreeNode root, int leftMax, int rightMin) {
        if (root == null)
            return true;

        if (root.x < leftMax || root.x > rightMin)
            return false;

        return isBst(root.left, leftMax, root.x - 1)
                && isBst(root.right, root.x + 1, rightMin);
    }

    public void printRightView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tn = queue.remove();
            if (queue.isEmpty())
                System.out.println(tn.x);
            if (tn.left != null)
                queue.add(tn.left);
            if (tn.right != null)
                queue.add(tn.right);
        }
    }

}
