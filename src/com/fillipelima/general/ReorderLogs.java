package com.fillipelima.general;

import java.util.Arrays;
import java.util.Comparator;

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
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
 * dig","let3 art zero"]
 * 
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5
 * 1","dig2 3 6"]
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
			// Split into two (id, content)
			String[] aSplit = a.split("\\s+", 2);
			String[] bSplit = b.split("\\s+", 2);

			// Find type of log (Letter or Digit)
			boolean aIsDigitLog = Character.isDigit(aSplit[1].charAt(0));
			boolean bIsDigitLog = Character.isDigit(bSplit[1].charAt(0));

			// Different types (letter & digit)
			if (aIsDigitLog != bIsDigitLog) {
				return aIsDigitLog ? 1 : -1;
			} else if (!aIsDigitLog) { // Same type (letter)
				// Compare by contents
				int compareByContent = aSplit[1].compareTo(bSplit[1]);
				// If contents are not equal return result of comparision
				if (compareByContent != 0)
					return compareByContent;
				// Contents are equals, so compare by identifiers
				return aSplit[0].compareTo(bSplit[0]);
			}
			return 0;
		};

		// Sort log contents
		return Arrays.stream(logs).sorted(comparator).toArray(String[]::new);
	}
}
