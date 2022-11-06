package programmers;

public class 푸드파이트대회 {

    public static void main(String[] args) {

        // result = "1223330333221"
        int[] food = {1, 3, 4, 6};

        solution(food);

    }

    /**
     * @date 2022-11-06
     *
     * @param food 수웅이가 준비한 음식의 양을 칼로리가 적은 순서대로 나타내는 정수 배열
     * @return 대회를 위한 음식의 배치를 나타내는 문자열
     */
    public static String solution(int[] food) {

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<food.length; i++) {
            int share = food[i] / 2;

            for(int j=0; j<share; j++) {
                sb.append(i);
            }
        }

        String answer = sb.toString() + "0" + sb.reverse().toString();
        System.out.println("정답 : " + answer);

        return answer;
    }
}
