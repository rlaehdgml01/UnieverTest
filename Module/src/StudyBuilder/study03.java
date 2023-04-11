package StudyBuilder;

public class study03 {
	//3. 정렬(버블 정렬)
	public static void study03(int[] arr) {
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int j=0;j<arr.length;j++) {
			System.out.print(arr[j]+" ");	
		}	
	}
}
