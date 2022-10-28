package Programmers;

public class 숫자문자열과영단어 {

    public static void main(String[] args) {
        System.out.println(solution("1one2three"));
        System.out.println(solution("one4seveneight"));
    }

    /**
     * @url 2022-10-26
     * 숫자문자열과영단어 lv.1
     * */
    public static int solution(String s) {
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < 10; i++) {
            s = s.replace(number[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }

}
