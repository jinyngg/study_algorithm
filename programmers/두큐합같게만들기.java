package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

	public static void main(String[] args) {
		
		// result = 2
		int[] queue1 = {3, 2, 7, 2};
		int[] queue2 = {4, 6, 5, 1};
		
		// result = 9
		int[] a1 = {3, 3, 3, 3};
		int[] b1 = {3, 3, 21, 3};
		
		System.out.println(solution(queue1, queue2));
		System.out.println(solution(a1, b1));

	}
	
	/**
	 * @date 2022-11-07
	 * @TODO 그리디 알고리즘 공부 필요 
	 * 
	 * 1 ≤ queue1의 길이 = queue2의 길이 ≤ 300,000
	 * 1 ≤ queue1의 원소, queue2의 원소 ≤ 10^9
	 * 주의: 언어에 따라 합 계산 과정 중 산술 오버플로우 발생 가능성이 있으므로 long type 고려가 필요합니다.
	 * 
	 * @param queue1, queue2 길이가 같은 두 개의 큐를 나타내는 정수 배열
	 * @return 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수, 단 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1
	 */
	public static int solution(int[] queue1, int[] queue2) {
		

		long sum = 0;		
		long half = 0;		
		int maxNumberOfQueue1 = 0;		
		int maxNumberOfQueue2 = 0;		
		long sumOfQueue1 = 0;	
		long sumOfQueue2 = 0;	
		int answer = 0;		
		
		Queue<Integer> q1 = new LinkedList<>();	
		Queue<Integer> q2 = new LinkedList<>();	
		
		for(int queue : queue1) {
			q1.add(queue);
			if(maxNumberOfQueue1 < queue) {
				maxNumberOfQueue1 = queue;
			}
			sumOfQueue1 = sumOfQueue1 + queue;
			sum = sum + queue; 
		}
		
		for(int queue : queue2) {
			q2.add(queue);
			if(maxNumberOfQueue2 < queue) {
				maxNumberOfQueue2 = queue;
			}
			sumOfQueue2 = sumOfQueue2 + queue;
			sum = sum + queue; 
		}
		
		half = sum / 2;
		
		for(int i=0; i<3*queue1.length; i++) {
			if(sumOfQueue1 == sumOfQueue2) {
				return answer;
			}
			
			else if(sumOfQueue1 < sumOfQueue2) {
				q1.add(q2.peek());
				sumOfQueue2 = sumOfQueue2 - q2.peek();
				sumOfQueue1 = sumOfQueue1 + q2.poll();
				answer = answer + 1;
			}
			
			else if(sumOfQueue1 > sumOfQueue2) {
				q2.add(q1.peek());
				sumOfQueue1 = sumOfQueue1 - q1.peek();
				sumOfQueue2 = sumOfQueue2 + q1.poll();
				answer = answer + 1;
			}
		}
		
		if(sum%2 == 1 || half < maxNumberOfQueue1 || half < maxNumberOfQueue2) {
			return -1;
		}
		
        return -1;
    }

}
