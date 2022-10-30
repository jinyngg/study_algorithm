package Programmers;

public class 콜라문제 {

    public static void main(String[] args) {
        // result = 9
        int a = 3;
        int b = 1;
        int n = 20;

        System.out.println(solution(a, b, n));
    }

    /**
     * @date 2022-10-30
     *
     * 1 ≤ b < a ≤ n ≤ 1,000,000
     * 정답은 항상 int 범위를 넘지 않게 주어집니다.
     *
     * 1. 가지고 있는 빈 콜라 병의 수 = (n % a) + (b * (n/a))
     * 2-1. 보유 중인 빈 콜라 병의 수가 2개 미만이면 종료
     * 2-2. 보유 중인 빈 콜라 병의 수가 a개 미만이면 종료
     *
     * @param a 콜라를 받기 위해 마트에 주어야 하는 병 수
     * @param b 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수
     * @param n 상빈이가 가지고 있는 빈 병의 개수
     *
     * @return 상빈이가 받을 수 있는 콜라의 병 수
     */
    public static int solution(int a, int b, int n) {
        int answer = 0;

        do {
            answer += (b * (n/a));
            n = (n % a) + (b * (n/a));
        } while(n>=2 && n>=a);

        return answer;
    }
}
