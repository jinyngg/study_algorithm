package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

    public static void main(String[] args) {

        // result = [1, 3, 2]
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

//        solution(progresses, speeds);

        // result = [2, 1];
        int[] a = {93, 30, 55};
        int[] b = {1, 30, 5};

        solution(a, b);


    }

    /**
     * @date 2022-11-22
     *
     * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
     * 작업 진도는 100 미만의 자연수입니다.
     * 작업 속도는 100 이하의 자연수입니다.
     * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
     *
     * @param progresses 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
     * @param speeds 각 작업의 개발 속도가 적힌 정수 배열
     * @return 각 배포마다 몇 개의 기능이 배포되는지
     */
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> deploy = new LinkedList<>();
        int[] days = new int[progresses.length];

        for(int i=0; i<progresses.length; i++) {
            int task = 100 - progresses[i];
            days[i] = (task % speeds[i] == 0) ? (task / speeds[i]) : (task / speeds[i]) + 1;
        }

        // 남은 기간 구하기
        System.out.println(Arrays.toString(days));

        int key = days[0];
        int count = 1;

        for(int i=1; i<days.length; i++) {
            int day = days[i];
            if(key < day) {
                deploy.add(count);
                key = day;
                count = 1;

                if(i==days.length-1) {
                    deploy.add(count);
                }

                continue;
            }
            count = count + 1;
            if(i==days.length-1) {
                deploy.add(count);
            }
        }

        System.out.println(deploy);

        int repeat = deploy.size();
        int[] answer = new int[repeat];
        for(int i=0; i<repeat; i++) {
            answer[i] = deploy.poll();
        }
        return answer;
    }
}
