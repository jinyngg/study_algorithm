package programmers;

import java.util.Arrays;
import java.util.Stack;

public class 택배상자 {

	public static void main(String[] args) {
		
		// resut = 2
		int[] exam1 = {4, 3, 1, 2, 5};
		solution(exam1);
		
		// resut = 5
		int[] exam2 = {5, 4, 3, 2, 1};
//		solution(exam2);
		
		// resut = 5
		int[] exam3 = {1, 3, 2, 4, 5};
//		solution(exam3);
		
		// resut = 10
		int[] exam4 = {2, 1, 6, 7, 5, 8, 4, 9, 3, 10};
//		solution(exam4);
		
		// resut = 5
		int[] exam5 = {1, 2, 4, 3, 5};
//		solution(exam5);
	}
	
	/**
	 * @date 2022-11-08
	 * 
	 * @param order 택배 기사님이 원하는 상자 순서를 나타내는 정수 배열
	 * @return 영재가 몇 개의 상자를 실을 수 있는지
	 */
	public static int solution(int[] order) {
		
		int[] container = new int[order.length];
		Stack<Integer> subContainer = new Stack<>();
		int answer = 0;
		int location = 0;
		
		// 컨테이너 세팅
		for(int i=0; i<order.length; i++) {
			container[i] = i+1;
		}
		
		for(int i=0; i<order.length; i++) {
			// 컨테이너 맨 앞과 order 주문 내역이 같을 경우
			if(order[i] == container[i]) {
				answer = answer + 1;
				container[i] = -1;
				continue;
			} 
			
			// 서브컨테이너가 비었을 경우
			else if(subContainer.empty() == true) {
				for(int j=i+1; j<=order[i]; j++) {
					location = j;
					container[j-1] = -1;
					subContainer.add(j);
				}
				
				// 서브 컨테이너의 peek과 주문내역이 같을 경우
				if(order[i] == subContainer.peek()) {
					answer = answer + 1;
					subContainer.pop();
					continue;
				}
				
				else if(order[i] == container[location]) {
					answer ++;
					container[location] = -1;
					location = location + 1;
					continue;
				}
				
				break;
			}
			
			else if(subContainer.empty() == false) {
				
				if(order[i] == subContainer.peek()) {
					answer = answer + 1;
					subContainer.pop();
					continue;
				}
				
				else if(order[i] == container[location]) {
					answer ++;
					container[location] = -1;
					location = location + 1;
					continue;
				}
				
				break;
				
			}
			
		}
		
		System.out.println(location);
		System.out.println(Arrays.toString(container));
		System.out.println(answer);
		
        return answer;
    }

}
