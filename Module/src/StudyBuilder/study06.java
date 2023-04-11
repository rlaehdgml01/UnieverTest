package StudyBuilder;

public class study06 {
	//6. 괄호 타당성 확인
	public static boolean study06(String str) {
		int count=0;
		boolean result = false;
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i)=='(') {
				count++;
			}
			else if(str.charAt(i)==')') {
				count--;
			}

		}
		if(count != 0) {
			result = false;
		}
		else if(str.charAt(0)==')' || str.charAt(str.length()-1)=='(') {
			result = false;
		}
		else {
			result = true;
		}
		System.out.println(result);
		return result;
		
	}
}
