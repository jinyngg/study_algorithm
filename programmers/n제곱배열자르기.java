package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class n제곱배열자르기 {

    public static void main(String[] args) {

        // result = [4,3,3,3,4,4,4,4]
        solution(4, 7, 14);
    }

    /**
     * @date 2022-11-09
     *
     * 1 ≤ n ≤ 10^7
     * 0 ≤ left ≤ right < n^2
     * right - left < 10^5
     *
     * @param n n행 n열 크기의 비어있는 2차원 배열
     * @param left START
     * @param right END
     * @return 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
     */
    public static int[] solution(int n, long left, long right) {
        int share;
        int remainder;

        int shareOfLeft = (int) (left / n);
        int remainderOfLeft = (int) (left % n);
        int shareOfRight = (int) (right / n);
        int remainderOfRight = (int) (right % n);

        int start = (shareOfLeft < remainderOfLeft) == true ?  remainderOfLeft + 1 : shareOfLeft + 1;
        int end = (shareOfRight < remainderOfRight) == true ?  remainderOfRight + 1 : shareOfRight + 1;

        ArrayList<Integer> array = new ArrayList<>();
        array.add(start);

        for(long i = left+1; i<right; i++) {
            share = (int) (i / n);
            remainder = (int) (i % n);

            int value = (share < remainder) == true ?  remainder + 1 : share + 1;
            array.add(value);
        }
        array.add(end);

        int[] answer = new int[array.size()];
        for(int i=0; i<array.size(); i++){
            answer[i] = array.get(i);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
