package javaPractice;

import java.util.Random;

public class max {
	public static void main(String[] args) {
		int[] a = new int[5];
		int[] b = new int[5];

		Random rand = new Random();

		for(int i = 0 ; i < a.length ; i++) {
			a[i]= rand.nextInt(9)+1;

		}		
		for(int v : a) {
			System.out.println(v);
		}

		for(int i = a.length-1 ; i >= 0; i--) {
			for(int j = i-1; j >= 0; j--) {
				if(a[i]< a[j]) {
					b[i] = j+1;
					break;		
				}
			}
		}

		for(int v : b) {
			System.out.println(v);
		}

	}

}
