package programmers;

import java.util.PriorityQueue;

public class 더맵게 {

	public static void main(String[] args) {
		
		// result : 2
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		solution(scoville, K);

	}
	
	/**
	 * @date 2022-11-24
	 * 
	 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	 * 
	 * @param scoville Leo가 가진 음식의 스코빌 지수를 담은 배열
	 * @param K 스코빌 지수 기준점 
	 * @return K 이상으로 만들기 위해 섞어야 하는 최소 횟수
	 */
	public static int solution(int[] scoville, int K) {
		int first = 0;
		int second = 0;
		int mixed = 0;
		
		int answer = 0;
		
		if(K==0) {
			System.out.println("K=0");
			return 0;
		}
		
		PriorityQueue<Integer> mixedScoville = new PriorityQueue<>();
		for(int sc : scoville) {
			mixedScoville.add(sc);
		}
		
		for(int sc : scoville) {
			if(null == mixedScoville.peek()) {
				System.out.println("mixedScoville.peek() == null	return -1");
				return -1;
			}
			
			if(K<mixedScoville.peek()) {
				break;
			}
			
			if(K > mixedScoville.peek()) {
				first = mixedScoville.poll();
				
				if(null == mixedScoville.peek()) {
					System.out.println("mixedScoville.peek() == null	return -1");
					return -1;
				}
				second = mixedScoville.poll();
				
				mixed = first + (second * 2);
				mixedScoville.add(mixed);
				answer = answer + 1;
			}
		}
		System.out.println(answer);
        return answer;
    }

}
