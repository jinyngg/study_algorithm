package Programmers;

import java.util.ArrayList;

public class 키패드누르기_refactoring {

	public static void main(String[] args) {
		// result = LRLLRRLLLRR
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		
		solution(numbers, hand);
	}
	
	/**
	 * @date 2022-10-31
	 * 
	 * 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 #
	 * 
	 * 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락, 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용
	 * 
	 * 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
	 * 약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용
	 * 
	 * @param numbers 순서대로 누를 번호가 담긴 배열
	 * @param hand 왼손잡이인지 오른손잡이인 지를 나타내는 문자열
	 * 
	 * @return 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열
	 */
	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		
		// *->(3,0), #->(3,2)
		int left = 10;
		int right = 12;
		
		// 왼손 오른손 좌표
		int x;
		int y;
		int leftX;
		int leftY;
		int rightX;
		int rightY;
		
		ArrayList<Integer> leftInput = new ArrayList<>();
		ArrayList<Integer> rightInput = new ArrayList<>();	
		
		leftInput.add(1);
		leftInput.add(4);
		leftInput.add(7);
		rightInput.add(3);
		rightInput.add(6);
		rightInput.add(9);
		
		for(int number : numbers) {
			number = number == 0 ? 11 : number;
			
			if(leftInput.contains(number)) {
				sb.append("L");
				left = number;
			}
			
			else if(rightInput.contains(number)) {
				sb.append("R");
				right = number;
			}
			
			else {
				x = (number-1) / 3;
				y = (number-1) % 3;
				
				leftX = (left-1) / 3;
				leftY = (left-1) % 3;
				rightX = (right-1) / 3;
				rightY = (right-1) % 3;
				
				int distanceLeft = Math.abs(x-leftX) + Math.abs(y-leftY);
				int distanceRight = Math.abs(x-rightX) + Math.abs(y-rightY);
				
				if(distanceLeft < distanceRight) {
					sb.append("L");
					left = number;
				}
				
				else if(distanceLeft > distanceRight) {
					sb.append("R");
					right = number;
				}
				 
				else {
					if("left".equals(hand) == true) {
						sb.append("L");
						left = number;
					}
					
					else { 
						sb.append("R");
						right = number;
					}
				}
			}
		}
		System.out.println(sb.toString());
        return sb.toString();
    }
	
}
