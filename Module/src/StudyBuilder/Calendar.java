package StudyBuilder;

import java.util.Scanner;

public class Calendar {
	static int thisMonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static String weekname[] = {"일", "월", "화", "수", "목", "금", "토"};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		/*
		 * monthSet은 각 달에 대한 날짜들을 저장한 배열, year은 연도, month는 달, week는 요일, day는 일, i는 반복문을
		 * 사용하기 위한 변수.
		 */
		int year = 0, month = 0, week = 0, day = 0;

		while (true) {
			System.out.println("원하는 연도를 입력하세요. (0을 누르면 프로그램을 종료합니다.) : ");
			year = sc.nextInt();
			if (year == 0) {
				System.exit(0);
				break;
			}
			day = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400 ;
			
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) // 윤년의 조건.
				thisMonth[2] = 29; // 윤년이면 2월 (monthSet[1])은 29일,
			
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + year + "년" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
			
			int startchk = 0, endchk = 0, week_cnt = 0;
			int row_start[] = {0, 0, 0, 0};
			for(int row = 0; row < 3 ;) {
				if(startchk == 0) {
					dispMonWeek(row*4 + 1);
					row_start[0] = 0;
					row_start[1] = 0;
					row_start[2] = 0;
					row_start[3] = 0;
				}
				for(int col = 0 ; col < 4 ; col++) {
					month = row*4 + col + 1;
					if(startchk < 4) {
						row_start[col] = day%7 == 6 ? -1 : day%7;
						day += thisMonth[month];
						startchk++;
					}
					for(int i = 0; i < 7; i++ ) {
						int date = week_cnt*7 + i + (-1)*row_start[col];
						if(date < 1)
							System.out.print("\t");
						else if(date == thisMonth[month] +1 ) {
							System.out.print("\t");
							endchk++;
						}else if(date > thisMonth[month]+1 ) {
							System.out.print("\t");
						}
						else
							System.out.print(date + "\t");
						
					}

					System.out.print("\t");
				}
				week_cnt++;
				System.out.print("\n");
				if(endchk == 4) {
					startchk = 0;
					endchk = 0;
					week_cnt = 0;
					row++;
				}
			}
		}
	}
	
	public static void dispMonWeek(int startcol) {
		for(int i = startcol ; i < startcol+4 ; i++) {
			System.out.print("\t\t\t" + i + "월" + "\t\t\t\t\t");
		}

		System.out.print("\n");
		for(int i = startcol ; i < startcol+4 ; i++) {
			for(int j = 0 ; j < weekname.length ; j++) {
				System.out.print(weekname[j] + "\t");
			}
			System.out.print("\t");
		}
		System.out.print("\n");
		
	}
}
