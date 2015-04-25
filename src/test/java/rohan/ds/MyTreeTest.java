package rohan.ds;

import org.junit.Test;

public class MyTreeTest {
    
    MyTree tree = new MyTree();
    
    @Test
    public void treeTest() {
        tree.setRoot(tree.insert(tree.getRoot(), 30));
        tree.setRoot(tree.insert(tree.getRoot(), 20));
        tree.setRoot(tree.insert(tree.getRoot(), 40));
        tree.setRoot(tree.insert(tree.getRoot(), 50));
        tree.inorder(tree.getRoot());
        
    }

}
