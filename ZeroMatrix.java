class ZeroMatrix{
	public static void checkZero(int[][] arr){
		if(arr == null || arr.length <= 1)
			return;
		int r = arr.length;
		int c = arr[0].length;
		
		for(int i = 1; i < r; i++){
			for(int j = 1; j < c; j++){
				if(arr[i][j] == 0){
					arr[0][j] = 0;
					arr[i][0] = 0;
				}
			}
		}
		
		for(int i = 1; i < r; i++){
			if(arr[i][0] == 0){
				for(int j = 1; j < c; j++){
					arr[i][j] = 0;
				}
			}
		}
		
		for(int j = 1; j < c; j++){
			if(arr[0][j] == 0){
				for(int i = 1; i < r; i++){
					arr[i][j] = 0;
				}
			}
		}
		
		if(arr[0][0] == 0){
			for(int i =0; i< r; i++){
				arr[i][0] = 0;
			}
			for(int j =0; j< c; j++){
				arr[0][j] = 0;
			}
		}
		
	}
	
	public static void main(String[] args){
		int a[][] = {{1,2,3,4,5},{6,7,0,9,10},{11,12,0,0,15},{16,17,18,19,20},{21,22,23,24,25}};
		checkZero(a);
		for(int i = 0; i < a.length; i++ ){
			for(int j = 0; j <a[0].length; j++){
				System.out.print(a[i][j] +" ");
			}
			System.out.println();
		}
		
	}
}