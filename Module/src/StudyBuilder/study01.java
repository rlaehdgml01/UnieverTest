package StudyBuilder;

public class study01 {
	//1. 피라미드 그리기
	public static void study01(int num) {
		for(int i=0;i < num; i++) {
			for (int j=1;j<=num-i;j++) {
				System.out.print(" "); // 공백 하나씩 덜 출력
			}
			for(int k=0;k<(i*2)+1;k++) {
				System.out.print("*"); // * 하나씩 더 출력
			}
			System.out.println("");
		}
	}
}
