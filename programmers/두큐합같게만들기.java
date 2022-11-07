package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

	public static void main(String[] args) {
		int[] queue1 = {3, 2, 7, 2};
		int[] queue2 = {4, 6, 5, 1};
		
		// A = [3, 3, 3, 3], B = [3, 3, 21, 3] 일 경우, 9번이 걸림 횟수를 다시 생각해 볼 것 
		
		// 1번 28번 반례
//		int[] arr1 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 10 };
//		int[] arr2 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		// A = [3, 3, 3, 3], B = [3, 3, 21, 3] 일 경우, 9번이 걸림 횟수를 다시 생각해 볼 것 
//		int[] a1 = {3, 3, 3, 3};
//		int[] b1 = {3, 3, 21, 3};
		
		solution(queue1, queue2);

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
		
		long sum = 0;		// 모든 요소의 합
		long half = 0;		// 모든 요소의 합 / 2
		int max1 = 0;		// queue1의 값 중 가장 큰 값
		int max2 = 0;		// queue2의 값 중 가장 큰 값
		long sumQueue1 = 0;	// queue1의 요소의 합
		long sumQueue2 = 0;	// queue2의 요소의 합
		int answer = 0;		// return
		
		Queue<Integer> q1 = new LinkedList<>();	// Queue1
		Queue<Integer> q2 = new LinkedList<>();	// Queue2
		
		for(int queue : queue1) {
			q1.add(queue);
			if(max1 < queue) {
				max1 = queue;
			}
			sumQueue1 = sumQueue1 + queue;
			sum = sum + queue; 
		}
		
		for(int queue : queue2) {
			q2.add(queue);
			if(max2 < queue) {
				max2 = queue;
			}
			sumQueue2 = sumQueue2 + queue;
			sum = sum + queue; 
		}
		
		half = sum / 2;
		
		// 범위에 대해서는 다시 알아봐야함 
		for(int i=0; i<3*queue1.length; i++) {
			if(sumQueue1 == sumQueue2) {
				break;
			}
			
			else if(sumQueue1 < sumQueue2) {
				q1.add(q2.peek());
				sumQueue2 = sumQueue2 - q2.peek();
				sumQueue1 = sumQueue1 + q2.poll();
				answer = answer + 1;
			}
			
			else if(sumQueue1 > sumQueue2) {
				q2.add(q2.peek());
				sumQueue1 = sumQueue1 - q1.peek();
				sumQueue2 = sumQueue2 + q1.poll();
				answer = answer + 1;
			}
		}
		
		// SUM이 홀수일 경우, 가장 큰 요소의 값이 SUM/2보다 클 경우 return -1
		if(sum%2 == 1 || half < max1 || half < max2) {
			System.out.println("return -1");
			return -1;
		}
		
        return answer;
    }

}
