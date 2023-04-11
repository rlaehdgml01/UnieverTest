package StudyBuilder;

public class study08 {
	//8. 이진수 -> 십진수 변환
	public static void study08(String str_num) {
		int num = 0,count = 0,temp = 0;
		for(int i = str_num.length()-1;i>=0;i--) {
			temp = str_num.charAt(i)-'0';
			num += temp * Math.pow(2,count);
			count++;
		}
		System.out.println(num);
	}
	
	//8_1. parseInt
	public static void study08_1(String str_num) {
		int num = Integer.parseInt(str_num,2);
		System.out.println(num);
	}
}
