package 프로그래머스_Level1;

import java.util.ArrayList;
import java.util.Stack;

public class 같은숫자는싫어 {
    public static ArrayList<Integer> solution(int []arr) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        for(int i=0; i<arr.length; i++) {
        	int val = arr[i];
        	if(stack1.isEmpty())
        		stack1.push(val);
        	else {
        		if(stack1.peek() == val) {
        			continue;
        		}
        		else
        			stack1.push(val);
        	}
        }

        while(!stack1.empty())
        	stack2.push(stack1.pop());
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack2.empty())
        	list.add(stack2.pop());
        return list;
    }
    
	public static void main(String[] args) {
//		int[] arr = {1,1,3,3,0,1,1};
		int[] arr = {4,4,4,3,3};
		solution(arr);
	}
}
