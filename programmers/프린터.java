package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프린터 {

	public static void main(String[] args) {
		
		// result : 1
		int[] priorities1 = {2, 1, 3, 2};
		int location1 = 2;
		
		// result : 5
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location2 = 0;
		
//		solution(priorities1, location1);
		solution(priorities2, location2);
	}
	
	/**
	 * @date 2022-11-25
	 * 
	 * 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
	 * 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
	 * location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
	 * 
	 * @param priorities 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열
	 * @param location 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치
	 * @return 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return
	 */
	public static int solution(int[] priorities, int location) {
		
		int answer = 1;
		int priority = 0;
		int document = 0;
		int myDocument = priorities[location];
		
		PriorityQueue<Integer> priorityList = new PriorityQueue<>(Collections.reverseOrder());
		for(int p : priorities) {
			priorityList.add(p);
		}
		
		if(location == 0 && myDocument == priorityList.peek()) {
			return answer;
		}
		
		Queue<Integer> printer = new LinkedList<>();
		for(int p : priorities) {
			printer.add(p);	
		}
		
		int maxOfIterations = priorities.length % 2 == 1 ? priorities.length * ((priorities.length-1) / 2) : (priorities.length * ((priorities.length) / 2)) - (priorities.length / 2);
		
		for(int i=0; i<maxOfIterations; i++) {
			priority = priorityList.peek();
			document = printer.peek();
			
			if(myDocument == priority) {
				for(int j=0; j<location; j++) {
					if(priorities[j] == priority) {
						answer = answer + 1;
						priorities[j] = -1;
						priorityList.poll();
						break;
					}
				}
			}
			
		}
		
		System.out.println(priorityList);
		System.out.println(priorityList.peek());
		System.out.println(printer);
		System.out.println(printer.peek());
//		System.out.println(maxOfIterations);
		
        return answer;
    }

}
