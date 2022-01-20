package com.fillipelima.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class SmallestDistinctWindow {
	public String findSubString(String str) {
		char[] arr = str.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (char c : arr) {
			set.add(c);
		}

		String min = null;
		List<Character> list = new ArrayList<Character>();
		int p1 = 0;
		int p2 = 0;
		while (p1 < arr.length && p2 < arr.length) {
			list.add(arr[p2]);
			if (list.containsAll(set)) {
				String s = list.stream().map(String::valueOf).collect(Collectors.joining());
				list.clear();
				p2 = p1++;
				if (min == null || s.length() < min.length()) {
					min = s;
				}
			} else {
				p2++;
			}
		}
		return min;
	}

	// Min Window
	public static String minWindow(String s, String t) {
		char[] arr = s.toCharArray();
		Queue<Character> dictionary = new PriorityQueue<Character>();
		for (char c : t.toCharArray())
			dictionary.add(c);

		String min = null;
		List<Character> currentWindow = new ArrayList<Character>();
		int p1 = 0;
		int p2 = 0;
		while (p1 < arr.length && p2 < arr.length) {
			currentWindow.add(arr[p2]);
			if (listContainsAll(currentWindow, dictionary)) {
				String str = currentWindow.stream().map(String::valueOf).collect(Collectors.joining());
				currentWindow.clear();
				p2 = ++p1;
				if (min == null || str.length() < min.length()) {
					min = str;
				}
			} else {
				p2++;
			}
		}
		return min == null ? "" : min;
	}

	private static boolean listContainsAll(List<Character> window, Queue<Character> dictionary) {
		Queue<Character> w = new PriorityQueue<Character>(window);
		Queue<Character> d = new PriorityQueue<Character>(dictionary);
		if (w.size() < d.size())
			return false;
		while (!w.isEmpty()) {
			if (w.peek().equals(d.peek()))
				d.poll();
			w.poll();
		}
		return d.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(SmallestDistinctWindow.minWindow(
				"cwirwjbfntstplnenpabdttnbiagcnrglbyhnbnavhvmtlqgaqkdmdtnltvpipwuquddvseqabctmsbmllsxrlmegjupyqlpmqsjlyalaegozjbkxtjogxsmgodhgqwsjqeureftknhlwixvdgjjfeyoudvburvdjzxafetqtbdplblrjwcpccdxgyyarvfaxcbciwubzysnzfekeizgledredrvzyyyazakxvlxvfkwlqgpyixjmbargtohrmftngfldskyywwlmccmkzwzayshugontwhicovfhffhbdsphucutatwalfutviorrxvhscoyhvbmntujvofxjbxwispdcexvdscvvtveozresnnpbsmmvjifdxlhdicgchexazcqavusikhlevxaffhkessicwqffuchugyudspncwahuxjzeslll",
				"ftpejujeztahrwljlao"));
	}
}
