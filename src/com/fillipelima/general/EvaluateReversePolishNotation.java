package com.fillipelima.general;

import java.util.HashSet;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<String> operands = new Stack<String>();
		HashSet<String> operators = new HashSet<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		for (int i = 0; i < tokens.length; i++) {
			if (operators.contains(tokens[i])) {
				int result = 0;
				if (!operands.isEmpty()) {
					result = compute(Integer.valueOf(operands.pop()), Integer.valueOf(operands.pop()), tokens[i]);
					operands.add(String.valueOf(result));
				}
			} else {
				operands.add(tokens[i]);
			}
		}
		if (operands.isEmpty())
			return 0;
		else
			return Integer.valueOf(operands.pop());
	}

	private int compute(Integer a, Integer b, String token) {
		if (token.equals("*")) {
			return b * a;
		}
		if (token.equals("/")) {
			if (a == 0)
				return 0;
			if (b == 0)
				return 0;
			return b / a;
		}
		if (token.equals("-")) {
			return b - a;
		}
		if (token.equals("+")) {
			return b + a;
		}
		return 0;
	}
}
