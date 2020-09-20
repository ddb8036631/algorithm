package 백준_Class2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String s = sc.nextLine();
			if (s.equals("."))
				break;

			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);

				if(stack.empty() && (ch == ')' || ch == ']')) {
					flag = false;
					break;
				}
				
				if (ch == '(' || ch == '[') {
					stack.push(ch);
				}

				else if(ch == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else
						break;
				}
				
				else if(ch == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else
						break;
				}
			}

			if (flag && stack.isEmpty())
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
