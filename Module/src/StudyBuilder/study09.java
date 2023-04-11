package StudyBuilder;

import java.util.Arrays;

public class study09 {
	//9. 달팽이 숫자 그리기
	public static void study09(int num) {
		int[][] arr = new int[num][num]; 	//숫자를 담을 배열 생성
		arr[0][0] = 1;     					//배열의 맨 처음 값 1
			
		int a=0,b=0;
		int r=1,side=num-1;					//만약 행 수가 5라면 side는 4
			
		while(true) {
			
			if(r==1) {
				for(int i = 0; i< side;i++) { //첫 번째 반복만 한번 더 반복 이후 모두 두 번 반복 
					arr[a][++b] = ++r;
				}
			}
	
			for(int i = 0;i<side;i++) {    	// 아래 방향,왼쪽 방향 각각 반복 후 
										 	//side--
				arr[++a][b] = ++r;
			}
			for(int i = 0;i<side;i++) {
				arr[a][--b] = ++r;
			}
			side--;
			for(int i=0;i<side;i++) {		// 위 방향, 오른쪽 방향 각각 반복 후
				arr[--a][b] = ++r;			//side--
			}
			for(int i=0;i<side;i++) {
				arr[a][++b] = ++r;
			}
			side--;
			if(r==num*num) break;
		}
		for(int[] i : arr) {               	//확장for문으로 배열 읽기
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
