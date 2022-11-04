package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 소수만들기 {

	public static void main(String[] args) {
		// result = 4
		int[] nums = {1,2,7,6,4};
		solution(nums);
	}
	
	/**
	 * @date 2022-11-03
	 * 
	 * nums에 들어있는 숫자의 개수는 3개 이상 50개 이하
	 * nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
	 * 
	 * @param nums 숫자들이 들어있는 배열
	 * @return 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수
	 */
	public static int solution(int[] nums) {
		
		int answer = 0;
		
		// 오름차순 정렬
		Arrays.sort(nums);
		int maxNumber = nums[nums.length-3] + nums[nums.length-2] + nums[nums.length-1];
		
		ArrayList<Integer> primeNumbers = getPrimeNuber(maxNumber);
		
		for(int i=0; i<nums.length; i++) {
			int number = 0;
			for(int j=i+1; j<nums.length; j++) {
				for(int k=j+1; k<nums.length; k++) {
					number = nums[i] + nums[j] + nums[k];
					
					answer = primeNumbers.contains(number) == true ? answer  + 1 : answer;
				}
			}
		}
		
		System.out.println(answer);
        return answer;
    }
    
    /**
     * 1부터 number까지의 소수들을 포함한 primNumbers를 return
     * 
     * @param number 
     * @return primeNumbers
     */
    public static ArrayList<Integer> getPrimeNuber(int number) {
    	ArrayList<Integer> primeNumbers = new ArrayList<>();
    	
    	// 소수 == true ? false : true
    	boolean[] prime = new boolean[number+1];
    	
        // 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true;
        
        for(int i=0; i*i<=number; i++) {
        	if(prime[i] == false){
            	for(int j=i*i; j<=number; j+=i) {
            		prime[j]=true;                
            	}
            }    
        }
        
        for(int i=1; i<=number;i++){
        	if(prime[i] == false) {
        		primeNumbers.add(i);     
        	}
        }
        
    	return primeNumbers;
    }
    
}
