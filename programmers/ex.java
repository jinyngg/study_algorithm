package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		
		int[] order ={2, 1, 6, 7, 5, 8, 4, 9, 3, 10};
		
		//현재까지 꺼낸 박스 수
		int outCnt = 1;
		
		//보조 컨테이너
		Stack<Integer> subContainer = new Stack<Integer>();
		
		for( int i=0; i<order.length; i++ ){
			
			
			
			System.out.println(" 꺼낸 택배 상자  : " + outCnt);
			System.out.println(" 현재 싣을 택배 상자 값 : " + order[i]);
			
			System.out.println(" 현재 보조 컨테이너 값 : " + subContainer.toString());
			
			if( !subContainer.isEmpty() && subContainer.peek() == order[i] ){
				subContainer.pop();
				answer+=1;
				System.out.println(" answer : " + answer );
				System.out.println(" outCnt : " + outCnt );
				continue;
			}
			
			//보조 컨테이너에 수납
			while( order[i] > outCnt ){
				System.out.println(" 보조 컨테이너에 넣는 값 : " + outCnt );
				subContainer.push(outCnt);
				outCnt += 1;

			}
			
			
			if( order[i] == outCnt ){
				answer += 1;
				outCnt += 1;
				System.out.println(" answer : " + answer );
				System.out.println(" outCnt : " + outCnt );
				continue;
			}
			
			//작은 경우 for문 순환 더 이상 하지 않음
			//같은 경우는 올 수 없음,중복된 값이 없기 때문
			if( order[i] < outCnt ){
				System.out.println(" 순환 종료 " );
				System.out.println(" order[i] :  " + order[i] );
				System.out.println(" outCnt : " + outCnt );
				break;
			}
			
			System.out.println(" answer : " + answer );
			System.out.println(" outCnt : " + outCnt );
		}
		
		System.out.println(" 최종 answer : " + answer );
	}

	class Solution {
	    public int solution(String dartResult) {
			int answer = 0;
			return answer;
	    }
	}

}
