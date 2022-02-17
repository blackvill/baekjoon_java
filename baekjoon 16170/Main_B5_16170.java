package BOJ_bronze;

import java.util.Calendar;

public class Main_B5_16170 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(cal.YEAR));
		System.out.println(cal.get(cal.MONTH) + 1);
		System.out.println(cal.get(cal.DATE));
	}
}
