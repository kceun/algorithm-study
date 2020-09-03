package algorithm;

public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {1,7,9,10,3,2};
		int temp;
		for(int num : arr)
		{
			System.out.print(num +" ");
		}
		System.out.println();
		for(int i=arr.length-1;i>0;i--)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				System.out.print(i+ " ");
			}
					
		}
		System.out.println();
		System.out.println("================");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");		
		}
	}

}
