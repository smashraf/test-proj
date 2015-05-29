package rohan.ds;

import org.junit.Assert;
import org.junit.Test;

public class TrieTest {

    public Trie trie = new Trie();

    @Test
    public void testTrie() {
        trie.insert(trie, new char[] { 'b', 'y' });
        Assert.assertTrue(trie.search(trie, new char[] { 'b', 'y' }));
        Assert.assertFalse(trie.search(trie, new char[] { 'b', 'y', 'e' }));
        trie.insert(trie, new char[] { 'b', 'y', 'e' });
        Assert.assertTrue(trie.search(trie, new char[] { 'b', 'y', 'e' }));
        Assert.assertFalse(trie.search(trie, new char[] { 'b', 'y', 't' }));
    }

}
