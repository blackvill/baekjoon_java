package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_S4_10825 {
	static int n;

	public static class Student implements Comparable<Student> {
		String name;
		int korean;
		int english;
		int math;
		
		public Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
		
		@Override
		public int compareTo(Student student) {
			if(this.korean < student.korean) {
				return 1;
			}
			else if(this.korean == student.korean) {
				if(this.english > student.english) {
					return 1;
				}
				else if(this.english == student.english) {
					if(this.math < student.math){
						return 1;
					}
					else if(this.math == student.math) {
						if(this.name.compareTo(student.name) > 0) {
							return 1;
						}
					}
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		ArrayList<Student> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String Name = st.nextToken();
			int Korean = Integer.parseInt(st.nextToken());
			int English = Integer.parseInt(st.nextToken());
			int Math = Integer.parseInt(st.nextToken());
			
			list.add(new Student(Name, Korean, English, Math));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < n; i++) {
			System.out.println(list.get(i).name);
		}
	}
}
