package lab10;

import java.beans.Expression;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		// TODO
		Stack<E> stack = new Stack<E>();
		for (int i = 0; i < array.length; i++) {
			stack.push(array[i]);
		}
		int n = 0;
		while (!stack.isEmpty()) {
			array[n] = stack.pop();
			n++;
		}
	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==>false
	public static boolean isCorrect(String input) {
		char[] c = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < c.length; i++) {
			stack.push(c[i]);
		}
		for (int i = 0; i < c.length; i++) {
			char a = ' ';
			switch (stack.peek()) {
			case ')':
				a = '(';
				break;
			case '}':
				a = '{';
				break;

			case ']':
				a = '[';
				break;
			default:
				break;
			}
			for (int j = 0; j < c.length; j++) {
				if (a == c[j]) {
					stack.pop();
					c[j] = ' ';
					break;
				}
			}
		}
		return stack.isEmpty();
	}

	// This method evaluates the value of an expression
	// i.e. 51+(54*(3+2)) = 321
	public static double evaluateExpression(String expression) {
		expression = insertBlank(expression);
		StringBuilder stringBuilder = new StringBuilder(expression);
		String assign = "";
		Stack<String> operandStack = new Stack<String>();
		Stack<String> operatorStack = new Stack<String>();
		if (!expression.contains(String.valueOf('('))) {
			if (expression.contains("*")) {
				for (int i = expression.indexOf("*") + 2; i < expression.length(); i++) {
					if (expression.charAt(i) == ' ') {
						stringBuilder.insert(i, " )");
						break;
					}
				}
				for (int i = expression.indexOf("*") - 2; i > 0; i--) {
					if (expression.charAt(i) == ' ') {
						stringBuilder.insert(i, " (");
						break;
					}
				}
			}
			if (expression.contains("/")) {
				for (int i = expression.indexOf("/") + 2; i < expression.length(); i++) {
					if (expression.charAt(i) == ' ') {
						stringBuilder.insert(i, " )");
						break;
					}
				}
				for (int i = expression.indexOf("/") - 2; i > 0; i--) {
					if (expression.charAt(i) == ' ') {
						stringBuilder.insert(i, " (");
						break;
					}
				}
			}
			stringBuilder.append(" ");
			expression = stringBuilder.toString();
		}

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
					|| expression.charAt(i) == '/' || expression.charAt(i) == '(') {
				operatorStack.push(String.valueOf(expression.charAt(i)));
			} else {
				if (expression.charAt(i) != ' ' && expression.charAt(i) != ')') {
					assign += String.valueOf(expression.charAt(i));
				} else {
					if (expression.charAt(i) == ' ') {
						if (!assign.isBlank()) {
							operandStack.push(assign.trim());
							assign = "";
						}
					}
					if (expression.charAt(i) == ')') {
						double a = Double.parseDouble(operandStack.pop());
						double b = Double.parseDouble(operandStack.pop());
						switch (operatorStack.pop()) {
						case "*":
							operandStack.push(String.valueOf(b * a));
							break;
						case "/":
							operandStack.push(String.valueOf(b / a));
							break;
						case "+":
							operandStack.push(String.valueOf(b + a));
							break;
						case "-":
							operandStack.push(String.valueOf(b - a));
							break;
						default:
							break;
						}
						operatorStack.pop();
					}
				}
			}
		}
		while (!operatorStack.isEmpty()) {
			double b = Double.parseDouble(operandStack.pop());
			double a = Double.parseDouble(operandStack.pop());

			switch (operatorStack.pop()) {
			case "*":
				operandStack.push(String.valueOf(a * b));
				break;
			case "/":
				operandStack.push(String.valueOf(a / b));
				break;
			case "+":
				operandStack.push(String.valueOf(a + b));
				break;
			case "-":
				operandStack.push(String.valueOf(a - b));
				break;
			default:
				break;
			}
		}
		return Double.parseDouble(operandStack.pop());

	}

	public static String insertBlank(String str) {
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/'
					|| str.charAt(i) == '(' || str.charAt(i) == ')') {
				if (s.charAt(s.length() - 1) == ' ') {
					s += str.charAt(i) + " ";
				} else {
					s += " " + str.charAt(i) + " ";
				}
			} else {
				s += str.charAt(i);
			}

		}
		return s;
	}

	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		Stack<E> stack = new Stack<E>();
		while (!input.isEmpty()) {
			stack.push(input.peek());
			stack.push(input.poll());
		}
		E[] array = (E[]) new Object[stack.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
		reserve(array);
		for (int i = 0; i < array.length; i++) {
			input.offer(array[i]);
		}
		// TODO
	}

	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		// TODO
		E[] array = (E[]) new Object[input.size() * 2];
		for (int i = 0; i < array.length / 2; i++) {
			array[i] = input.peek();
			array[array.length - i - 1] = input.poll();
		}
		for (int i = 0; i < array.length; i++) {
			input.offer(array[i]);
		}
	}

	public static void main(String[] args) {
		String[] a = { "a", "b", "c", "d" };
		reserve(a);
		System.out.println(Arrays.toString(a));
		Queue<String> input = new ConcurrentLinkedQueue<String>();
		input.offer("a");
		input.offer("b");
		input.offer("c");
		input.offer("d");
		stutter(input);
		System.out.println(input);
		Queue<String> input1 = new ConcurrentLinkedQueue<String>();
		input1.offer("a");
		input1.offer("b");
		input1.offer("c");
		input1.offer("d");
		mirror(input1);
		System.out.println(input1);
		String str = "(){[]}()";
		System.out.println(isCorrect(str));
		String string = "51+(54*(3+2))";
		String string1 = "51+54/3+2";
		System.out.println(evaluateExpression(string1));
	}
}
