package javaPractice;

import java.util.Random;

public class InsertionSort {
	static final int SIZE = 10;
	public static void main(String[] args) {


		Random rand = new Random();
		int[] data;

		data = new int[SIZE];			

		for(int i = 0 ; i < data.length ; i++) {
			data[i] = rand.nextInt(100)+1;		//���������� �迭 �Է�
		}

		System.out.print("����� �迭 : ");
		for(int v : data) {
			System.out.print(v + " ");
		}
		System.out.println();

		for(int i = 1 ; i< data.length; i++) {
			int tmp = data[i];					//�ӽú����� i��° ������ ����
			int index = 0;						//�ε����� ������ ����

			for(int j = i-1 ; j >= 0 ; j--) {	// i-1�� ������ �迭�������� ����� �ʱ�����
				if(tmp < data[j]) {				//����� ���� ���� data[j]�� ũ�� �о��
					data[j+1] = data[j];
				}
				else {							//����� ���� ���� data[j]�� ������ ���� 
					index = j+1;				//j+1�� �����
					break;
				}

			}


			data[index] =tmp;					//�ӽú����� ����� ���� �ڸ��� ����

			System.out.print(i + "ȸ�� : ");		//1ȸ������ ���ĵ� �迭���	
			for(int v : data) {
				System.out.print(v + " ");
			}
			System.out.println();
			
		
		}
		
		
		System.out.print("���ĵ� �迭 : ");			//���ĵ� �迭���
		for(int v : data) {
			System.out.print(v + " ");
		}
		System.out.println();


	}
}
