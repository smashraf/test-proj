package rohan.ds;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DsQuestionsTest {

    DsQuestions dsQuestions = new DsQuestions();

    MyTree tree = new MyTree();

    @Before
    public void setup() {
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 35);
        tree.root = tree.insert(tree.root, 45);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, -1);
        tree.inorder(tree.root);
        System.out.println();
    }

    @After
    public void tearApart() {
        tree = null;
    }

    @Test
    public void getLcaTest() {
        System.out.println(dsQuestions.getLca(tree.root, tree.root.left, tree.root.right.right));
    }

    @Test
    public void getKthLargestTest() {
        dsQuestions.getKthLargest(tree.root, 2);
    }

    @Test
    public void isBstTest() {
        Assert.assertTrue(dsQuestions.isBst(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    
    @Test
    public void printRightViewTest() {
        dsQuestions.printRightView(tree.root);
    }

}
