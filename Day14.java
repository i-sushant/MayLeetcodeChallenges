class Trie {
    Trie children[];
    int size;
    boolean isTerminal;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        size = 0;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word, 0);
    }

    public void insert(String word, int i) {
        size++;
        if (i == word.length()) {
            this.isTerminal = true;
            return;
        }
        Trie child = getTrieAt(word.charAt(i));
        if (child == null) {
            child = new Trie();
            setTrie(word.charAt(i), child);
        }
        child.insert(word, i + 1);

    }

    public void setTrie(char c, Trie child) {
        children[getCharIndex(c)] = child;
    }

    public static int getCharIndex(char c) {
        return c - 'a';
    }

    public Trie getTrieAt(char c) {
        return children[getCharIndex(c)];
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, 0);
    }

    public boolean search(String word, int i) {
        if (i == word.length() && this.isTerminal) {
            return true;
        }
        if (i >= word.length()) {
            return false;
        }
        Trie child = getTrieAt(word.charAt(i));
        if (child == null) {
            return false;
        }
        return child.search(word, i + 1);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (startsWith(prefix, 0) > 0) {
            return true;
        }
        return false;
    }

    public int startsWith(String word, int i) {
        if (i == word.length()) {
            return size;
        }
        Trie child = getTrieAt(word.charAt(i));
        if (child == null) {
            return 0;
        }
        return child.startsWith(word, i + 1);
    }
}
/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */