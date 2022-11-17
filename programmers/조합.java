package programmers;

/**
 * @date 2022-11-17
 * 알고리즘 : 조합 공부
 */
public class 조합 {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination(arr, visited, 0, n, i);
        }
    }

    /**
     * 백 트래킹 사용하여 조합 출력
     *
     * @param numbers {1,2,3,4..}
     * @param visited 방문체크
     * @param start 시작 : 0
     * @param n n개 중 r개 선택
     * @param r n개 중 r개 선택
     */
    static void combination(int[] numbers, boolean[] visited, int start, int n, int r) {
        // r == 0 : n개 중 r개 선택이 완료
        if (r == 0) {
            print(numbers, visited, n);
            return;
        }

        // r개를 선택하기 위해 반복 
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(numbers, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    /**
     * 출력함수
     * 
     * @param numbers {1,2,3,4..}
     * @param visited 방문체크
     * @param n n개 중 r개 선택
     */
    static void print(int[] numbers, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();
    }
}
