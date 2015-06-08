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

        return isBst(root.left, leftMax, root.x - 1) && isBst(root.right, root.x + 1, rightMin);
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

    public void printKDist(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null)
            return;
        printChildNodes(target, k);
        printKDistUtil(root, target, k);
    }

    public void printKDistUtil(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return;
        int d1 = search(root.left, target, 0);
        int d2 = search(root.right, target, 0);
        int d3 = search(root, target, 0);
        if (d1 != -1)
            printChildNodes(root.right, k - d1 - 2);
        if (d2 != -1)
            printChildNodes(root.left, k - d2 - 2);
        if (d3 == k)
            System.out.println(root.x);
        printKDistUtil(root.left, target, k);
        printKDistUtil(root.right, target, k);
    }

    public int search(TreeNode root, TreeNode target, int d) {
        if (root == target)
            return d;
        if (root == null)
            return -1;
        return max(search(root.left, target, d + 1), search(root.right, target, d + 1));
    }

    public void printChildNodes(TreeNode root, int k) {
        if (root == null || k < 0)
            return;
        else if (k == 0) {
            System.out.println(root.x);
            return;
        } else {
            printChildNodes(root.left, k - 1);
            printChildNodes(root.right, k - 1);
        }
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public int[] getDiagonalSum(TreeNode root, int k, int[] sum) {
        if (root == null)
            return sum;
        sum[k] += root.x;
        sum = getDiagonalSum(root.right, k, sum);
        sum = getDiagonalSum(root.left, k + 1, sum);
        return sum;
    }

}
