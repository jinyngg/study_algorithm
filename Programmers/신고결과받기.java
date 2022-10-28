package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class �Ű����ޱ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param id_list �̿����� ID�� ��� ���ڿ� �迭
	 * @param report  �� �̿��ڰ� �Ű��� �̿����� ID ������ ��� ���ڿ� �迭
	 * @param k ���� ������ �Ǵ� �Ű� Ƚ�� 
	 * 
	 * @return �� �������� ó�� ��� ������ ���� Ƚ��
	 */
	public static int[] solution(String[] id_list, String[] report, int k) {
        int reportedCount; // �Ű���� Ƚ��
        String user; // �Ϲ� ����
        String reportUser; // �Ű��� ����
        String reportedUser; // �Ű���� ����
        
        int numberOfUsers = id_list.length; // ���� ��
        
        HashSet<String> reportedUserList = null; // �ߺ����� ���� �Ű���� ���� ���

        HashMap<String, HashSet<String>> reportUsers = new HashMap<>();// ������ �Ű��� ������� (key : userId, value : Set<String> reportedUserList)
        HashMap<String, Integer> reportedUsersCount = new HashMap<>(); // ������ �Ű���� Ƚ�� (key : userId, value : reportedCount)
        
        ArrayList<String> blockUsers = new ArrayList<>(); // ������ ���� ���
		int[] answer = new int[numberOfUsers]; // �� ������ ���� ��� ���� ��

        for(int i=0; i<numberOfUsers; i++) {
            reportedUsersCount.put(id_list[i], 0);
        }

        for(int i=0; i<numberOfUsers; i++) {
            user = id_list[i];
            reportedUserList = new HashSet<>();

            for(int j=0; j<report.length; j++) {
                reportUser = report[j].substring(0, report[j].indexOf(" "));

                // 1. �Ű���� ������ �Ű���� Ƚ�� Update
                if (user.equals(reportUser)) {
                    reportedUser = report[j].substring(report[j].indexOf(" ")+1);
                    reportedCount = reportedUserList.contains(reportedUser) == false ? reportedUsersCount.get(reportedUser) + 1 : reportedUsersCount.get(reportedUser);

                    reportedUserList.add(reportedUser);
                    reportedUsersCount.put(reportedUser, reportedCount);
                }
            }

            // 2. ������ �Ű��� ���� ����Ʈ Update
            reportUsers.put(user, reportedUserList);
        }

        // 3. �Ű���� Ƚ���� k�� �̻����� Ȯ��
        for(int i=0; i<numberOfUsers; i++) {
            if(reportedUsersCount.get(id_list[i]) > k-1) {
                blockUsers.add(id_list[i]);
            }
        }

        // 4. �� ������ ���� ��� ���� �� Update
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
