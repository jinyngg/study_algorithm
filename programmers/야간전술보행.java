package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 야간전술보행 {

    public static void main(String[] args) {

        // result = 12
        int distance = 12;
        int[][] scope = {{7, 8}, {4, 6}, {11, 10}};
        int[][] times = {{2, 2}, {2, 4}, {3, 3}};

        // result = 8
        int d = 10;
        int[][] sc = {	{3, 4}, {5, 8}};
        int[][] t = {{2, 5}, {4, 3}};

//        solution(distance, scope, times);
        solution(d, sc, t);
    }

    /**
     * @date 2022-11-12
     * @param distance 화랑이의 현재 위치와 적군 기지 사이의 거리를 나타내는 정수
     * @param scope 각 경비병의 감시 구간을 담은 2차원 정수 배열
     * @param times 같은 순서로 각 경비병의 근무 시간과 휴식 시간을 담은 2차원 정수 배열
     * @return 화랑이가 경비를 피해 최대로 이동할 수 있는 거리
     */
    public static int solution(int distance, int[][] scope, int[][] times) {

        int answer = 0;
        boolean isCaptured = false;

        // key : 정렬된 scope      value : times
        HashMap<int[], int[]> schedule = new HashMap<>();

        for(int i=0; i<scope.length; i++) {
            Arrays.sort(scope[i]);
            schedule.put(scope[i], times[i]);
        }
        Arrays.sort(scope, Comparator.comparingInt(o1 -> o1[0]));

        for(int i=0; i<scope.length; i++) {
            if(isCaptured) {
                break;
            }

            answer = scope[i][0] - 1;
            int[] time = schedule.get(scope[i]);
            int sumOfTime = time[0] + time[1];

            for(int j=0; j<=scope[i][1]-scope[i][0]; j++) {
                if(answer%sumOfTime < time[0]) {
                    System.out.println("적에게 적발 : " + answer+1);
                    return answer+1;
                }
                answer = answer + 1;
            }
        }

        answer = distance;

        System.out.println(answer);
        return answer;
    }
}
