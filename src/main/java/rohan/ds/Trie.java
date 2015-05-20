package rohan.ds;

public class Trie {

    public TrieNode root;

    public int count;

    public class TrieNode {

        public int value;

        public TrieNode[] children;
    }

    public TrieNode getTrieNode() {
        TrieNode trieNode = new TrieNode();
        trieNode.value = 0;
        trieNode.children = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            trieNode.children[i] = null;
        }
        return trieNode;
    }

    public Trie() {
        root = getTrieNode();
        count = 0;
    }

    public void insert(Trie trie, char[] key) {
        TrieNode temp = trie.root;
        trie.count++;
        for (int i = 0; i < key.length; i++) {
            int index = charToIndex(key[i]);
            if (temp.children[index] == null) {
                temp.children[index] = getTrieNode();
            }
            temp = temp.children[index];
        }
        temp.value = trie.count;
    }

    private int charToIndex(char c) {
        return (int) c - (int) 'a';
    }

    public boolean search(Trie trie, char[] key) {
        TrieNode temp = trie.root;
        for (int i = 0; i < key.length; i++) {
            int index = charToIndex(key[i]);
            if (temp.children[index] == null)
                return false;
            temp = temp.children[index];
        }
        return temp.value != 0;
    }
}
