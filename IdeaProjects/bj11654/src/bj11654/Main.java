package bj11654;

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
 
public class Main {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		char str = br.readLine().charAt(0);
		int n = (int)str;
		
		bw.write(n);
		bw.flush();
		bw.close();
	}
}
*/

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c = sc.nextLine().charAt(0);
		int n = (int)c;
		
		System.out.println(n);
		sc.close();
	}
}