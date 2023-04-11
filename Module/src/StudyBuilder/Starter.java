package StudyBuilder;

import java.util.Scanner;
import java.util.stream.Stream;

public class Starter {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("실행할 문제의 번호를 입력하세요 : ");
		int qn = sc.nextInt();
		int[] arr=null;
		switch(qn) {
			case 1 : {
				int argument=getIntInput();
				study01.study01(argument);
				break;
			}
			case 2 : {
				String argument = getStringInput();
				study02.study02(argument);
				break;
			}
			case 3 : {
				int[] argument = getArrayInput();
				study03.study03(argument);
				break;
			}
			case 4 : {
				int[] argument = getArrayInput();
				study04.study04(argument);
				break;
			}
			case 5 : {
				int argument1 = getIntInput();
				int argument2 = getIntInput();
				study05.study05(argument1,argument2);
				break;
			}
			case 6 : {
				String argument = getStringInput();
				study06.study06(argument);
				break;
			}
			case 7 : {
				int argument=getIntInput();
				study07.study07_1(argument);
				break;
			}
			case 8 : {
				String argument = getStringInput();
				study08.study08(argument);
				break;
			}
			case 9 : {
				int argument=getIntInput();
				study09.study09(argument);
				break;
			}
			case 10 : {
				int argument=getIntInput();
				study10.study10(argument);
				break;
			}
		}

		//study09.study09(7);
		//study10.study10(2023);
	}
	private static int getIntInput() {
		System.out.print("정수를 입력하세요 : ");
		int argument = sc.nextInt();
		return argument;
	}
	private static int[] getArrayInput() {
		System.out.print("배열을 입력하세요 : ");
		String str = sc.next();
		int[] argument = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
		return argument;
	}
	private static String getStringInput() {
		System.out.print("문자열을 입력하세요 : ");
		String argument = sc.next();
		return argument;
	}
	

}
