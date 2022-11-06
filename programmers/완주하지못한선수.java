package programmers;

import java.util.Arrays;

public class 완주하지못한선수 {

    public static void main(String[] args) {

    }

    /**
     * @date 2022-11-06
     *
     * @param participant 마라톤에 참여한 선수들의 이름이 담긴 배열
     * @param completion 완주한 선수들의 이름이 담긴 배열
     * @return 완주하지 못한 선수의 이름을
     */
    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++){
            if (!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }

}
