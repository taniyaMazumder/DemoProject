package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		int k = 3;
		System.out.println(modifyQueue(queue,k));
	}

	public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
		int len = q.size();
		Stack<Integer> stack = new Stack<>();
		
		// transfer the first k element from queue to stack
		for (int i = 0; i < k; i++) {
			stack.push(q.poll());
		}
		
		// taking answer queue to store the modified data from stack to new queue
		Queue<Integer> answer = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			answer.offer(stack.pop());
		}
		// now add the remaining elements into answer queue
		for(int j = 0; j< len -k;j++) {
			answer.offer(q.poll());
		}
		return answer;
	}
}
