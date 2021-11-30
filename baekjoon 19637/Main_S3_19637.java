package BOJ_silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_S3_19637 {
	static int n;
	static int m;
	static String str[];
	static int arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] str = new String[100001];
		int[] arr = new int[100001];

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			str[i] = st.nextToken(); // 칭호 이름
			arr[i] = Integer.parseInt(st.nextToken()); // 전투력 상한값
		}
		
		for(int i = 0; i < m; i++)
		{
			int num = Integer.parseInt(br.readLine());
			
			// 이분탐색
			int l = 0;
			int r = n - 1;
			
			while(l <= r)
			{
				int mid = (l + r) / 2;
				
				if (arr[mid] < num)
				{
					l= mid + 1;
				}
				else {
					r = mid - 1;
				}
			}
			
			bw.write(str[l] + "\n");
		}
		bw.flush();
	}
}