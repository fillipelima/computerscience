package com.fillipelima.trie;

class Trie {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.contains(currentChar)) {
                node.add(currentChar);
            }
            node = node.get(currentChar);
        }
        node.setWord();
    }        
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = commonSearch(word);
        return node != null && node.isWord();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = commonSearch(prefix);
        return node != null;
    }
    
    private TrieNode commonSearch(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.contains(currentChar)) {
                node = node.get(currentChar);
            }else{
                return null;
            }
        }        
        return node;
    }
    
    class TrieNode {
        private char value;
        private boolean isWord;
        private TrieNode[] children = new TrieNode[26];   
        
        public boolean contains(char c) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null && children[i].getValue() == c) {
                    return true;
                }
            }
            return false;
        }
        
        public void add(char c) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] == null) {
                    children[i] = new TrieNode();
                    children[i].setValue(c);
                }
            }   
        }
        
        public TrieNode get(char c) {
            for (int i = 0; i < children.length; i++) {
                if (children[i].getValue() == c) {
                    return children[i];
                }
            }  
            return null;
        }   
        
        public void setValue(char c) {
            value = c;
        }
        
        public char getValue() {
            return value;
        }
        
        public void setWord() {
            isWord = true;
        }
        
        public boolean isWord() {
            return isWord;
        }
        
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
