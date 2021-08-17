package com.ssafy.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_S2_1931 {

	static class Room implements Comparable<Room> {
		int stime; // 시작시간
		int etime; // 종료시간

		public Room(int stime, int etime) {
			this.stime = stime;
			this.etime = etime;
		}

		@Override
		public int compareTo(Room o) {
			int time = etime - o.etime; // 종료시간을 오름차순으로 정렬
			if (time == 0) { //종료시간이 같다면
				time = stime - o.stime; // 시작시간으로 정렬
			}
			return time;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Room> list = new ArrayList<>(n);
		String line;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Room(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
					));
		}
		// 최고의 가치를 기준으로 정렬
		Collections.sort(list);

		ArrayList<Integer> cnums = new ArrayList<>(n);
		// 첫번째가 최고의 가치이므로 선택
		// 종료시간과 시작시간을 비교해 줘야하므로
		int end = list.get(0).etime;
		int count = 1;
		for (int i = 1; i < n; i++) {
			//다음 선택할 회의는 종료 시간이 빠르면서 이전 회의 종료시간 이후에 열리는 첫 회의
			if (end <= list.get(i).stime) {
				end = list.get(i).etime;
				count++;
			}
		}
		System.out.println(count);
	}
}
