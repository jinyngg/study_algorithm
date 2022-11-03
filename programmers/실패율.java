package programmers;

import java.util.Arrays;

public class 실패율 {

	public static void main(String[] args) {
		
		// result = {3, 4, 2, 1, 5}
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		int M = 4;
		int[] stages2 = {4, 4, 4, 4 ,4};
		
		solution(N, stages);
		solution(M, stages2);
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
        
		double[] rate = new double[N];
		double users = stages.length;
		
		for (int i=1; i<=N; i++) {
			double failedUsers = 0;
			
			for(int j=0; j<stages.length; j++) {
				if(i == stages[j]) {
					failedUsers = failedUsers + 1;
				}
			}
			
			rate[i-1] = failedUsers / users ;
			users = users - failedUsers;
		}
		
		System.out.println(Arrays.toString(rate));
		
		for(int i=0; i<N; i++) {
			int maxStage = i+1;
			double max = rate[i];
			
			for(int j=0; j<N; j++) {
				if(max < rate[j]) {
					max = rate[j];
					maxStage = j+1;
				}
			}
			
			answer[i] = maxStage;
			rate[maxStage-1] = -1.0;
		}
		
		System.out.println(Arrays.toString(answer));
        return answer;
    }

}
