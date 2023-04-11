package StudyBuilder;

public class study10 {
	//10. 만년 달력
	
	public static void study10(int num) {
		// 1월 1일이 무슨 요일인지 확인
	    int firstDayWeek =  (num - 1) * 365 + (num - 1) / 4 - (num - 1) / 100 + (num - 1) / 400; //0이 일요일, 6이 토요일

	    // 각 달의 일 수를 저장한 배열
	    int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	    // 윤년이면 2월 일 수를 29로 설정 (4년마다 발생,100의 배수가 아니거나 400의 배수인 해를 윤년으로 계산
	    if ((num % 4 == 0 && num % 100 != 0) || num % 400 == 0) {
	        monthDays[1] = 29; //monthDays배열의 두번째 즉 2월에 29로 저장
	    }

	    // 달력 출력
	    for (int month = 1; month <= 12; month++) {
	    	
	        System.out.println("      " + num + "년 " + month + "월");
	        System.out.println("  일  월  화  수  목  금  토  ");
	        
	        // 해당 월의 1일의 요일을 출력(1일의 요일 위치를 잡기 위해firstDayWeek 만큼 공백 출력)
	        for (int i = 0; i < firstDayWeek; i++) {
	        	firstDayWeek++;
	            System.out.print("    ");			   
	        }

	        
	        for (int day = 1; day <= monthDays[month-1]; day++) { 
	            System.out.printf("%3d ", day); 	//%3d는 날짜간 공백 조절을 위해 사용
	            
	            // 요일이 일요일부터 다시 시작하도록 설정(firstDayWeek가 6, 즉 토요일이 되었을 때 줄 바꿈 
	            if (firstDayWeek % 7 == 0) {
	                firstDayWeek = 0;
	                System.out.println();
	            }
	        }
	        System.out.println();
	    } // 12월 동안 반복
	
	}
}
