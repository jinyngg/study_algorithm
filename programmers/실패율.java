package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 실패율 {

	public static void main(String[] args) {
		
		// result = {3, 4, 2, 1, 5}
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		int M = 4;
		int[] stages2 = {4, 4, 4, 4 ,4};
		
		int K = 4;
		int[] stages3 = {1, 1, 1, 1 ,1};
		
		solution(N, stages);
		solution(M, stages2);
		solution(K, stages3);
	}
	
	/**
	 * @date 2022-11-03
	 * 
	 * 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
	 * 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
	 * stages의 길이는 1 이상 200,000 이하이다.
	 * stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
	 * N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
	 * 
	 * @param N 전체 스테이지의 개수
	 * @param stages 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
	 * @return 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열
	 */
	public static int[] solution(int N, int[] stages) {
		
		int[] answer = new int[N];
        
		double[] rate = new double[N];	// 실패율 배열
		double users = stages.length;	// 유저의 수
		
		for (int i=1; i<=N; i++) {
			if(users == 0) {
				rate[i-1] = 0;
				break;
			}
			
			double failedUsers = 0;
			
			for(int j=0; j<stages.length; j++) {
				if(i == stages[j]) {
					failedUsers = failedUsers + 1;	// Stage가 증가함에 따라 실패한 유저수 변경
				}
			}
			
			rate[i-1] = failedUsers / users ;		// 실패율 
			users = users - failedUsers;			// 다음 Stage에 남은 유저수 변경
			
		}
		
		System.out.println(Arrays.toString(rate));
		
		// index : (stage-1), value : rate
		ArrayList<Double> failure = new ArrayList<>();	
		for(int i=0; i<N; i++) {
			failure.add(rate[i]);
		}
		
		// 실패율 내림차순 정렬
		Collections.sort(failure, Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(failure.get(i) == rate[j]) {
					answer[i] = j+1;
					rate[j] = -1;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
		
        return answer;
    }
	
}
