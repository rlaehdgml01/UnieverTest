package StudyBuilder;

public class study05 {
	//5. a부터 n까지 1씩 순차적으로 증가하는 숫자의 합
		public static int study05(int a, int n) {
			int result = n*(n+a)/2;
			System.out.println(result);
			return result;
		}
		//5_1. 위와 똑같은지 확인
		public static int study05_1(int a, int n) {
			int sum=0;
			for(int i=a;i<=n;i++) {
				sum+=i;
			}
			System.out.println(sum); 
			return sum;
		}
}
