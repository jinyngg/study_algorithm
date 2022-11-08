package programmers;

import java.util.HashMap;

public class 위장 {

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		solution(clothes);
	}

	/**
	 * @date 2022-11-07
	 * 
	 * 종류 (face, outer)				갯수 : (a b)			a + b + ab						(a+1)(b+1)-1
	 * 종류 (face, outer, headgear)	갯수 : (a, b, c)		a + b + c + (ab+ac+bc) + abc	(a+1)(b+1)(c+1)-1
	 * 
	 * @param clothes 스파이가 가진 의상들이 담긴 2차원 배열
	 * @return 서로 다른 옷의 조합의 수
	 */
	public static int solution(String[][] clothes) {
		int count = 1;
        
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
		for(int i = 0; i < clothes.length; i++) {
        	String clothesMapKey = clothes[i][1];
        	clothesMap.put(clothesMapKey, clothesMap.getOrDefault(clothesMapKey, 0) + 1);
        }
        
		for(String clothesMapKey : clothesMap.keySet()) {
        	count *= (clothesMap.get(clothesMapKey) + 1);
        }
        
        return count - 1;
    }
	
}
