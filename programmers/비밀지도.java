package programmers;

import java.util.Arrays;

public class 비밀지도 {

	public static void main(String[] args) {
		
		// result = ["#####","# # #", "### #", "# ##", "#####"]
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		
		solution(n, arr1, arr2);
	}
	
	/**
	 * @date 2022-11-04
	 * 
	 * Integer.toBinaryString(i) : 10진수를 2진수(String)으로 변경
	 * 
	 * @param n 입력으로 지도의 한 변 크기
	 * @param arr1 arr2 2개의 정수 배열
	 * @return 
	 */
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
        	int number = arr1[i] | arr2[i];
        	String map = Integer.toBinaryString(number);
        	
        	if(map.length() < n) {
        		StringBuilder sb = new StringBuilder();
        		
        		while(sb.length() < n-map.length()) {
        			sb.append("0");
        		}
        		map = sb.append(map).toString();
        	}
        	
        	map = map.replace("1", "#").replace("0", " ");
        	answer[i] = map;
        }
        
        return answer;
    }
}
