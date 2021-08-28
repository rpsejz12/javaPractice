package javaPractice;

import java.util.Scanner;

class game{
	String name;
	static int bomb = 100;
	
	game(String name){
		this.name = name;
	}
	
	boolean game(int n) {
		bomb -= n;
		if(this.bomb <= 0) {
			System.out.println(this.name + "패배");
			return false;
		}
		return true;
	}
}

public class bomb {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		System.out.println("플레이어 수 입력 : ");
		n = sc.nextInt();
		
		game[] a = new game[n];
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println("플레이어 이름 입력 :");
			a[i]= new game(sc.next());
		}
		
		int i = 0;
		while(true) {
			System.out.println("수 입력 :");
			a[i].game(sc.nextInt());	
			
			i++;
			i %= n;
			
		}
		
		
		
		

	}
}
