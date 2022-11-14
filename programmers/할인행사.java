package programmers;

import java.util.HashMap;

public class 할인행사 {

	public static void main(String[] args) {
		
		// result = 3 
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		
		solution(want, number, discount);
	}
	
	/**
	 * @date 2022-11-14
	 * 
	 * @param want 정현이가 원하는 제품을 나타내는 문자열 배열 
	 * @param number 정현이가 원하는 제품의 수량을 나타내는 정수 배열 
	 * @param discount XYZ 마트에서 할인하는 제품을 나타내는 문자열 배열
	 * @return 회원등록시 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수
	 */
	public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> foodstuffs = new HashMap<>();
        HashMap<String, Integer> copy = new HashMap<>();
        for(int i=0; i<want.length; i++) {
        	foodstuffs.put(want[i], number[i]);
        }
        
        for(int i=0; i<discount.length; i++) {
        	copy.putAll(foodstuffs);
        	
        	if((i+10) > discount.length) {
        		break;
        	}
        	
        	for(int j=i; j<(i+10); j++) {
        		if(null == copy.get(discount[j])) {
        			break;
        		}
        		
        		copy.put(discount[j], copy.get(discount[j]) - 1);
        		if(copy.get(discount[j]) == 0) {
        			copy.remove(discount[j]);
        		}
        	}
        	
        	if(copy.size() == 0) {
        		answer = answer + 1;
        	}
        }
         
        System.out.println(answer);
        return answer;
    }

}
