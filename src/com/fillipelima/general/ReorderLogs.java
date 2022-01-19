package com.fillipelima.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * You are given an array of logs. Each log is a space-delimited string of
 * words, where the first word is the identifier.
 * 
 * There are two types of logs:
 * 
 * Letter-logs: All words (except the identifier) consist of lowercase English
 * letters. Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 * 
 * The letter-logs come before all digit-logs. The letter-logs are sorted
 * lexicographically by their contents. If their contents are the same, then
 * sort them lexicographically by their identifiers. The digit-logs maintain
 * their relative ordering. Return the final order of the logs.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"] 
 * 
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"] 
 * 
 * Explanation: The letter-log contents are all different, so their ordering is
 * "art can", "art zero", "own kit dig". The digit-logs have a relative order of 
 * "dig1 8 1 5 1", "dig2 3 6".
 * 
 * @author Fillipe Lima
 *
 */

public class ReorderLogs {
	public String[] reorderLogFiles(String[] logs) {

		// Comparator
		Comparator<String> comparator = (String a, String b) -> {
			String[] aSplit = a.split("\\s+");
			String[] bSplit = b.split("\\s+");
			boolean aIsDigitLog = isNumeric(aSplit[1]);
			boolean bIsDigitLog = isNumeric(bSplit[1]);
			// Different types (letter & digit)
			if (aIsDigitLog != bIsDigitLog) {
				if (aIsDigitLog)
					return 1;
				else
					return -1;
			} else if (!aIsDigitLog) { // Same type (letter)
				// Compare by contents
				List<String> aContents = Arrays.asList(aSplit).stream().skip(1).collect(Collectors.toList());
				List<String> bContents = Arrays.asList(bSplit).stream().skip(1).collect(Collectors.toList());
				int i = 0;
				int aSize = aContents.size();
				int bSize = bContents.size();
				while (i < aSize && i < bSize) {
					if (!aContents.get(i).equals(bContents.get(i))) {
						// If found different word, compare and return
						return aContents.get(i).compareTo(bContents.get(i));
					}
					i++;
				}
				// Logs are not equals, so compare
				if (aSize - i > 0)
					return 1;
				else if (bSize - i > 0)
					return -1;
				// Contents are same, so compare by identifiers
				String aId = aSplit[0];
				String bId = bSplit[0];
				return aId.compareTo(bId);
			}
			return 0;
		};

		// Sort log contents
		return Arrays.stream(logs).sorted(comparator).toArray(String[]::new);
	}

	private boolean isNumeric(String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}
}
