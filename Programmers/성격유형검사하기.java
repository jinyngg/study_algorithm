package Programmers;

import java.util.Arrays;
import java.util.HashMap;

public class 성격유형검사하기 {

	public static void main(String[] args) {
		// 결과 'TCMA' 나와야 정답
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		System.out.println(solution(survey, choices));
	}

	/**
	 * @date 2022-10-29
	 * 성격 유형 검사하기 lv.1
	 *
	 * R T
	 * C F
	 * J M
	 * A N
	 *
	 * @param survey 질문마다 판단하는 지표를 담은 1차원 문자열 배열
	 * @param choices 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열
	 *
	 * @return 성격 유형 검사 결과를 지표 번호 순서대로 리턴
	 */
	public static String solution(String[] survey, int[] choices) {
		// 각 유형별 점수 (key : 유형, value : 점수)
		HashMap<Character, Integer> score = new HashMap<>();

		// 성격 유형 검사 실제 점수
		int realScore = 0;

		for(int i=0; i<survey.length; i++) {
			int choice = choices[i];
			Character type = choice < 5 ? survey[i].charAt(0) : survey[i].charAt(1);

			ScoreOfOption scoreOfOption = ScoreOfOption.valueOfCode(choice);
			realScore = scoreOfOption.getScore();

			score.put(type, score.getOrDefault(type, 0) + realScore);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(score.getOrDefault('R', 0) >= score.getOrDefault('T', 0) ? 'R' : 'T');
		sb.append(score.getOrDefault('C', 0) >= score.getOrDefault('F', 0) ? 'C' : 'F');
		sb.append(score.getOrDefault('J', 0) >= score.getOrDefault('M', 0) ? 'J' : 'M');
		sb.append(score.getOrDefault('A', 0) >= score.getOrDefault('N', 0) ? 'A' : 'N');

		return sb.toString();
	}

	enum ScoreOfOption {
		VERY_DISAGREE("매우 비동의", 1, 3)
		, DISAGREE("비동의", 2, 2)
		, LITTLE_DISAGREE("약간 비동의", 3, 1)
		, NEITHER_DISAGREE_NOR_AGREE("모르겠음", 4, 0)
		, LITTLE_AGREE("약간 동의", 5, 1)
		, AGREE("동의", 6, 2)
		, VERY_AGREE("매우 동의", 7, 3)
		;

		ScoreOfOption(String option, int choice, int score) {
			this.option = option;
			this.choice = choice;
			this.score = score;
		}

		private String option;  // 선택지
		private int choice;     // 점수
		private int score;      // 실제 점수

		public int getScore() {
			return score;
		}

		public static ScoreOfOption valueOfCode(int ch) {
			return Arrays.stream(values())
					.filter(value -> value.choice == ch)
					.findAny()
					.orElse(null);
		}
	}
}