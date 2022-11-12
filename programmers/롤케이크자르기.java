package programmers;

import java.util.HashMap;
import java.util.HashSet;

public class 롤케이크자르기 {

	public static void main(String[] args) {
		
		// result = 2
		int[] ex1 = {1, 2, 1, 3, 1, 4, 1, 2};
		solution(ex1);
		
		// result = 0
		int[] ex2 = {1, 2, 3, 1, 4};
		
	}
	
	/**
	 * @date 2022-11-10
	 * 
	 * 1 ≤ topping의 길이 ≤ 1,000,000
	 * 1 ≤ topping의 원소 ≤ 10,000
	 * 
	 * @param topping 롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열
	 * @return 롤케이크를 공평하게 자르는 방법의 수
	 */
	public static int solution(int[] topping) {
		int answer = 0;
		
		// key : 토핑		value : 갯수
		HashMap<Integer, Integer> left = new HashMap<>();
		HashMap<Integer, Integer> right = new HashMap<>();
		
		for(int i=0; i<topping.length; i++) {
			right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
		}

		for(int i=0; i<topping.length; i++) {
			left.put(topping[i], left.getOrDefault(topping[i], 0) + 1);
			right.put(topping[i], right.getOrDefault(topping[i], 0) - 1);

			if(right.get(topping[i]) == 0) {
				right.remove(topping[i]);
			}

			answer = left.size() == right.size() ? answer + 1 : answer;
			if(left.size()>right.size()) {
				break;
			}
		}

		System.out.println("answer : " + answer);
        return answer;
    }

}
