package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 같은숫자는싫어 {

    public static void main(String[] args) {

        // result = {1,3,0,1};
        int[] arr = {1,1,3,3,0,1,1};

        solution(arr);
    }

    /**
     * @date 2022-11-22
     *
     * 배열 arr의 크기 : 1,000,000 이하의 자연수
     * 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
     *
     * @param arr
     * @return 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수
     */
    public static int[] solution(int []arr) {
        Stack<Integer> numbers = new Stack<>();
        Queue<Integer> store = new LinkedList<>();

        numbers.push(arr[0]);
        store.add(arr[0]);

        for(int i=1; i<arr.length; i++) {
            if(numbers.peek() == arr[i]) {
                continue;
            }
            numbers.push(arr[i]);
            store.add(arr[i]);
        }

        int[] answer = new int[store.size()];

        for(int i=0; i<answer.length; i++) {
            answer[i] = store.peek();
            store.poll();
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
