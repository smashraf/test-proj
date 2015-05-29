package rohan.ds;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyTree {

    static TreeNode next = null;
    public TreeNode root;

    public class TreeNode {
        public int x;
        public TreeNode left;
        public TreeNode right;
        public int level;
        public TreeNode nextPointer;

        public TreeNode(int x) {
            this.x = x;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "node :" + x;
        }

    }

    public MyTree() {
        root = null;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.x + "\t");
            inorder(root.right);
        }
    }

    public TreeNode insert(TreeNode root, int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return root;
        } else if (root.x > data) {
            root.left = insert(root.left, data);
            return root;
        } else {
            root.right = insert(root.right, data);
            return root;
        }
    }

    public TreeNode connectNodes(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode prev = null;
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (prev.level == node.level) {
                prev.nextPointer = node;
            } else {
                prev.nextPointer = null;
            }
            prev = node;
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        return root;
    }

    // connect nodes at same level using constant extra space
    public TreeNode connect(TreeNode root) {
        if (root == null)
            return root;
        root.nextPointer = null;

        TreeNode next = root;
        while (next != null) {

            TreeNode temp = next;

            while (temp != null) {

                if (temp.left != null) {
                    if (temp.right != null) {
                        temp.left.nextPointer = temp.right;
                        temp.right.nextPointer = getNextPointer(temp);
                    } else {
                        temp.left.nextPointer = getNextPointer(temp);
                    }
                } else if (temp.left != null) {
                    temp.right.nextPointer = getNextPointer(temp);
                }

                temp = temp.nextPointer;

            }
            if (next.left != null) {
                next = next.left;
            } else if (next.right != null) {
                next = next.right;
            } else {
                next = getNextPointer(temp);
            }

        }
        return root;
    }

    public TreeNode getNextPointer(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode temp = node.nextPointer;
        if (temp != null) {
            if (node.nextPointer.left != null) {
                return node.nextPointer.left;
            } else if (node.nextPointer.right != null) {
                return node.nextPointer.right;
            }
            temp = temp.nextPointer;
        }
        return null;
    }

    public TreeNode sortedArrayToBST(int a[], int start, int end){
        if (start > end) return null;
        int mid = a.length/2;
       TreeNode node = new TreeNode(a[mid]);
       node.left = sortedArrayToBST(a, 0, mid-1 );
       node.right = sortedArrayToBST(a,mid+1, a.length);                       
       return node;        
    }
    
    public TreeNode populateInorder(TreeNode root){
        if (root == null) return null;
        populateInorder(root.right);
        root.nextPointer = next ;
        next = root;
        populateInorder(root.left);
        return root;
    }
        
    @Override
    public String toString() {
        return "MyTree [root=" + root + "]";
    }
}
