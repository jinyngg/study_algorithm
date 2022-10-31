package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 로또의최고순위와최저순위 {

	public static void main(String[] args) {
		
		// result = [3, 5]
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		solution(lottos, win_nums);
	}
	
	/**
	 * @date 2022-10-31
	 * 
	 * 알아볼 수 없는 번호를 "0"
	 * 
	 * 순위	당첨 내용
	 * 1	6개 번호가 모두 일치
	 * 2	5개 번호가 일치
	 * 3	4개 번호가 일치
	 * 4	3개 번호가 일치
	 * 5	2개 번호가 일치
	 * 6(낙첨)	그 외
	 * 
	 * @param lottos 민우가 구매한 로또 번호를 담은 배열 
	 * @param win_nums 당첨 번호를 담은 배열
	 * 
	 * @return 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열
	 */
	public static int[] solution(int[] lottos, int[] win_nums) {
		
		int[] answer = new int[2];
		
		// 당첨 갯수 
		int high = 0;
		int low = 0;
		
		int matchCount = 0;
		int zeroCount = 0;
		
		// "당첨 갯수 - 순위"
		String[] ranking = {"6 1", "5 2", "4 3", "3 4", "2 5", "1 6", "0 6"};
		HashMap<Integer, Integer> rank = new HashMap<>();
		
		for(int i=0; i<ranking.length; i++) {
			String[] rk = ranking[i].split(" ");
			rank.put(Integer.parseInt(rk[0]), Integer.parseInt(rk[1]));
		}
		
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		
		ArrayList<Integer> winNumbers = new ArrayList<>();
		for(int winNumber : win_nums) {
			winNumbers.add(winNumber);
		}
		
		for(int lotto : lottos) {
			if(winNumbers.contains(lotto)) {
				matchCount++;
			}
			
			if(lotto == 0) {
				zeroCount++;
			}
		}
		
		high = matchCount + zeroCount;
		low = matchCount;
		
		answer[0] = rank.get(high);		
		answer[1] = rank.get(low);		
        
		System.out.println(Arrays.toString(answer));
        return answer;
    }
	
}
