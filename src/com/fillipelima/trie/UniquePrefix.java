package com.fillipelima.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://practice.geeksforgeeks.org/problems/shortest-unique-prefix-for-every-word/1/
 * 
 * Shortest Unique prefix for every word
 * 
 * Given an array of words, find all shortest unique prefixes to represent each
 * word in the given array. Assume that no word is prefix of another.
 * 
 * Example 1:
 * 
 * Input: N = 4 arr[] = {"zebra", "dog", "duck", "dove"} Output: z dog du dov
 * Explanation: z => zebra dog => dog duck => du dove => dov
 * 
 * 
 * @author Fillipe Lima
 *
 */
public class UniquePrefix {

	class Trie {
		class TrieNode {
			Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
			boolean isWord;
		}

		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode curr = root;
			for (Character c : word.toCharArray())
				curr = curr.children.computeIfAbsent(c, n -> new TrieNode());
			curr.isWord = true;
		}

		public String getShortestUniquePrefix(String word) {
			TrieNode curr = root;
			int count = 1;
			int lastStop = 1;
			for (Character c : word.toCharArray()) {
				count++;
				if (curr.children.get(c).children.size() > 1)
					lastStop = count;
				curr = curr.children.get(c);
			}
			return word.substring(0, Math.min(count, lastStop));
		}

	}

	class Solution {
		public String[] findPrefixes(String[] arr, int N) {
			Trie trie = new Trie();

			for (String s : arr) {
				trie.insert(s);
			}

			String[] result = new String[arr.length];

			int i = 0;
			for (String s : arr) {
				result[i] = trie.getShortestUniquePrefix(s);
				i++;
			}

			return result;
		}
	};

}
