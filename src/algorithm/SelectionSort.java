package algorithm;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {3,8,9,2,1};
		int least,temp,i,j = 0;
		for(i=0;i<arr.length-1;i++) // 마지막 숫자는 자동정렬 되기때문에 마지막숫자 정렬회차는 필요없다
		{
			least=i;
			
			for (j=i+1; j<arr.length;j++) // i+1~4
			{
				if(arr[j]<arr[least])				
					least=j;
			}
			
			if(least!=i)
			{
				temp = arr[least];
				arr[least] = arr[i];
				arr[i] = temp;
			}
		}
		
		for(int n : arr)
		{
			System.out.print(n+" ");	
		}
		
	}

}
