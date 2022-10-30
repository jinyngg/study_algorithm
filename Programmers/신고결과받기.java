package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {

	public static void main(String[] args) {
        // result = 2,1,1,0
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(solution(id_list, report, k));
	}

	/**
	 * @date 2022-10-28
	 * 
	 * @param id_list 이용자의 ID가 담긴 문자열 배열
	 * @param report  각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열
	 * @param k 정지 기준이 되는 신고 횟수 
	 * 
	 * @return 각 유저별로 처리 결과 메일을 받은 횟수
	 */
	public static int[] solution(String[] id_list, String[] report, int k) {
        int reportedCount; // 신고당한 횟수
        String user; // 일반 유저
        String reportUser; // 신고한 유저
        String reportedUser; // 신고당한 유저
        
        int numberOfUsers = id_list.length; // 유저 수
        
        HashSet<String> reportedUserList = null; // 중복되지 않은 신고당한 유저 목록

        HashMap<String, HashSet<String>> reportUsers = new HashMap<>();// 유저가 신고한 유저목록 (key : userId, value : Set<String> reportedUserList)
        HashMap<String, Integer> reportedUsersCount = new HashMap<>(); // 유저의 신고당한 횟수 (key : userId, value : reportedCount)
        
        ArrayList<String> blockUsers = new ArrayList<>(); // 정지된 유저 목록
		int[] answer = new int[numberOfUsers]; // 각 유저가 받은 결과 메일 수

        for(int i=0; i<numberOfUsers; i++) {
            reportedUsersCount.put(id_list[i], 0);
        }

        for(int i=0; i<numberOfUsers; i++) {
            user = id_list[i];
            reportedUserList = new HashSet<>();

            for(int j=0; j<report.length; j++) {
                reportUser = report[j].substring(0, report[j].indexOf(" "));

                // 1. 신고당한 유저의 신고당한 횟수 Update
                if (user.equals(reportUser)) {
                    reportedUser = report[j].substring(report[j].indexOf(" ")+1);
                    reportedCount = reportedUserList.contains(reportedUser) == false ? reportedUsersCount.get(reportedUser) + 1 : reportedUsersCount.get(reportedUser);

                    reportedUserList.add(reportedUser);
                    reportedUsersCount.put(reportedUser, reportedCount);
                }
            }

            // 2. 유저가 신고한 유저 리스트 Update
            reportUsers.put(user, reportedUserList);
        }

        // 3. 신고당한 횟수가 k번 이상인지 확인
        for(int i=0; i<numberOfUsers; i++) {
            if(reportedUsersCount.get(id_list[i]) > k-1) {
                blockUsers.add(id_list[i]);
            }
        }

        // 4. 각 유저가 받은 결과 메일 수 Update
        for (int i=0; i<numberOfUsers; i++) {
            for(int j=0; j<blockUsers.size(); j++) {
                if(reportUsers.get(id_list[i]).contains(blockUsers.get(j))) {
                    answer[i] = answer[i] + 1;
                }
            }
        }

        return answer;
    }
}