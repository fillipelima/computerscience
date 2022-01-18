package com.fillipelima.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Example Input: repository = [ "mobile", "mouse", "moneypot", "monitor", "mousepad" ] 
 *                customerQuery = "mouse"
 * 
 * Output: ["mobile", "moneypot", "monitor"] 
 *         ["mouse", "mousepad"] 
 *         ["mouse", "mousepad"] 
 *         ["mouse", "mousepad"]
 * 
 * @author Fillipe Lima
 *
 */

public class SearchResults {
	class Trie {
		class Node {
			Map<Character, Node> children = new TreeMap<Character, Node>();
			boolean isWord;
		}

		Node root = new Node();

		void insertWord(String word) {
			Node curr = root;
			for (Character c : word.toCharArray())
				curr = curr.children.computeIfAbsent(c, n -> new Node());
			curr.isWord = true;
		}

		Node findStartNode(String prefix) {
			Node curr = root;
			for (Character c : prefix.toCharArray()) {
				curr = curr.children.get(c);
			}
			return curr;
		}

		List<String> findAllPossibleWordsByPrefix(String prefix) {
			List<String> allWords = new ArrayList<String>();
			Node startNode = findStartNode(prefix);
			if (startNode.isWord)
				allWords.add(prefix);
			for (Map.Entry<Character, Node> child : startNode.children.entrySet())
				allWords.addAll(getAllWords(child, prefix));
			return allWords;
		}

		public List<String> getAllWords(Map.Entry<Character, Node> n, String s) {
			List<String> list = new ArrayList<String>();
			String s2 = s + String.valueOf(n.getKey()); 
			if (n.getValue().isWord)
				list.add(s2);
			for (Map.Entry<Character, Node> child : n.getValue().children.entrySet())
				list.addAll(getAllWords(child, s2));
			return list;
		}
		
		public void printAll() {
			List<String> words = new ArrayList<>();
			for (Map.Entry<Character, Node> e : root.children.entrySet())
				words.addAll(getAllWords(e, ""));
			words.stream().forEach(e -> System.out.println(e));			
		}

	}

	public void printAllWords(String[] repository) {
		// Build Trie
		Trie trie = new Trie();
		for (String s : repository) {
			trie.insertWord(s);
		}
		// Print All Words
		trie.printAll();

	}

	public String[][] search(String term, String[] repository) {
		// Build Trie
		Trie trie = new Trie();
		for (String s : repository) {
			trie.insertWord(s);
		}
		// Search
		List<List<String>> result = new ArrayList<List<String>>();
		for (int i = 2; i <= term.length(); i++) {
			String s = term.substring(0, i);
			Set<String> set = new TreeSet<String>();
			set.addAll(trie.findAllPossibleWordsByPrefix(s));
			result.add(set.stream().limit(3).collect(Collectors.toList()));
		}
		return result.stream().map(l -> l.toArray(String[]::new)).toArray(String[][]::new);
	}

	public static void main(String[] args) {
		SearchResults sr = new SearchResults();
		String[][] result = sr.search("mouse", new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" });
		for (String[] a : result) {
			for (String s : a)
				System.out.print(s + " ");
			System.out.println("");
		}
	}
}
