package Programmers;

public class 신규아이디추천 {

	public static void main(String[] args) {
		// result = "bat.y.abcdefghi"
		String new_id1 = "...!@BaT#*..y.abcdefghijklm";
		
		// result = "aaa"
		String new_id2 = "=.=";
		solution(new_id1);
		solution(new_id2);
	}
	
	/**
	 * @date 2022-10-31
	 * 
	 * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
	 * 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
	 * 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
	 * 
	 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
	 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
	 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	 * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	 * 
	 * @param new_id 신규 유저가 입력한 아이디
	 * 
	 * @return 프로그램이 추천하는 새로운 아이디
	 */
	public static String solution(String new_id) {
        String answer;
        answer = step1(new_id);
        answer = step2(answer);
        answer = step3(answer);
        answer = step4(answer);
        answer = step5(answer);
        answer = step6(answer);
        answer = step7(answer);
        
        System.out.println(answer);
        return answer;
    }
	
	public static boolean isEmptyString(String new_id) {
		return "".equals(new_id) == true ? true : false;
	}
	
	/**
	 * @param new_id
	 * @return 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환
	 */
	public static String step1(String new_id) {
		return new_id.toLowerCase();
	}
	
	/**
	 * @param new_id
	 * @return 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
	 */
	public static String step2(String new_id) {
		String pattern = "[^a-z0-9-_.]";
		return new_id.replaceAll(pattern, "");
	}
	
	/**
	 * 정규식 참조 : [Java] 문자열 연속된 공백 하나로 치환하기(https://hianna.tistory.com/529)
	 * 
	 * @param new_id
	 * @return new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	 */
	public static String step3(String new_id) {
		return new_id.replaceAll("\\.+", ".");
	}
	
	/**
	 * @param new_id
	 * @return new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	 */
	public static String step4(String new_id) {
		int lastIndex;
		int firstIndex = 0;
		
		// 마침표가 처음에 위치하는지 검사하기 전 빈 문자열 체크
		if(isEmptyString(new_id) == true) {
			return "";
		}
		
		new_id = new_id.substring(firstIndex, 1).equals(".") == true ? new_id.substring(1) : new_id;
		lastIndex = new_id.length();
		

		// 마침표가 마지막에 위치하는지 검사하기 전 빈 문자열 체크
		if(isEmptyString(new_id) == true) {
			return "";
		}
		
		return new_id.substring(lastIndex-1, lastIndex).equals(".") == true ? new_id.substring(firstIndex, lastIndex-1) : new_id;
	}
	
	/**
	 * @param new_id
	 * @return new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	 */
	public static String step5(String new_id) {
		return "".equals(new_id) == true ? "a" : new_id;
	}
	
	/**
	 * @param new_id
	 * @return 	new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	 * 			만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	 */
	public static String step6(String new_id) {
		int lastIndex;
		int length = new_id.length();
		new_id = length > 15 ? new_id.substring(0, 15) : new_id;
		lastIndex = new_id.length();
		return ".".equals(new_id.substring(lastIndex-1, lastIndex)) == true ? new_id.substring(0, lastIndex-1) : new_id;
	}
	
	/**
	 * @param new_id
	 * @return new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	 */
	public static String step7(String new_id) {
		StringBuilder sb = new StringBuilder();
		sb.append(new_id);
		
		int lastIndex = new_id.length();
		int repeat = lastIndex < 3 ? 3 - lastIndex : -1;
		String lastAlphabet = new_id.substring(lastIndex-1);
		
		for(int i=0; i<repeat; i++) {
			sb.append(lastAlphabet);
		}
		
		return sb.toString();
	}

}
