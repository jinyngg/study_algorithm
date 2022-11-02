package Programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class 다트게임 {

	public static void main(String[] args) {
		String exam1 = "1S2D*3T	"; 	// result = 37
		String exam2 = "1D2S#10S"; 	// result = 9
		String exam3 = "1T2D3D#";	// result = -4
		
		solution(exam3);
	}
	
	/**
	 * @date 2022-11-01
	 * 
	 * 점수는 0에서 10 사이의 정수이다.
	 * 보너스는 S, D, T 중 하나이다.
	 * 옵선은 *이나 # 중 하나이며, 없을 수도 있다.
	 * 
	 * 다트 게임은 총 3번의 기회로 구성된다.
	 * 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
	 * 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
	 * 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
	 * 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
	 * 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
	 * 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
	 * Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
	 * 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
	 * 
	 * @param dartResult 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열
	 * @return 총점수
	 */
	public static int solution(String dartResult) {
		int score = 0;	// 다트게임 점수 (0~10)
		int stage = 1;	// 다트게임 횟수 (1~3)
		int stageKey = stage;
		
		// 점수표
		ArrayList<String> scoreList = new ArrayList<>();
		
		// HashMap<stage, score> game 
		HashMap<Integer, Integer> game = new HashMap<>();
		
		for(int i=0; i<11; i++) {
			scoreList.add(String.valueOf(i));
		}
		
		for(int i=1; i<=dartResult.length(); i++) {
			String dart = dartResult.substring(i-1, i);
			
			if(scoreList.contains(dart)) {
				// 점수|보너스|[옵션] 이기 때문에 length 문제 없음
				score = "1".equals(dart) && "0".equals(dartResult.substring(i, i+1)) ? 10 : Integer.parseInt(dart);
				i = (score == 10) ? i + 1 : i;
				game.put(stage, score);
				
				stageKey = stage;
				score = 0;
				++stage;
			}
			
			else if("S".equals(dart)) {
				score = game.get(stageKey);
				game.put(stageKey, score);
				score = 0;
			}
			
			else if("D".equals(dart)) {
				score = game.get(stageKey) * game.get(stageKey);
				game.put(stageKey, score);
				score = 0;
			}
			
			else if("T".equals(dart)) {
				score = game.get(stageKey) * game.get(stageKey) * game.get(stageKey);
				game.put(stageKey, score);
				score = 0;
			}
			
			else if("*".equals(dart)) {
				if(stageKey == 1) {
					System.out.println("dart : " + dart + ", stageKey : " + stageKey);
					score = 2 * game.get(stageKey);
					game.put(stageKey, score);
					score = 0;
				} 
				
				else {
					score = 2 * game.get(stageKey-1);
					game.put(stageKey-1, score);
					score = 2 * game.get(stageKey);
					game.put(stageKey, score);
					score = 0;
				}
			}
			
			else if("#".equals(dart)) {
				score = -1 * game.get(stageKey);
				game.put(stageKey, score);
				score = 0;
			}
		}
		
        int answer = game.get(1) + game.get(2) + game.get(3);
        System.out.println(answer);
        return answer;
    }
	
}
