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
		solution(exam2);
		
		// resut = 5
		int[] exam3 = {1, 3, 2, 4, 5};
		solution(exam3);
		
		// resut = 10
		int[] exam4 = {2, 1, 6, 7, 5, 8, 4, 9, 3, 10};
		solution(exam4);
		
		// resut = 5
		int[] exam5 = {1, 2, 4, 3, 5};
		solution(exam5);
	}
	
	/**
	 * @date 2022-11-09
	 * 
	 * @param order 택배 기사님이 원하는 상자 순서를 나타내는 정수 배열
	 * @return 영재가 몇 개의 상자를 실을 수 있는지
	 */
	public static int solution(int[] order) {
		
		Stack<Integer> subContainer = new Stack<>();
		int out = 1;
		
		int answer = 0;
		
		/**
		 * 1. subContainer 확인
		 * 2. subContainer 추가가 필요한지 확인
		 * 3. container 가져오기(out++)
		 * 4. 불가능할 경우 종료
		 */
		for(int i=0; i<order.length; i++) {
			if(subContainer.empty()==false && subContainer.peek()==order[i]) {
				subContainer.pop();
				answer = answer + 1;
				continue;
			}
			
			while(order[i]>out) {
				subContainer.push(out);
				out = out + 1;
			}
			
			if(order[i]==out) {
				answer = answer + 1;
				out = out + 1;
				continue;
			}
			
			if(order[i]<out) {
				break;
			}
			
		}
		System.out.println(answer);
		return answer;
	}

//	public static int solution(int[] order) {
//		
//		int[] container = new int[order.length];
//		Stack<Integer> subContainer = new Stack<>();
//		int answer = 0;
//		int location = 0;
//		
//		// 컨테이너 세팅
//		for(int i=0; i<order.length; i++) {
//			container[i] = i+1;
//		}
//		
//		for(int i=0; i<order.length; i++) {
//			// 컨테이너 맨 앞과 order 주문 내역이 같을 경우
//			if(order[i] == container[i]) {
//				answer = answer + 1;
//				container[i] = -1;
//				continue;
//			} 
//			
//			// 서브컨테이너가 비었을 경우
//			else if(subContainer.empty() == true) {
//				for(int j=i+1; j<=order[i]; j++) {
//					location = j;
//					container[j-1] = -1;
//					subContainer.add(j);
//				}
//				
//				// 서브 컨테이너의 peek과 주문내역이 같을 경우
//				if(order[i] == subContainer.peek()) {
//					answer = answer + 1;
//					subContainer.pop();
//					continue;
//				}
//				
//				else if(order[i] == container[location]) {
//					answer ++;
//					container[location] = -1;
//					location = location + 1;
//					continue;
//				}
//				
//				break;
//			}
//			
//			else if(subContainer.empty() == false) {
//				
//				if(order[i] == subContainer.peek()) {
//					answer = answer + 1;
//					subContainer.pop();
//					continue;
//				}
//				
//				else if(order[i] == container[location]) {
//					answer ++;
//					container[location] = -1;
//					location = location + 1;
//					continue;
//				}
//				
//				break;
//				
//			}
//			
//		}
//		
//		System.out.println(location);
//		System.out.println(Arrays.toString(container));
//		System.out.println(answer);
//		
//        return answer;
//    }
}
