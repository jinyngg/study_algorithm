package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class 베스트앨범 {

	public static void main(String[] args) {
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		solution(genres, plays);
	}

	/**
	 * @date 2022-11-08
	 * 
	 * genres[i]는 고유번호가 i인 노래의 장르입니다.
	 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
	 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
	 * 장르 종류는 100개 미만입니다.
	 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
	 * 모든 장르는 재생된 횟수가 다릅니다.
	 * 
	 * @param genres 노래의 장르를 나타내는 문자열 배열
	 * @param plays 래별 재생 횟수를 나타내는 정수 배열
	 * @return 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로
	 */
	public static int[] solution(String[] genres, int[] plays) {
		
		HashMap<String, Integer> playOfGenre = new HashMap<>();	
		List<HashMap.Entry<String, Integer>> mostPlayedGenre = null;
		
		for(int i=0; i<genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];
			
			playOfGenre.put(genre, playOfGenre.getOrDefault(playOfGenre, 0) + play);
		}
		
		mostPlayedGenre = new LinkedList<>(playOfGenre.entrySet());
		Collections.sort(mostPlayedGenre, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return 0;
			}
			
		});
		
		for(String genre : playOfGenre.keySet()) {
		}
		
        int[] answer = {};
        return answer;
    }
}
