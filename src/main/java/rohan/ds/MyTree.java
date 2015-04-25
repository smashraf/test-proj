package rohan.ds;

public class MyTree {

    public TreeNode root;

    public class TreeNode {
        public int x;
        public TreeNode left;
        public TreeNode right;

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

    @Override
    public String toString() {
        return "MyTree [root=" + root + "]";
    }
}
