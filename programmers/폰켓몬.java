package programmers;

import java.util.Arrays;

public class 폰켓몬 {

	public static void main(String[] args) {
		
		int[] nums = {3,3,3,2,2,4};
		System.out.println(solution(nums));

	}
	
	/**
	 * 
	 * @param nums N마리 폰켓몬의 종류 번호가 담긴 배열
	 * @return N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수
	 */
	public static int solution(int[] nums) {
		
        int answer = 1;
        int length = nums.length;
        
        Arrays.sort(nums);
        int number = nums[0];
        
        for(int i=1; i<length; i++) {
        	if(number == nums[i]) {
        		continue;
        	}
        	answer = answer + 1;
        	number = nums[i];
        }
        
        return length/2 <= answer ? length/2 : answer;
    }

}
