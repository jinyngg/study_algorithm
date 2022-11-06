package programmers;

import java.util.Stack;

public class 크레인인형뽑기게임 {

    public static void main(String[] args) {

        // result = 4
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        solution(board, moves);
    }

    /**
     * @date 2022-11-06
     *
     * @param board 게임 화면의 격자의 상태가 담긴 2차원 배열
     * @param moves 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열
     * @return 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수
     */
    public static int solution(int[][] board, int[] moves) {

        int answer = 0;

        // 인형뽑기 바구니
        Stack<Integer> bucket = new Stack<>();

        // 크레인 동작 횟수만큼 반복
        for(int i=0; i<moves.length; i++) {
            int move = moves[i];
            
            // 아래로 탐색
            for(int j=0; j<board.length; j++) {
                int doll = board[j][move-1];

                // 인형칸이 비었을 경우 아래로 진행
                if(0 == doll) {
                    continue;
                }

                // 바구니가 비었을 경우, 해당 인형 푸쉬
                if(bucket.empty()==true) {
                    bucket.push(doll);
                    board[j][move-1] = 0;
                    break;
                }

                // 바구니가 비어있지 않을 경우, peek()과 같은 인형인지 확인
                else if(doll == bucket.peek()) {
                    bucket.pop();
                    board[j][move-1] = 0;
                    answer = answer + 2;
                    break;
                }

                else {
                    bucket.push(doll);
                    board[j][move-1] = 0;
                    break;
                }
            }
        }

        System.out.println("터진 인형의 갯수 : " + answer);
        return answer;
    }
}
