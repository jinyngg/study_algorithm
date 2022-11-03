package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class 소수만들기 {

	public static void main(String[] args) {
		// result = 4
		int[] nums = {1,2,7,6,4};
		solution(nums);
	}
	
	/**
	 * @date 2022-11-03
	 * 
	 * TODO 수정 필요
	 * 
	 * nums에 들어있는 숫자의 개수는 3개 이상 50개 이하
	 * nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
	 * 
	 * @param nums 숫자들이 들어있는 배열
	 * @return 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수
	 */
	public static int solution(int[] nums) {
		
		int answer = 0;
        int countOfNumbers = nums.length;
		boolean[] visited = new boolean[countOfNumbers];
		
		HashSet<Integer> sumOfNumbers = new HashSet<>();
		sumOfNumbers = makeSumOfNumbers(nums, visited, 0, countOfNumbers, 3, sumOfNumbers);
		
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		
		Iterator iter = sumOfNumbers.iterator(); 
		while(iter.hasNext()){
			numbers.add((Integer) iter.next());
		}
		
		Collections.sort(numbers);
		
		primeNumbers = getPrimeNuber(numbers.get(numbers.size()-1));
		
		for(int i=0; i<numbers.size(); i++) {
			answer = primeNumbers.contains(numbers.get(i)) == true ? answer + 1 : answer;
		}
		
		System.out.println(answer);
        return answer;
    }
	
	/**
	 * 조합(https://bcp0109.tistory.com/15)
	 * 
	 * @param numbers 숫자들이 들어있는 배열
	 * @param visited 방문체크
	 * @param start nums[start] 부터 반복
	 * @param n n개 중 r개 선택
	 * @param r n개 중 r개 선택
	 * 
	 * @return n개 중 r개의 숫자들의 합이 담긴 Set
	 */
    public static HashSet<Integer> makeSumOfNumbers(int[] numbers, boolean[] visited, int start, int n, int r, HashSet<Integer> sumOfNumbers) {    	
        if (r == 0) {
        	int sumOfNumber = getSumOfNumbers(numbers, visited, n);
        	sumOfNumbers.add(sumOfNumber);
            return sumOfNumbers;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            makeSumOfNumbers(numbers, visited, i+1, n, r-1, sumOfNumbers);
            visited[i] = false;
        }
        
        return sumOfNumbers;
    }
	
    /**
     * 
	 * @param numbers 숫자들이 들어있는 배열
	 * @param visited 방문체크
	 * @param n n개 중 r개 선택
	 * 
     * @return 방문체크 통과한 숫자들의 합
     */
    public static int getSumOfNumbers(int[] numbers, boolean[] visited, int n) {
    	int sumOfNumber = 0;
    	
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
            	sumOfNumber = sumOfNumber + numbers[i];
            }
        }
        
        return sumOfNumber;
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
