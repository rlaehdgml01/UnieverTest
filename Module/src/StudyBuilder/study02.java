package StudyBuilder;

public class study02 {
	
	//2. 회문 검사
	public static boolean study02(String str) {
		
		for(int i=0; i<str.length()/2;i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) {
				System.out.println("false");
				return false;
			}
		}
		System.out.println("true");
		return true;
	}
}
