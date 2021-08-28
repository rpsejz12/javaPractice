package javaPractice;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Student {
	Random rand = new Random();
	int sNum;	//학번
	int kor;	//국어성적
	int eng;	//영어성적
	int mat;	//수학성적
	int abs;	//결석
	
	int sum;
	int avg;
	
	String grade;
	Boolean flag = false;
	

	

	
	Student(int sNum, int kor, int eng, int mat){	//생성자
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
		int choice;		//메뉴선택 변수
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
			System.out.println("성적 프로그램");
			
			System.out.println("메뉴선택");
			System.out.println("1.성적입력 2.전체성적출력 3.수상자출력 4.종료 ");
			
			choice = sc.nextInt();	//유효성 검사
			
			if(choice == 1) {			//성적입력
				System.out.println("성적입력");
				System.out.println(sNum + "번 학생 국어,영어,수학 점수입력 :");
				kor= sc.nextInt();
				eng = sc.nextInt();
				mat = sc.nextInt();
				stArr.add(new Student(sNum, kor,eng,mat));	
				korSum += kor;
				engSum += eng;
				matSum += mat;
				sNum++;
			}
			else if(choice ==2) {		//전체성적 출력
				System.out.println("전체성적출력");
				engAvg = engSum/ stArr.size();
				matAvg = matSum/stArr.size();	
				korAvg = korSum/stArr.size();
				sumSum = korSum + engSum + matSum;
				sumAvg = korAvg + engAvg + matAvg;
				avgSum = korAvg + engAvg + matAvg;
				avgAvg = avgSum/3;
				
				
				//등수
				//학점
				//장학금여부
				
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
						System.out.print("장학금");
					}
					System.out.println();
				}
				
				System.out.println("합계" + "   " + korSum + "   " + engSum + "   " + matSum + "   " + "0" + "   " + sumSum + "   " + sumAvg + "   " + "0");
				System.out.println("평균" + "   " + korAvg + "   " + engAvg + "   " + matAvg + "   " + "0" + "   " + avgSum + "   " + avgAvg + "   " + "0");

				
			}
			else if(choice ==3) {		//수상자 출력
				System.out.println("수상자출력");
				
				for(int i = 0 ; i< stArr.size(); i++) {
					if(stArr.get(i).flag) {
						System.out.println(stArr.get(i).sNum+ "  ");
					}
				}
			}
			else if(choice ==4) {		//종료
				System.out.println("종료");
				break;
			}
		}
	}

}







