package StudyBuilder;

public class study04 {
	//4. 역정렬
	public static void study04(int[] arr) {
		int temp=0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]+" ");	
		}
	}
	
	//4_1. 선택 정렬
	public static void study04_1(int[] arr) {
		int least=0,temp=0;
		for(int i=0;i<arr.length-1;i++) {
			least=i;
			
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[least]) {
					least=j;
				}
			}
			temp = arr[least];
			arr[least] = arr[i];
			arr[i] = temp;
		}
		System.out.println(arr);
	}
	
	//4_2. 이진 삽입 정렬
	public static void study04_2(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int target = arr[i];
			//이분탐색을 통해 target이 들어가야 할 위치를 얻는다.
			int location = binarySearch(arr,target,0,i);
			
			int j=i-1;
			
			while(j >= location) {
				arr[j+1]=arr[j]; // 이전 원소를 한 칸 씩 뒤로 미룬다.
				j--;
			}
			arr[location] =target;
		}
	}
	
	
	//4_2_1. 이진 탐색
	public static int binarySearch(int[] arr, int key, int low, int high) {
		int mid;
		while(low < high) {
			mid = low + ((high-low)/2);
			
			if(key < arr[mid]) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		return low;
	}
}
