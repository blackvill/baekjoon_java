package BOJ_bronze;

import java.util.Scanner;

public class Main_B4_1297 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int diag = sc.nextInt();// 대각선 길이
		int height = sc.nextInt();    // 높이 비율
		int width = sc.nextInt();    // 너비 비율

		sc.close();

		double d = Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2)); // 대각선 비율

		int h = (int) Math.floor(height * (diag / d));
		int w = (int) Math.floor(width * (diag / d));

		System.out.println(h + " " + w);

	}
}