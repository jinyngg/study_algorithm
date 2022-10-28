package Programmers;

public class 짝수와홀수 {

    public static void main(String[] args) {
        System.out.println(solution(-1));
        System.out.println(solution(1));
        System.out.println(solution(2));
    }

    /**
     * @url 2022-10-25
     * 짝수와 홀수 lv.1
     * */
    public static String solution(int num) {
        if (num % 2 == 1 || num % 2 == -1) {
            return "Odd";
        }

        return "Even";
    }
}
