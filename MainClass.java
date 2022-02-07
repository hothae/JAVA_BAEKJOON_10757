package practice02;

import java.util.Scanner;

public class MainClass {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	String str_A = in.next();	//사용자로부터 입력받는 정수는 정수형이 아니고 char 형
	String str_B = in.next();
	
	// 두 개의 수 중 가장 긴 자리수 길이를 구해둠
	int max_length = Math.max(str_A.length(), str_B.length());
	
	
	int[] A = new int[max_length + 1];	// 마지막 자리수 올림이 있을 수 있으므로 +1
	int[] B = new int[max_length + 1];	// 마지막 자리수 올림이 있을 수 있으므로 +1
	
	

	// A 초기화
	for(int i = str_A.length() - 1, idx = 0; i >= 0; i--, idx++) {
		A[idx] = str_A.charAt(i) - '0';	// 맨 뒤 문자부터 역순으로 하나씩 저장, 
	}

	
	// B 초기화
	for(int i = str_B.length() - 1, idx = 0; i >= 0; i--, idx++) {
		B[idx] = str_B.charAt(i) - '0';	// 맨 뒤 문자부터 역순으로 하나씩 저장
	}
	
	// 덧셈
	for(int i = 0; i < max_length; i++) {
		int value = A[i] + B[i];
		A[i] = value % 10;		// 더한 값의 10으로 나눈 나머지가 자리값이 됨
		A[i + 1] += (value / 10);	// 더한 값의 10으로 나눈 몫이 올림값이 됨
	}
	
	// A배열 역순 출력
	// 가장 높은 자리수가 0일 수도 있기 때문에 0이 아닐 경우에만 출력
	StringBuilder sb = new StringBuilder();
	if(A[max_length] != 0) {
		sb.append(A[max_length]);
	}
	/*
	 * 맨 마지막 배열만을 먼저 따짐. 올림되어 1이라는 숫자가 맨마지막 배열에 있다면 먼저 append함수로 sb에 채우고 난 이후 for문 실행
	 * */
	for(int i = max_length - 1; i >= 0; i--) {
		sb.append(A[i]);	//이미 1이 배열에 추가 된 이후에 append함수로 채워짐 다시 역순으로 출력해야하므로 역순으로 배열에 담는 작업
	}
	
	System.out.println(sb);	//역순으로 바꿔서 더하고,자리올림까지 다 한 배열을 다시 역순으로 바꾼 배열인 sb를 출력
}
}