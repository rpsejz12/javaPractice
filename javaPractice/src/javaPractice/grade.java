package javaPractice;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Student {
	Random rand = new Random();
	int sNum;	//�й�
	int kor;	//�����
	int eng;	//�����
	int mat;	//���м���
	int abs;	//�Ἦ
	
	int sum;
	int avg;
	
	String grade;
	Boolean flag = false;
	

	

	
	Student(int sNum, int kor, int eng, int mat){	//������
		this.sNum = sNum;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.abs = rand.nextInt(2);
		func();
	}
	
	void func(){
		int absScore;
		absScore = (20-this.abs)*10;
		this.sum = this.kor + this.eng + this.mat + absScore ;
		this.avg = sum/5;
		
		if(avg>=90) {
			this.grade = "A";
		}
		else if(avg<90 && avg>=80) {
			this.grade = "B";
		}
		else if(avg<80 && avg>=70) {
			this.grade = "C";
		}
		else if(avg<70 && avg>=60) {
			this.grade = "D";
		}
		else{
			this.grade = "F";
		}
		
		if(this.avg > 85 && this.abs<=1) {
			this.flag = true;
		}
	}
}

public class grade {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sNum = 1001;
		int choice;		//�޴����� ����
		int kor;
		int eng;
		int mat;
		
		int korSum=0;
		int korAvg=0;
		int engSum=0;
		int engAvg=0;
		int matSum=0;
		int matAvg=0;
		int sumSum=0;
		int sumAvg=0;
		int avgSum=0;
		int avgAvg=0;
		
		
		ArrayList<Student> stArr = new ArrayList();
		while(true) {
			System.out.println("���� ���α׷�");
			
			System.out.println("�޴�����");
			System.out.println("1.�����Է� 2.��ü������� 3.��������� 4.���� ");
			
			choice = sc.nextInt();	//��ȿ�� �˻�
			
			if(choice == 1) {			//�����Է�
				System.out.println("�����Է�");
				System.out.println(sNum + "�� �л� ����,����,���� �����Է� :");
				kor= sc.nextInt();
				eng = sc.nextInt();
				mat = sc.nextInt();
				stArr.add(new Student(sNum, kor,eng,mat));	
				korSum += kor;
				engSum += eng;
				matSum += mat;
				sNum++;
			}
			else if(choice ==2) {		//��ü���� ���
				System.out.println("��ü�������");
				engAvg = engSum/ stArr.size();
				matAvg = matSum/stArr.size();	
				korAvg = korSum/stArr.size();
				sumSum = korSum + engSum + matSum;
				sumAvg = korAvg + engAvg + matAvg;
				avgSum = korAvg + engAvg + matAvg;
				avgAvg = avgSum/3;
				
				
				//���
				//����
				//���бݿ���
				
				for(int i = 0 ; i < stArr.size(); i++) {
					int rank = 1;
					for(int j = 0 ; j <stArr.size(); j++) {
						if(stArr.get(i).sum < stArr.get(j).sum) {
							rank++;
						}
					}
				
					
					System.out.print(stArr.get(i).sNum + "   " + stArr.get(i).kor + "   " + stArr.get(i).eng + "   " + stArr.get(i).mat + "   " );
					System.out.print(stArr.get(i).abs + "   " + stArr.get(i).sum + "   " + stArr.get(i).avg + "   " + rank + "   " + stArr.get(i).grade + "   ");
					if(stArr.get(i).flag) {
						System.out.print("���б�");
					}
					System.out.println();
				}
				
				System.out.println("�հ�" + "   " + korSum + "   " + engSum + "   " + matSum + "   " + "0" + "   " + sumSum + "   " + sumAvg + "   " + "0");
				System.out.println("���" + "   " + korAvg + "   " + engAvg + "   " + matAvg + "   " + "0" + "   " + avgSum + "   " + avgAvg + "   " + "0");

				
			}
			else if(choice ==3) {		//������ ���
				System.out.println("���������");
				
				for(int i = 0 ; i< stArr.size(); i++) {
					if(stArr.get(i).flag) {
						System.out.println(stArr.get(i).sNum+ "  ");
					}
				}
			}
			else if(choice ==4) {		//����
				System.out.println("����");
				break;
			}
		}
	}

}







