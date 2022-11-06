package programmers;

import java.util.Arrays;

public class 햄버거만들기 {

    public static void main(String[] args) {

        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        solution(ingredient);

    }

    /**
     * @date 2022-11-06
     *
     * 1 ≤ ingredient의 길이 ≤ 1,000,000
     *
     * @param ingredient 상수에게 전해지는 재료의 정보를 나타내는 정수 배열
     * @return 상수가 포장하는 햄버거의 개수
     */
    public static int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        for(int in : ingredient) {
            sb.append(String.valueOf(in));
        }

        String hamburger = sb.toString();

        while (hamburger.lastIndexOf("1231") > -1) {
            hamburger = hamburger.replaceFirst("1231", "");
            answer++;
        }

        return answer;
    }

}
