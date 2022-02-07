package practice02;

import java.util.Scanner;

public class MainClass {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	String str_A = in.next();	//����ڷκ��� �Է¹޴� ������ �������� �ƴϰ� char ��
	String str_B = in.next();
	
	// �� ���� �� �� ���� �� �ڸ��� ���̸� ���ص�
	int max_length = Math.max(str_A.length(), str_B.length());
	
	
	int[] A = new int[max_length + 1];	// ������ �ڸ��� �ø��� ���� �� �����Ƿ� +1
	int[] B = new int[max_length + 1];	// ������ �ڸ��� �ø��� ���� �� �����Ƿ� +1
	
	

	// A �ʱ�ȭ
	for(int i = str_A.length() - 1, idx = 0; i >= 0; i--, idx++) {
		A[idx] = str_A.charAt(i) - '0';	// �� �� ���ں��� �������� �ϳ��� ����, 
	}

	
	// B �ʱ�ȭ
	for(int i = str_B.length() - 1, idx = 0; i >= 0; i--, idx++) {
		B[idx] = str_B.charAt(i) - '0';	// �� �� ���ں��� �������� �ϳ��� ����
	}
	
	// ����
	for(int i = 0; i < max_length; i++) {
		int value = A[i] + B[i];
		A[i] = value % 10;		// ���� ���� 10���� ���� �������� �ڸ����� ��
		A[i + 1] += (value / 10);	// ���� ���� 10���� ���� ���� �ø����� ��
	}
	
	// A�迭 ���� ���
	// ���� ���� �ڸ����� 0�� ���� �ֱ� ������ 0�� �ƴ� ��쿡�� ���
	StringBuilder sb = new StringBuilder();
	if(A[max_length] != 0) {
		sb.append(A[max_length]);
	}
	/*
	 * �� ������ �迭���� ���� ����. �ø��Ǿ� 1�̶�� ���ڰ� �Ǹ����� �迭�� �ִٸ� ���� append�Լ��� sb�� ä��� �� ���� for�� ����
	 * */
	for(int i = max_length - 1; i >= 0; i--) {
		sb.append(A[i]);	//�̹� 1�� �迭�� �߰� �� ���Ŀ� append�Լ��� ä���� �ٽ� �������� ����ؾ��ϹǷ� �������� �迭�� ��� �۾�
	}
	
	System.out.println(sb);	//�������� �ٲ㼭 ���ϰ�,�ڸ��ø����� �� �� �迭�� �ٽ� �������� �ٲ� �迭�� sb�� ���
}
}