package StudyBuilder;

public class study07 {
	//7. 십진수 -> 이진수 변환
	public static void study07(int num) {
		int i=0;
		String str = "";
		while(num != 0) {
			//str.charAt(i) = Integer.toString(num%2);
			num = num/2;
			i++;
		}
		for(int j=i-1;j>=0;j--) {
			System.out.println(str.charAt(j));
		}
	}
	
	//7_1. toBinaryString()
	public static void study07_1(int num) {
		String binary = Integer.toBinaryString(num);
		System.out.println(binary);
	}
}
